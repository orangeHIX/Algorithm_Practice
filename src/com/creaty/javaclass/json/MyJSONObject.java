package com.creaty.javaclass.json;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyx on 2015/12/8.
 */
public class MyJSONObject {
    /**
     * 给定对象创建JSON字符串
     *
     * @param o 给定的对象
     */
    public static String toJSONString(Object o) {
        return new MyJSONObject(o).getJSONString();
    }

    /**
     * 给定JSON字符串创建指定对象
     *
     * @param cla        JSON字符串表示的对象所从属的类
     * @param jsonString 给定的JSON字符串
     */
    public static Object toObject(Class<?> cla, String jsonString) {
        return new MyJSONObject(cla, jsonString).getObject();
    }


    private Class cla;
    private Method[] methods;
    private Field[] fields;
    private Object o;
    private Map<String, String> jsonPairs;
    private String jsonString;

    /**
     * 给定JSON字符串创建MyJSONObject对象
     *
     * @param cla        JSON字符串表示的对象所从属的类
     * @param jsonString 给定的JSON字符串
     */
    private MyJSONObject(Class<?> cla, String jsonString) {
        if (cla != null && jsonString != null && jsonString.startsWith("{") && jsonString.endsWith("}")) {
            try {

                this.cla = cla;
                methods = this.cla.getMethods();
                fields = this.cla.getDeclaredFields();
                jsonPairs = new HashMap<>();
                this.jsonString = jsonString.trim();
                this.o = buildObject();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给定对象创建MyJSONObject对象
     *
     * @param o 给定的对象
     */
    private MyJSONObject(Object o) {
        if (o != null) {
            try {
                this.o = o;
                cla = o.getClass();
                methods = cla.getMethods();
                //System.out.println(cla);
                fields = cla.getDeclaredFields();
                jsonPairs = new HashMap<>();
                jsonString = buildJSONString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Object buildObject() {
        Object object = null;
        try {
            object = cla.newInstance();
            putValuePairsFromJOSNString();
            updateObjectFields(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    private String buildJSONString() {
        try {
            putValuePairsGivenObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder("{");
        for (String fieldName : jsonPairs.keySet()) {
            sb.append(fieldName).append(':').append(jsonPairs.get(fieldName)).append(',');
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.replace(sb.length() - 1, sb.length(), "}");
        } else {
            sb.append('}');
        }
        return sb.toString();
    }

    public Object getObject() {
        return o;
    }

    public String getJSONString() {
        return jsonString;
    }

    private Field getMatchingField(String prefix, String methodName) {

        if (prefix == null) {
            return null;
        }
        int preLen = prefix.length();
        //例如setAbc() X要小写 得到对应的field： abc
        String fieldName1 = methodName.substring(preLen, preLen + 1).toLowerCase() + methodName.substring(preLen + 1);
        //或者 A本身是大写的 得到对应的field： Abc
        String fieldName2 = methodName.substring(preLen);
        for (Field f : fields) {
            if (f.isAnnotationPresent(MySerialize.class)) {
                if (f.getName().compareTo(fieldName1) == 0) {
                    return f;
                } else if (f.getName().compareTo(fieldName2) == 0) {
                    return f;
                }
            }
        }
        return null;
    }


    private void putValuePairsGivenObject() throws IllegalAccessException, InvocationTargetException {
        jsonPairs.clear();
        for (Method m : methods) {
            String methodName = m.getName();
            if (methodName.compareTo("getClass") != 0) {
                Field f = null;
                if (methodName.startsWith("get")) {
                    f = getMatchingField("get", methodName);
                } else if (methodName.startsWith("is")) {
                    f = getMatchingField("is", methodName);
                }
                if (f != null) {
                    //System.out.println("object:" + o + " method: " + m);
                    String s = MyJSONValue.toJSONValueString(m.invoke(o, null));
                    jsonPairs.put(f.getName(), s);
                    //System.out.println("" + fieldName + "," + value);
                }
            }
        }
    }

    private void putValuePairsFromJOSNString() {
        jsonPairs.clear();
        MyJSONStringTokener stringTokener = MyJSONStringTokener.newInstance(jsonString);
        while (stringTokener.hasNext()) {
            String s = stringTokener.next();
            //System.out.println("putValuePairsFromJOSNString(): "+s);
            int semicolonIndex = s.indexOf(':');
            //System.out.println("putValuePairsFromJOSNString: "+ss[0]+","+ss[1]);
            jsonPairs.put(s.substring(0, semicolonIndex), s.substring(semicolonIndex + 1));
        }
    }

    private void updateObjectFields(Object object) throws IllegalAccessException, InvocationTargetException {

        for (Method m : methods) {
            String methodName = m.getName();
            if (methodName.startsWith("set")) {
                Field targetField = getMatchingField("set", methodName);

                if (targetField != null) {
//                    System.out.println("field type" + targetField.getType() + ","
//                            + targetField.getName() + "," + jsonPairs.get(targetField.getName()));
                    Object value = MyJSONValue.toValueObject(targetField.getType(),
                            jsonPairs.get(targetField.getName()));
//                    System.out.println("methodName: " + methodName + " class name: " + object.getClass().getName() + ", value: " + value);
                    m.invoke(object, value);
                }
            }
        }
    }

}
