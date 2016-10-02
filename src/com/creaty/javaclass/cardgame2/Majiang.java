package com.creaty.javaclass.cardgame2;

import java.util.ArrayList;
import java.util.List;
/**
 * 麻将规则：共108张，每种花色4份
 * @author xinxing
 */

public class Majiang {

	static int numbersOfPlayers = 4;
	static int numbersOfHandCard = 27;
	String[] player = {"小王","小张","小赵","小白"};
    String sentence = "的手牌是：";
    String[] huase = {"万","筒","条"};
    String[] paiValue ={"一","二","三","四","五","六","七","八","九"};
    
    public static List deak;
    
    public Majiang(){
    	deak= new ArrayList();
    	for(int k=0;k<4;k++){
        for(int i = 0;i < 3;i++){
    	      for(int j = 0; j < 9;j++)
    	      {
    	        deak.add(huase[i]+paiValue[j]);
    	      }
    	    }
        }
    }
	public static List getDeak() {
		return deak;
	}
	public void printMajiang(List Ls){
		for(int i = 0;i < numbersOfPlayers;i++){
		      System.out.print(player[i]+sentence);
		      System.out.println(dealHand(deak));
		}
		
	}
	public static List dealHand(List ls){
		int sizePai = ls.size(); 
	    List handView = ls.subList(sizePai - numbersOfHandCard, sizePai);
	    List hand = new ArrayList(handView);
	    handView.clear();
		return hand;
	}
	
    
}
