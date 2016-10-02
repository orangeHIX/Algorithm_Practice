package com.creaty.object_class.desgin_pattern.weichat_public_account;

/**
 * Created by hyx on 2015/11/22.
 */
public class NormalUser extends User implements IFollow {

    public NormalUser(String name) {
        super(name);
    }

    @Override
    public void follow(IPublisher publisher) {
        publisher.registerFollower(this);
    }

    @Override
    public void notFollow(IPublisher publisher) {
        publisher.unregisterFollower(this);
    }

    @Override
    public void listenMessage(Message message) {
        System.out.println("NormalUser " + name + " receive message: " + message);
    }
}
