package com.creaty.offer;

import java.util.Stack;

/**
 * Created by hyx on 2017/9/8.
 */
public class StackWithMin {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public StackWithMin(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public Integer pop(){
        minStack.pop();
        return stack.pop();
    }

    public void push(Integer i){
        if( i != null){
            Integer min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
            stack.push(i);
            if( i < min){
                minStack.push(i);
            }else {
                minStack.push(min);
            }
        }
    }

    public Integer min(){
        if(minStack.isEmpty()) return null;
        return minStack.peek();
    }


    public static void main(String[] args){
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(3);
        System.out.println(stackWithMin.min());
        stackWithMin.push(4);
        System.out.println(stackWithMin.min());
        stackWithMin.push(2);
        System.out.println(stackWithMin.min());
        stackWithMin.push(1);
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.push(0);
        System.out.println(stackWithMin.min());
    }
}
