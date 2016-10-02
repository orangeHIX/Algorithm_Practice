package com.creaty.javaclass;

import java.util.Arrays;
import java.util.List;

/**
 * （1）编写一个程序，根据学生的语文、数学、英语成绩。计算平均成绩，并根据平均成绩对学生进行分类。<>br</>
 * 平均学习成绩大于等于90分的用A表示，75-89分之间的用B表示，60-74分之间的用C表示，60分以下的用D表示。（基础题）
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
