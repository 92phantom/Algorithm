package Buzzvil;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class test2 {

	static boolean flag = true;

	private static class Node {
		Node left, right;
		int data;

		Node(int newData) {
			left = right = null;
			data = newData;
		}
	}

	private static Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return (node);
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		Node _root;
		int root_i = 0, root_cnt = 0, root_num = 0;
		root_cnt = in.nextInt();
		_root = null;
		for (root_i = 0; root_i < root_cnt; root_i++) {
			root_num = in.nextInt();
			if (root_i == 0)
				_root = new Node(root_num);
			else
				insert(_root, root_num);
		}

		int q = in.nextInt();

		for (int i = 0; i < q; i++) {
			int _x = in.nextInt();
			System.out.println(isPresent(_root, _x));
		}

		return;
	}

	private static int isPresent(Node root, int val) {
		/*
		 * For your reference class Node { Node left, right; int data; Node(int newData)
		 * { left = right = null; data = newData; } }
		 */

		flag = true;

		check(root, val);

		if (flag) {
			return 1;
		} else {
			return 0;
		}
//		if (root == null) {
//
//			return 0;
//		}
//
//		else {
//
//			if (val == root.data) {
//				System.out.println("여기는");
//				return 1;
//			}
//
//			// 클 경우
//			else if (val > root.data) {
//				isPresent(root.right, val);
//			}
//			// 작을 경우
//			else if (val < root.data) {
//				isPresent(root.left, val);
//			}
//
//			return 1;
//		}

//		return 1;

	}

	static void check(Node root, int val) {

		if (root == null) {

			flag = false;
			return;
		}

		else {

			if (val == root.data) {
				flag = true;
				return;
//				return true;
			}

			// 클 경우
			else if (val > root.data) {
				isPresent(root.right, val);
			}
			// 작을 경우
			else if (val < root.data) {
				isPresent(root.left, val);
			}

		}

	}

}
