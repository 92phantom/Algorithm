package study.algorithm;

/**
 * @ author             : hyunjin
 * @ date               : 21. 7. 2.
 * @ name               : 693. Binary Number with Alternating Bits
 * @ link               : https://leetcode.com/problems/binary-number-with-alternating-bits/
 * @ time complexity    : O(n)
 * @ algorithm          :
 */
public class LeetCode693 {

    public boolean hasAlternatingBits(int n) {

        String toBinary = Integer.toBinaryString(n);

        char cmp_char = toBinary.charAt(0);

        for(int i=1; i<toBinary.length(); i++){

            if(cmp_char == toBinary.charAt(i)){
                return false;
            }

            cmp_char = toBinary.charAt(i);
        }

        return true;
    }


}
