package com.creaty.javaclass.cardgame;

/**
 * Created by hyx on 2015/12/6.
 */
public class Card {

    CardSuit suit;
    CardPip pip;
    CardJoker joker;

    public Card(CardSuit suit, CardPip pip) {
        this.suit = suit;
        this.pip = pip;
    }

    public Card(CardJoker joker) {
        this.joker = joker;
    }

    public int getValue() {
        if (joker == null) {
            return pip.ordinal() * 4 + suit.ordinal();
        } else {
            return -1 - joker.ordinal();
        }
    }

    @Override
    public String toString() {
        if (joker == null) {
            return "(" + suit +
                    ", " + pip +
                    ')';
        } else {
            return "(" + joker + ")";
        }
    }

    //黑桃、方块、梅花和红桃。
    public enum CardSuit {

        spades("♠"), diamonds("♦"), clubs("♣"), hearts("♥");

        String name;

        CardSuit(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum CardPip {
        _A("A"), _2("2"), _3("3"), _4("4"), _5("5"), _6("6"), _7("7"),
        _8("8"), _9("9"), _10("10"), _J("J"), _Q("Q"), _K("K");

        String name;

        CardPip(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum CardJoker {
        joker1("joker1"), joker2("joker2");

        String name;

        CardJoker(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
