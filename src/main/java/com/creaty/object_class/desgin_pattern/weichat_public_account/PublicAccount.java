package com.creaty.object_class.desgin_pattern.weichat_public_account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyx on 2015/11/22.
 */
public class PublicAccount extends User implements IPublisher {


    List<IFollow> followList;

    public PublicAccount(String name) {
        super(name);
        this.followList = new ArrayList<>();
    }

    @Override
    public boolean registerFollower(IFollow follower) {
        return followList.add(follower);
    }

    @Override
    public boolean unregisterFollower(IFollow follower) {
        return followList.remove(follower);
    }

    @Override
    public void sendMessageToFollowers(Message message) {
        for (IFollow follow : followList) {
            follow.listenMessage(message);
        }
    }
}
