package com.creaty.javaclass.json;

/**
 * 此类用于分割一段json字符串中基本元素(key:value) {key1:value1, key2:value2, key3:value3}
 * Created by hyx on 2015/12/9.
 */
class MyJSONStringTokener {

    private String subStr;
    private int tokenStart;
    private boolean hasNext;
    private char[] stack;
    private int top;

    private MyJSONStringTokener(String JSONString) {
        JSONString = JSONString.trim();
        if ((JSONString.startsWith("{") && JSONString.endsWith("}"))
                || (JSONString.startsWith("[") && JSONString.endsWith("]"))) {
            subStr = JSONString.substring(1, JSONString.length() - 1).trim();
            if (subStr.isEmpty()) {
                hasNext = false;
            } else {
                hasNext = true;
                stack = new char[subStr.length()];
                top = 0;
                tokenStart = 0;
            }
        }
    }

    static MyJSONStringTokener newInstance(String JSONString) {
        return new MyJSONStringTokener(JSONString);
    }

    public String next() {
        char cur;
        String result = null;
        for (int i = tokenStart; i < subStr.length(); i++) {
            cur = subStr.charAt(i);
            //System.out.println("i: "+i+", cur: "+cur);
            switch (cur) {
                case '{':
                case '[':
                    stack[top++] = cur;
                    break;
                case '}':
                    if (stack[top - 1] == '{') {
                        top--;
                    }
                    break;
                case ']':
                    if (stack[top - 1] == '[') {
                        top--;
                    }
                    break;
                case ',':
                    if (top == 0) {
                        result = subStr.substring(tokenStart, i);
                        tokenStart = i + 1;
                    }
                    break;
                default:
            }
            if (result != null) {
                //System.out.println(":::"+tokenStart+" length "+ subStr.length());
                return result.trim();
            }
        }
        hasNext = false;
        return subStr.substring(tokenStart).trim();
    }

    public boolean hasNext() {
        return hasNext;
    }
}
