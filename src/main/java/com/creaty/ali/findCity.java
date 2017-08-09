package com.creaty.ali;

/**
 * Created by hzhuangyixuan on 2017/8/2.
 */
public class findCity {
    static class TrieNode{
        //boolean hasCity;
        TrieNode[] children;
        String city;

    }
    private static int getNumber(String str)
    {
        int d = -1;
        try
        {
            d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {}
        return d;
    }

    /**
     * @param ip should be valid ip like 1.1.1.1, 1.1.*, 1.*,
     * */
    public static String findCity(TrieNode root, String ip){
        if(root == null || ip == null) return null;
        else if( ip.isEmpty() || "*".equals(ip) ) return root.city;

        int dotIndex = ip.indexOf('.');
        String subip;
        int n = -1;
        String city = null;
        if(dotIndex!=-1) {
            subip = ip.substring(0, dotIndex);
            n = getNumber(subip);
            if(n != -1 && root.children != null)
                city =  findCity(root.children[n], ip.substring(dotIndex + 1));
        }else{
            subip = ip;
            n = getNumber(subip);
            if(n != -1 && root.children != null)
                city =  findCity(root.children[n], "");
        }
        return city == null ? root.city : city;
    }


    public static void main(String[] args){
        String ip1 = "1.1.1.1";
        String ip2 = "1.2.2.1";
        String ip3 = "1.2.1.1";
        TrieNode root = new TrieNode();
        root.children = new TrieNode[256];
        TrieNode n1 = new TrieNode();
        n1.children = new TrieNode[256];
        TrieNode n2 = new TrieNode();
        n2.children = new TrieNode[256];
        TrieNode n3 = new TrieNode();
        n3.children = new TrieNode[256];
        TrieNode n4 = new TrieNode();
        n4.city = "4";

        root.children[1] = n1;
        root.city = "all";
        n1.children[1] = n2;
        n1.children[2] = new TrieNode();
        n1.children[2].city = "other";
        n1.children[2].children = new TrieNode[256];
        n1.children[2].children[2] =new TrieNode();
        n1.children[2].children[2].city = "other2";
        n2.children[1] = n3;
        n3.children[1] = n4;

        System.out.println(findCity(root, ip1));
        System.out.println(findCity(root, ip2));
        System.out.println(findCity(root, ip3));
    }
}
