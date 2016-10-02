package com.creaty.javaclass.json;

import java.lang.reflect.Constructor;

/**
 * 此类用于处理json字符串基本元素的值(value) {key1:value1, key2:value2, key3:value3}
 * Created by hyx on 2015/12/8.
 */
class MyJSONValue {

    private static final Class[] classes = {Byte.class, Short.class, Integer.class, Long.class,
            Float.class, Double.class, Boolean.class};
    private static final Class[] baseClasses = {byte.class, short.class, int.class, long.class,
            float.class, double.class, boolean.class};


    public static String toJSONValueString(Object value){

        if (value == null) {
            return "null";
        }

        Class valueClass = value.getClass();

        if (valueClass.isArray()) {
            return new MyJSONArray(value).toJSONString();
        }

        for (Class cla : classes) {
            if (valueClass == cla) {
                return value.toString();
            }
        }

        for (Class cla : baseClasses) {
            if (valueClass == cla) {
                return value.toString();
            }
        }
        if (valueClass == char.class || valueClass == Character.class) {
            return value.toString();
        }
        if( valueClass == String.class){
            return "\""+value+"\"";
        }
        return MyJSONObject.toJSONString(value);
    }

    public static Object toValueObject(Class valueClass, String str){
        if (str == null || str.compareTo("null") == 0 || valueClass == null) {
            return null;
        }
        if (valueClass.isArray()) {
            MyJSONArray myJSONArray = new MyJSONArray(valueClass, str);
            return myJSONArray.toObject();
        }
        for (Class c : classes) {
            if (c == valueClass) {
                try {
                    Constructor con = valueClass.getConstructor(String.class);
                    return con.newInstance(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0; i < baseClasses.length; i++) {
            if (baseClasses[i] == valueClass) {
                try {
                    Constructor con = classes[i].getConstructor(String.class);
                    return con.newInstance(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (valueClass == char.class || valueClass == Character.class) {
            return str.charAt(0);
        }
        if( valueClass == String.class){
            return str.substring(1,str.length()-1);
        }
        return MyJSONObject.toObject(valueClass, str);
    }
}
