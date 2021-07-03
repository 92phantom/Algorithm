package study.algorithm;

import java.util.ArrayList;

/**
 * @ author             : hyunjin
 * @ date               : 21. 7. 3.
 * @ name               : 838. Push Dominoes
 * @ link               : https://leetcode.com/problems/push-dominoes/
 * @ time complexity    : O(n)
 * @ algorithm          :
 */
public class LeetCode838 {


    public String pushDominoes(String dominoes) {


        int time = 0;
        int[] arr = new int[dominoes.length()];

        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R')
                time = 1;
            else if (dominoes.charAt(i) == '.' && time > 0)
                arr[i] = time++;
            else
                time = 0;
        }

        time = 0;
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'R')
                time = 0;
            else if (dominoes.charAt(i) == 'L')
                time = 1;
            else if (time > 0) {
                if (arr[i] == 0) arr[i] = -time;
                else if (arr[i] > time) {
                    arr[i] = -time;
                    time++;
                } else if (arr[i] == time)
                    arr[i] = 0;
            }
        }

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < dominoes.length(); i++) {
            if (arr[i] == 0)
                str.append(dominoes.charAt(i));
            else if (arr[i] < 0)
                str.append('L');
            else
                str.append('R');
        }

        return str.toString();


    }


}
