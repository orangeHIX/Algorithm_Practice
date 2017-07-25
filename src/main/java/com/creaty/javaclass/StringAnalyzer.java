package com.creaty.javaclass;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * �ӱ�׼�������һ���ַ����ֱ�ͳ�Ƹ����ַ���Ӣ����ĸ�������ַ��ĸ��������ֱ������Щ�ַ�
 * Created by hyx on 2015/11/8.
 */
public class StringAnalyzer {

    public static void analyze() {
        String s = null;
        try (Scanner sc = new Scanner(System.in)) {
            s = sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (s != null) {
            char[] charArray = s.toCharArray();
            ArrayList<Character> letters = new ArrayList<>();
            ArrayList<Character> numbers = new ArrayList<>();
            ArrayList<Character> others = new ArrayList<>();
            for (char c : charArray) {
                if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                    letters.add(c);
                } else if ('0' <= c && c <= '9') {
                    numbers.add(c);
                } else {
                    others.add(c);
                }
            }
            System.out.println("There are " + letters.size() + " letters: " + letters);
            System.out.println("There are " + numbers.size() + " numbers: " + numbers);
            System.out.println("There are " + others.size() + " other characters: " + others);
        }
    }

    public static void main(String[] args) {
        StringAnalyzer.analyze();
    }
}
