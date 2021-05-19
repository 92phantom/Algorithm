package study.algorithm;

/**
 * @ author             : hyunjin
 * @ date               : 21. 5. 15.
 * @ name               : 111. Minimum Depth of Binary Tree
 * @ link               : https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @ time complexity    : O(n)
 * @ algorithm          : DFS
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode111 {

    /*
        root 노드에서 leaf 노드 까지 최소 노드 갯수 구하기
     */
    public int minDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }
        else {

            int left = minDepth(root.left);
            int right = minDepth(root.right);

            // Case 1. 둘다 자식이 없는 경우
            if(left == 0 && right == 0){
                return 1 + Math.max(left, right);
            }
            // Case 2. 둘중 하나만 자식을 가진 경우
            else if(left == 0 || right == 0) {
                return 1 + Math.max(left, right);
            }
            // Case 3. 둘다 자식을 가진 경우
            else {
                return 1 + Math.min(left, right);
            }

        }
    }

    @Test
    @DisplayName("테케 1")
    void test1 () {

        //given
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        //when
        int return_val = new LeetCode111().minDepth(root);

        //then
        assertThat(return_val).isEqualTo(2);

    }

    @Test
    @DisplayName("테케 2")
    void test2 () {

        //given
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);

        //when
        int return_val = new LeetCode111().minDepth(root);

        //then
        assertThat(return_val).isEqualTo(5);

    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
