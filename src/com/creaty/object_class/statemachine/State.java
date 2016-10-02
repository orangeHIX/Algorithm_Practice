package com.creaty.object_class.statemachine;

/**
 * Created by hyx on 2015/11/13.
 */
public interface State {

    default void entry(){};
    default void exit(){};
    default void doWhileTrue(){};
    /**处理事件
     * @param context 状态机
     * @param event 要处理的事件
     * @return 事件是否已经被处理*/
    boolean handle(Context context, Object event);

}
