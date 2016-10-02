package com.creaty.object_class.statemachine;

/**
 * Created by hyx on 2015/11/13.
 */
public class WashingFinish implements State {
    @Override
    public void entry() {
        System.out.println(this.getClass().getName() + ": entry()");
        System.out.println("关灯,关马达，发出滴滴声");
    }


    @Override
    public boolean handle(Context context, Object event) {
        if (event == WashMachine.OPEN_DOOR) {
            context.setState(new IdleOpen());
            return true;
        }
        return false;
    }
}
