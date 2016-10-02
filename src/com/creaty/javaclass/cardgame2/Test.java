package com.creaty.javaclass.cardgame2;

public class Test {

    public static void main(String[] args) {
        // TODO code application logic here
//		Majiang S = new Majiang();
//		Cards<Majiang> SCards = new Cards();
//		SCards.shuffle(S.getDeak());
//	    //洗牌
//	    //Collections.shuffle(deak);
//	    S.printShengji(S.getDeak());

        System.out.println("*********升级发牌*******");
        Shengji S = new Shengji();
        Cards<Shengji> SCards = new Cards<Shengji>();
        SCards.shuffle(S.getDeak());//洗牌
        S.printShengji(S.getDeak());

        System.out.println("*******斗地主发牌*******");
        DouDizhu D = new DouDizhu();
        Cards<DouDizhu> DCards = new Cards<DouDizhu>();
        DCards.shuffle(D.getDeak());
        D.printDouDizhu(D.getDeak());

        System.out.println("*******麻将发牌*********");
        Majiang M = new Majiang();
        Cards<Majiang> MCards = new Cards<Majiang>();
        MCards.shuffle(M.getDeak());
        M.printMajiang(M.getDeak());

    }
}
