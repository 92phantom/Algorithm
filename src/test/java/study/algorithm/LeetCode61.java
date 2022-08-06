package study.algorithm;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode61 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (k==0 || head == null) return head;

        ArrayList<ListNode> nodeList = new ArrayList<>();

        while(head != null) {
            nodeList.add(head);
            head = head.next;
        }

        int len = nodeList.size();
        k = k % len; // 루틴 돌린 뒷 Node

        if (len==1 || k==0) return nodeList.get(0);

        ListNode returnHead = nodeList.get(len-k);
        nodeList.get(len-1).next = nodeList.get(0);
        // 맨뒤에 올 노드는 연결고리 끊음
        nodeList.get(len-k-1).next = null;

        return returnHead;
    }

    @Test
    void test() {

        // when
        ListNode end = new ListNode();
        end.val = 5;
        end.next = null;

        ListNode fourth = new ListNode();
        fourth.val = 4;
        fourth.next = end;

        ListNode third = new ListNode();
        third.val = 3;
        third.next = fourth;

        ListNode second = new ListNode();
        second.val = 2;
        second.next = third;

        ListNode head = new ListNode();
        head.val = 1;
        head.next = second;

        // given
        ListNode result = rotateRight(head, 2);
        int result_head = result.val;
        int result_head_next = result.next.val;

        int expectedResult = 4;
        int expectedResult_2 = 5;

        // then
        assertThat(result_head).isEqualTo(expectedResult);
        assertThat(result_head_next).isEqualTo(expectedResult_2);

    }

}
