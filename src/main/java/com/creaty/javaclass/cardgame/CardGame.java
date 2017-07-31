package com.creaty.javaclass.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hyx on 2015/12/6.
 */
public abstract class CardGame {
    ArrayList<Card> cardList;
    ArrayList<Player> playerList;


    public CardGame() {
        cardList = new ArrayList<>();
        playerList = new ArrayList<>();
    }

    public static void shuffle(List list) {
        Random random = new Random();
        int size = list.size();
        Object temp;
        for (int i = 0; i < size; i++) {
            int index = (int) (random.nextFloat() * size);
            temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }

    public static void main(String[] args) {
        CardGame cg = new Landlords();
        cg.printCarList();
        cg.shuffle();
        cg.printCarList();
    }

    protected void addOneDeckOfCard() {
        for (Card.CardSuit suit : Card.CardSuit.values()) {
            for (Card.CardPip pip : Card.CardPip.values()) {
                cardList.add(new Card(suit, pip));
            }
        }
        cardList.add(new Card(Card.CardJoker.joker1));
        cardList.add(new Card(Card.CardJoker.joker2));
    }

    protected void addPlayer(Player player) {
        if (player != null) {
            playerList.add(player);
        }
    }

    protected void shuffle() {
//        Random random = new Random();
//        int size = cardList.size();
//        Card temp;
//        for (int i = 0; i < size; i++) {
//            int index = (int) (random.nextFloat() * size);
//            temp = cardList.get(i);
//            cardList.set(i, cardList.get(index));
//            cardList.set(index, temp);
//        }
        shuffle(cardList);
    }

    abstract protected void begin();

    abstract protected void dealCard();

    public void printCarList() {
        System.out.println("list size:" + cardList.size());
        System.out.println(cardList);
    }

    public void printGame() {
        playerList.forEach(System.out::println);
    }
}
