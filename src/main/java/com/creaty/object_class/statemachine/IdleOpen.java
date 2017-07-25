package com.creaty.object_class.statemachine;

/**
 * 空闲门开状态
 * Created by hyx on 2015/11/13.
 */
public class IdleOpen implements State {
    @Override
    public void entry() {
        System.out.println(this.getClass().getName() + ": entry()");
        System.out.println("开指示灯");
    }


    @Override
    public boolean handle(Context context, Object event) {
        if (event == WashMachine.CLOSE_DOOR) {
            context.setState(new IdleClose());
            return true;
        }
        return false;
    }
}
