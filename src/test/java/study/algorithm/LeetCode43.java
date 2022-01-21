package study.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LeetCode43 {


    public String multiply(String num1, String num2) {

        int num1_len = num1.length();
        int num2_len = num2.length();
        int res_len = num1_len + num2_len;
        int[] res = new int[res_len];

        StringBuilder result = new StringBuilder();

        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }


        for (int i = num1_len - 1; i >= 0; i--) {
            for (int j = num2_len - 1; j >= 0; j--) {

                int num1_int = num1.charAt(i) - '0';
                int num2_int = num2.charAt(j) - '0';

                res[i + j] += num1_int * num2_int;

                if (res[i + j] >= 10 && i + j != 0) {
                    res[i + j - 1] += res[i + j] / 10;
                    res[i + j] = res[i + j] % 10;
                }
            }
        }

        for (int i = 0; i < res_len - 1; i++) {
            result.append(res[i]);
        }

        return result.toString();

    }

    @Test
    void test_1() {

        //given
        String num1 = "6913259244";
        String num2 = "71103343";
        String expectedData = "491555843274052692";

        // when
        String resultData = multiply(num1, num2);

        // then
        assertThat(resultData).isEqualTo(expectedData);

    }

}
