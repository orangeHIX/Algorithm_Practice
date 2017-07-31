package com.creaty.javaclass.cardgame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hyx on 2015/12/6.
 */
public class Player {

    public String name;
    private List<Card> cardlist;

    public Player(String name) {
        cardlist = new ArrayList<>();
        this.name = name;
    }

    public void receiveCard(Card card) {
        if (card != null) {
            cardlist.add(card);
        }
    }

    public Card swapCard(int index, Card newCard) {
        if (newCard != null && index > 0 && index < cardlist.size()) {
            Card c = cardlist.get(index);
            cardlist.set(index, newCard);
            return c;
        }
        return null;
    }

    public void sortCards() {
        cardlist.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getValue() - o2.getValue();
            }
        });
    }

    public int getCardNum() {
        return cardlist.size();
    }

    @Override
    public String toString() {
        return "Player " + name + " {" + cardlist +
                '}';
    }
}
