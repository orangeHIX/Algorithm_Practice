package com.creaty.object_class.statemachine;

import java.util.ArrayList;

/**
 * Created by hyx on 2015/11/13.
 */
public class WashMachine extends Context {

    public static final String CLOSE_DOOR = "关门";
    public static final String OPEN_DOOR = "开门";
    public static final String PRESS_BUTTON = "按按钮";
    public static final String FULL = "水满";
    public static final String ONE_HOUR_LATER = "1小时后";
    public static final String DRAINAGE_COMPLETE = "排水完成";
    public static final String TWENTY_MINUTES_LATER = "20分钟后";

    public WashMachine() {
        setState(new IdleClose());
    }

    @Override
    protected void leave() {

    }

    public void dosomething(Object event) {
        state.handle(this, event);
    }


    public static void main(String[] args) {
        ArrayList<String> events = new ArrayList<>();
        events.add(OPEN_DOOR);
        events.add(CLOSE_DOOR);
        events.add(PRESS_BUTTON);
        events.add(OPEN_DOOR);
        events.add(CLOSE_DOOR);
        events.add(FULL);
        events.add(OPEN_DOOR);
        events.add(CLOSE_DOOR);
        events.add(ONE_HOUR_LATER);
        events.add(OPEN_DOOR);
        events.add(CLOSE_DOOR);
        events.add(DRAINAGE_COMPLETE);

        events.add(FULL);
        events.add(ONE_HOUR_LATER);
        events.add(DRAINAGE_COMPLETE);

        events.add(FULL);
        events.add(ONE_HOUR_LATER);
        events.add(DRAINAGE_COMPLETE);

        events.add(FULL);
        events.add(ONE_HOUR_LATER);
        events.add(DRAINAGE_COMPLETE);

        events.add(TWENTY_MINUTES_LATER);
        events.add(OPEN_DOOR);

        WashMachine machine = new WashMachine();
        events.stream().forEach(machine::dosomething);

    }
}
