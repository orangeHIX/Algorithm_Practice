package com.creaty.object_class.desgin_pattern.weichat_public_account;

/**
 * Created by hyx on 2015/11/22.
 */
public abstract class Message {
    User sender;

    public Message(User sender) {
        this.sender = sender;
    }
}
