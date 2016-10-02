package com.creaty.object_class.statemachine;

/**
 * 上下文环境/状态机本身
 * Created by hyx on 2015/11/13.
 */
public abstract class Context {
    final Context father;
    protected State state;
    protected State history;

    public Context() {
        this(null);
    }

    public Context(Context father) {
        this.father = father;
    }

    protected void setState(State state) {
        if (state != null) {
            if (this.state != null) {
                this.state.exit();
            }
            save();
            this.state = state;
            this.state.entry();
            this.state.doWhileTrue();
        }
    }

    /**
     * 恢复状态深历史
     */
    protected void recover() {
        //System.out.println("recover! in " + this.getClass().getName());
        if (history != null) {
            // System.out.println("recover to"+ history.getClass().getName());
            state = history;
            this.state.doWhileTrue();
            if (state instanceof Context) {
                //  System.out.println("recover recursive");
                ((Context) state).recover();
            }
        }
    }

    /**
     * 保存状态历史
     */
    protected void save() {
        history = state;
        if (state instanceof Context) {
            ((Context) state).save();
        }
    }

    /**
     * 终止状态转移
     */
    abstract protected void leave();
}
