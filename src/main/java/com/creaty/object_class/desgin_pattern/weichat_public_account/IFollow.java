package com.creaty.object_class.desgin_pattern.weichat_public_account;

/**
 * Created by hyx on 2015/11/22.
 */
public interface IFollow {

    void follow(IPublisher publisher);

    void notFollow(IPublisher publisher);

    void listenMessage(Message message);
}
