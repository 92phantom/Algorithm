package study.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @ author             : hyunjin
 * @ date               : 21. 7. 10.
 * @ name               : 700. Search in a Binary Search Tree
 * @ link               : https://leetcode.com/problems/search-in-a-binary-search-tree/
 * @ time complexity    : O(n)
 * @ algorithm          : DFS
 */
public class LeetCode700 {


    public TreeNode searchBST(TreeNode root, int val) {

        if(root == null) return null;

        if(root.val < val) return searchBST(root.right, val);
        if(root.val > val) return searchBST(root.left, val);

        return root;
    }

    @Test
    void test_1() {

        // given
        TreeNode root = new TreeNode();
        root.val = 4;
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 2;

        TreeNode expected = new TreeNode(2);
        expected.left = new TreeNode(1);
        expected.right = new TreeNode(3);

        // when
        TreeNode output = searchBST(root, val);

        // then
        assertThat(output.toString()).isEqualTo(expected.toString());
    }

    public class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


}
