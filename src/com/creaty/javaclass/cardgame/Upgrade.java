package com.creaty.javaclass.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hyx on 2015/12/6.
 */
public class Upgrade extends CardGame {

    Player Republicans;
    List<Card> tableCards;

    public Upgrade(){
        tableCards = new ArrayList<>();
    }

    @Override
    protected void begin() {
        addOneDeckOfCard();
        addPlayer(new Player("张三"));
        addPlayer(new Player("李四"));
        addPlayer(new Player("王五"));
        addPlayer(new Player("赵六"));
        shuffle();
        dealCard();
        chooseCardDealer();

        playerList.forEach(Player::sortCards);
    }

    private void chooseCardDealer() {
        Republicans =  playerList.get((int)(new Random().nextFloat()*4));
        for(int i = 0; i < 6; i++) {
            //换牌
            int index = (int)(new Random().nextFloat()*Republicans.getCardNum());
            Republicans.swapCard(index, cardList.get(cardList.size() - i - 1));
        }
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
            } while (i % 12 != 0);
        }
        tableCards.add(cardList.get(i++));
        tableCards.add(cardList.get(i++));
        tableCards.add(cardList.get(i++));
        tableCards.add(cardList.get(i++));
        tableCards.add(cardList.get(i++));
        tableCards.add(cardList.get(i++));
    }

    public void printGame() {
        super.printGame();
        System.out.println("底牌：" + tableCards);
    }
    public static void main(String[] args) {
        CardGame cg = new Upgrade();
        cg.begin();
        cg.printGame();
    }
}
