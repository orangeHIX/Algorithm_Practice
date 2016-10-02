package com.creaty.object_class.statemachine;

/**
 * 洗衣状态
 * Created by hyx on 2015/11/13.
 */
public class WashingClothes extends Context implements State {

    public WashingClothes(Context father) {
        super(father);
    }

    @Override
    public void entry() {
        System.out.println(this.getClass().getName() + ": entry()");
        System.out.println("设置定时器，加洗衣剂，开指示灯");
        setState(new Washing(this));
    }


    @Override
    public boolean handle(Context context, Object event) {
        //System.out.println(this.getClass().getName() + "handle event:" + event);
        if (state.handle(this, event)) {
            return true;
        } else {
            if (event == WashMachine.PRESS_BUTTON) {
                System.out.println("计时器增加一周期");
                return true;
            } else if (event == WashMachine.OPEN_DOOR) {
                context.setState(new WashingInterrupt());
                return true;
            }
            return false;
        }
    }

    @Override
    protected void leave() {
        if (father != null) {
            father.setState(new WashingFinish());
        }
    }

    /**
     * 洗涤状态
     */
    class Washing extends Context implements State {
        int washingTimes;

        public Washing(Context father) {
            super(father);
            washingTimes = 0;
        }

        @Override
        public void entry() {
            System.out.println(this.getClass().getName() + ": entry()");
            setState(new Inlet());
        }


        @Override
        public boolean handle(Context context, Object event) {
            if(state.handle(this, event)){
                return true;
            }else{
                return false;
            }
        }

        @Override
        protected void leave() {
            if (father != null) {
                father.setState(new Dewatering());
            }
        }

        /**
         * 进水状态
         */
        class Inlet implements State {


            @Override
            public void entry() {
                System.out.println(this.getClass().getName() + ": entry()");
                System.out.println("开进水阀");
            }

            @Override
            public void exit() {
                System.out.println(this.getClass().getName() + ": exit()");
                System.out.println("关进水阀");
            }

            @Override
            public boolean handle(Context context, Object event) {
                //System.out.println("handle event:" + event);
                if (event == WashMachine.FULL) {
                    context.setState(new Rinse());
                    return true;
                }
                return false;
            }
        }

        /**
         * 漂洗状态
         */
        class Rinse implements State {

            @Override
            public void entry() {
                System.out.println(this.getClass().getName() + ": entry()");
                System.out.println("开马达");
            }

            @Override
            public void exit() {
                System.out.println(this.getClass().getName() + ": exit()");
                System.out.println("关马达");
            }

            @Override
            public void doWhileTrue() {
                System.out.println(this.getClass().getName() + ": doWhileTrue()");
                System.out.println("搅动");
            }

            @Override
            public boolean handle(Context context, Object event) {
                if (event == WashMachine.ONE_HOUR_LATER) {
                    context.setState(new Drainage());
                    return true;
                }
                return false;
            }
        }

        /**
         * 排水状态
         */
        class Drainage implements State {

            @Override
            public void entry() {
                System.out.println(this.getClass().getName() + ": entry()");
                System.out.println("开排水阀，开马达");
            }

            @Override
            public void exit() {
                System.out.println(this.getClass().getName() + ": exit()");
                System.out.println("关排水阀，关马达");
            }

            @Override
            public void doWhileTrue() {
                System.out.println(this.getClass().getName() + ": doWhileTrue()");
                System.out.println("抽水");
            }

            @Override
            public boolean handle(Context context, Object event) {
                if (event == WashMachine.DRAINAGE_COMPLETE) {
                    washingTimes++;
                    if (washingTimes <= 3) {
                        context.setState(new Inlet());
                    } else {
                        System.out.println(getClass().getName() + " leave");
                        context.leave();
                    }
                    return true;
                }
                return false;
            }
        }
    }

    /**
     * 脱水状态
     */
    class Dewatering implements State {

        @Override
        public void entry() {
            System.out.println(this.getClass().getName() + ": entry()");
            System.out.println("开马达，开排水阀");
        }

        @Override
        public void doWhileTrue() {
            System.out.println(this.getClass().getName() + ": doWhileTrue()");
            System.out.println("脱水");
        }

        @Override
        public boolean handle(Context context, Object event) {
            if (event == WashMachine.TWENTY_MINUTES_LATER) {
                System.out.println(getClass().getName() + " leave");
                context.leave();
                return true;
            }
            return false;
        }
    }
}
