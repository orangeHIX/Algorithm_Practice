package com.creaty.object_class.desgin_pattern.weichat_public_account;

/**
 * Created by hyx on 2015/11/22.
 */
public class PushMessage extends Message {

    String title;
    //文字
    //图片
    //链接

    public PushMessage(User sender, String title) {
        super(sender);
        this.title = title;
    }

    @Override
    public String toString() {
        return "PushMessage from " + sender.name + " {" +
                "title='" + title + '\'' +
                '}';
    }
}
