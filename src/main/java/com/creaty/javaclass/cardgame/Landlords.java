package com.creaty.javaclass.cardgame;

import java.util.Random;

/**
 * Created by hyx on 2015/12/6.
 */
public class Landlords extends CardGame {

    Player landlord;

    @Override
    protected void begin() {
        addOneDeckOfCard();
        addPlayer(new Player("张三"));
        addPlayer(new Player("李四"));
        addPlayer(new Player("王五"));

        shuffle();
        dealCard();
        chooseLandlord();
        playerList.forEach(Player::sortCards);
    }

    @Override
    protected void dealCard() {
        int cardListSize = cardList.size();
        int playerListSize = playerList.size();
        int i = 0;
        for (Player p : playerList) {
            do {
                p.receiveCard(cardList.get(i++));
                //System.out.println(i);
            } while (i % 17 != 0);
        }
    }

    private void chooseLandlord() {
        landlord = playerList.get((int) (new Random().nextFloat() * 3));
        landlord.receiveCard(cardList.get(cardList.size() - 1));
        landlord.receiveCard(cardList.get(cardList.size() - 2));
        landlord.receiveCard(cardList.get(cardList.size() - 3));
    }


    public static void main(String[] args) {
        CardGame cg = new Landlords();
        cg.begin();
        cg.printGame();
    }
}
