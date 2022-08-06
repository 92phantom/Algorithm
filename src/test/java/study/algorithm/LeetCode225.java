package study.algorithm;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class LeetCode225 {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public LeetCode225() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {

        if(q1.isEmpty()) {
            q1.add(x);
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }
        else {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }
        }

    }

    public int pop() {
        if (q1.isEmpty()) return q2.poll();

        return q1.poll();
    }

    public int top() {
        if (q1.isEmpty()) return q2.peek();

        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    @Test
    void test_1() {
        push(1);
        push(2);

        // given
        int expectedResult = 2;

        // when
        int result= top();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}
