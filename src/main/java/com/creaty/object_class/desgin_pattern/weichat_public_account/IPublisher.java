package com.creaty.object_class.desgin_pattern.weichat_public_account;

/**
 * Created by hyx on 2015/11/22.
 */
public interface IPublisher {
    public boolean registerFollower(IFollow follower);

    public boolean unregisterFollower(IFollow follower);

    public void sendMessageToFollowers(Message message);
}
