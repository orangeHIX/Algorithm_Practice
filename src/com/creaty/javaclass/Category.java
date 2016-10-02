package com.creaty.javaclass;

import java.util.Arrays;
import java.util.List;

/**
 * ��1����дһ�����򣬸���ѧ�������ġ���ѧ��Ӣ��ɼ�������ƽ���ɼ���������ƽ���ɼ���ѧ�����з��ࡣ<>br</>
 * ƽ��ѧϰ�ɼ����ڵ���90�ֵ���A��ʾ��75-89��֮�����B��ʾ��60-74��֮�����C��ʾ��60�����µ���D��ʾ���������⣩
 * Created by hyx on 2015/11/8.
 */
public class Category {

    public static String category(List<Integer> scores) {
        if (scores.stream().allMatch(score -> score >= 0 && score <= 100)) {
            float avg = scores.stream().reduce(0, Integer::sum).floatValue() / scores.size();
            if (avg >= 90) {
                return "A";
            } else if (avg >= 75) {
                return "B";
            } else if (avg >= 60) {
                return "C";
            } else {
                return "D";
            }
        } else {
            return "invalid score";
        }
    }

    public static void main() {
        Category.category(Arrays.asList(90, 98, 78));
    }
}
