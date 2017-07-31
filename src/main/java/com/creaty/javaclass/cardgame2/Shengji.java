package com.creaty.javaclass.cardgame2;

import java.util.ArrayList;
import java.util.List;

/**
 * 升级规则：4个人每人12张牌，剩下6张底牌
 *
 * @author xinxing
 */
public class Shengji {

    public static List deak;
    static int numbersOfPlayers = 4;
    static int numbersOfHandCard = 12;
    String[] player = {"小王", "小张", "小赵", "小白"};
    String sentence = "的手牌是：";
    String[] huase = {"♥", "♣", "♦", "♠"};
    String[] paiValue = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String[] joker = {"redJ", "blackJ"};

    public Shengji() {
        deak = new ArrayList();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deak.add(huase[i] + paiValue[j]);
            }
        }
        deak.add(joker[0]);
        deak.add(joker[1]);
    }

    public static List getDeak() {
        return deak;
    }

    public static List dealHand(List ls) {
        int sizePai = ls.size();
        List handView = ls.subList(sizePai - numbersOfHandCard, sizePai);
        List hand = new ArrayList(handView);
        handView.clear();
        return hand;
    }

    public void printShengji(List Ls) {
        for (int i = 0; i < numbersOfPlayers; i++) {
            System.out.print(player[i] + sentence);
            System.out.println(dealHand(deak));
        }
        System.out.print("剩下的6张底牌是：");
        System.out.println(deak);
    }


}
