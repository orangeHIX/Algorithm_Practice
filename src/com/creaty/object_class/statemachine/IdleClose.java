package com.creaty.object_class.statemachine;

/** 空闲门关状态
 * Created by hyx on 2015/11/13.
 */
public class IdleClose implements State {


    @Override
    public void entry() {
        System.out.println(this.getClass().getName()+": entry()");
        System.out.println("关指示灯");
    }

    @Override
    public boolean handle(Context context, Object event) {
        if (event == WashMachine.PRESS_BUTTON) {
            context.setState(new WashingClothes(context));
            return true;
        } else if (event == WashMachine.OPEN_DOOR) {
            context.setState(new IdleOpen());
            return true;
        }
        return false;
    }
}
