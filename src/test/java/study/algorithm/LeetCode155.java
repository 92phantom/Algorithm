package study.algorithm;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode155 {

    class MinStack {
        List<Integer> stack = new ArrayList<>();

        public MinStack() {

        }

        public void push(int val) {
            stack.add(val);
        }

        public void pop() {
            stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {

            int min = Integer.MAX_VALUE;

            for (int val : stack) {
                min = Math.min(min, val);
            }

            return min;
        }

    }

    @Test
    void test1() {

    }

}
