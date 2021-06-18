package study.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @ author             : hyunjin
 * @ date               : 21. 6. 18.
 * @ name               : 74. Search a 2D Matrix
 * @ link               : https://leetcode.com/problems/search-a-2d-matrix/
 * @ time complexity    : O(n)
 * @ algorithm          : 그냥 품
 */
public class LeetCode74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int start_point = 0;

        for(int i=0; i<matrix.length; i++){

            int compare_number = matrix[i][matrix[i].length-1];

            if(target <= compare_number){
                start_point = i;
                break;
            }

        }

        for(int i=0; i<matrix[start_point].length; i++){

            if(matrix[start_point][i] == target) {
                return true;
            }

        }

        return false;


    }

    @Test
    void case_1() {

        // given
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;

        // when
        boolean result = searchMatrix(matrix, target);

        // expected
        boolean expectedResult = true;

        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    void case_2() {

        // given
        int[][] matrix = {{1}, {3}};
        int target = 3;

        // when
        boolean result = searchMatrix(matrix, target);

        // expected
        boolean expectedResult = true;

        assertThat(result).isEqualTo(expectedResult);

    }

}
