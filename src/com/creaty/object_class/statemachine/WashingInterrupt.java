package com.creaty.object_class.statemachine;

/**
 * Created by hyx on 2015/11/13.
 */
public class WashingInterrupt implements State {
    @Override
    public void entry() {
        System.out.println(this.getClass().getName() + ": entry()");
        System.out.println("关马达，清除计时器");
    }


    @Override
    public boolean handle(Context context, Object event) {
        if (event == WashMachine.CLOSE_DOOR){
            context.recover();
            return true;
        }
        return false;
    }
}
