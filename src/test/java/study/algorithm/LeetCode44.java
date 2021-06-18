package study.algorithm;

/**
 * @ author             : hyunjin
 * @ date               : 21. 5. 28.
 * @ name               : 44. Wildcard Matching
 * @ link               : https://leetcode.com/problems/wildcard-matching/
 * @ time complexity    : O(n^2)
 *      n = s, p (s & p <= 2000)
 * @ algorithm          : Backtracking
 */
public class LeetCode44 {

    public boolean isMatch(String s, String p) {

        if (p.length() == 0) {
            return s.length() == 0 ? true : false;
        }
        if (p.length() == 1) {
            if (p.equals("*")) {
                return true;
            }
            if(s.length() == 1){
                if(p.equals(s) || p.equals("?")){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        if (p.charAt(0) == '*') {
            // * 공백 처리하는 경우
            if (isMatch(s, p.substring(1))) {
                return true;
            }
            else {
                if(s.length() > 0) {
                    // * 를 공백이 아닌 s의 첫~n글자로 대치할 것 인가
                    return isMatch(s.substring(1), p);
                }
            }
        }

        // s, p의 첫글자가 서로 맞는지 재귀 돌면서 체크
        // 중간에 * 이 기어있다면 위 * 처리 되는 케이스로 처리됨
        return s.length() > 0 &&
                (p.charAt(0) == '?' || s.charAt(0) == p.charAt(0)) &&
                isMatch(s.substring(1), p.substring(1));
    }
}
