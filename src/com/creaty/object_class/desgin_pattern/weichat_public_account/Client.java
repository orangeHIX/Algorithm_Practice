package com.creaty.object_class.desgin_pattern.weichat_public_account;

/**
 * Created by hyx on 2015/11/22.
 */
public class Client {
    public static void main(String[] args) {
        NormalUser zhang = new NormalUser("zhang");
        NormalUser li = new NormalUser("li");
        NormalUser zhao = new NormalUser("zhao");

        PublicAccount Peking = new PublicAccount("Peking");
        PublicAccount PekingWuxi = new PublicAccount("PekingWuxi");

        zhang.follow(Peking);
        li.follow(Peking);
        zhao.follow(Peking);
        zhao.follow(PekingWuxi);

        Peking.sendMessageToFollowers(new PushMessage(Peking, "欢迎"));

        li.notFollow(Peking);

        Peking.sendMessageToFollowers(new PushMessage(Peking, "欢迎2"));

        PekingWuxi.sendMessageToFollowers(new PushMessage(PekingWuxi, "hello"));
    }
}
