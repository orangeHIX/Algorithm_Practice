package com.creaty.javaclass.json;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个类用于处理json中数组 [element1, element2, element3]
 * Created by hyx on 2015/12/8.
 */
class MyJSONArray {

    private static final Class[] classes = {Byte.class, Short.class, Integer.class, Long.class,
            Float.class, Double.class, Boolean.class, String.class};
    private static final Class[] baseClasses = {byte.class, short.class, int.class, long.class,
            float.class, double.class, boolean.class};

    private Object o;
    private Class cla;
    private String JSONString;
    List<String> JSONStringArray;

    public MyJSONArray(Object o) {

        if (o.getClass().isArray()) {
            this.o = o;
            this.cla = o.getClass();
            JSONStringArray = new ArrayList<>();
        }
    }

    public MyJSONArray(Class cla, String JSONString) {
        //Array.newInstance();
        if (cla != null && JSONString != null) {
            this.cla = cla;
            this.JSONString = JSONString.trim();
            JSONStringArray = new ArrayList<>();
        }
    }

    public Object toObject() {
        updateJSONStringArrayGivenJSONString();
        int length = JSONStringArray.size();
        this.o = Array.newInstance(cla.getComponentType(), length);
        for (int i = 0; i < length; i++) {
            Array.set(o, i, MyJSONValue.toValueObject(cla.getComponentType(), JSONStringArray.get(i)));
        }
        return o;
    }

    public String toJSONString() {
        updateJSONStringArrayGivenObject();
        StringBuilder sb = new StringBuilder("[");
        for (String s : JSONStringArray) {
            sb.append(s).append(",");
        }
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }

    private void updateJSONStringArrayGivenObject() {
        JSONStringArray.clear();
        if (o != null) {
            int length = Array.getLength(o);

            //Class eleCla = cla.getComponentType();
            for (int i = 0; i < length; i++) {
                JSONStringArray.add(MyJSONValue.toJSONValueString(Array.get(o, i)));
            }
        }
    }

    private void updateJSONStringArrayGivenJSONString() {
        JSONStringArray.clear();
        if (cla != null && JSONString != null && JSONString.startsWith("[") && JSONString.endsWith("]")) {
            MyJSONStringTokener stringTokener = MyJSONStringTokener.newInstance(JSONString);
            while (stringTokener.hasNext()) {
                JSONStringArray.add(stringTokener.next());
            }
        }
    }

}
