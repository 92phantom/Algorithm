package Buzzvil;

import java.util.ArrayList;
import java.util.List;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
//		
//		for(int i=1; i<=5; i++) {
//			list.add(i);
//		}
//		
		list.add(331);

		System.out.println(romanizer(list));
	}

	static List<String> romanizer(List<Integer> numbers) {

		List<String> l = new ArrayList<>();

		for (int i = 0; i < numbers.size(); i++) {

			int num = numbers.get(i);
			String temp = "";
			while (num != 0) {
				if ((num / 1000) >= 1) {
					int t = num / 1000;
					for (int j = 0; j < t; j++) {
						temp += "M";
					}
					num %= 1000;
				}
				if ((num / 900) >= 1) {
					int t = num / 900;
					for (int j = 0; j < t; j++) {
						temp += "CM";
					}
					num %= 900;
				}
				if ((num / 500) >= 1) {
//					temp += "D";
					int t = num / 500;
					for (int j = 0; j < t; j++) {
						temp += "D";
					}
					num %= 500;
				}
				if ((num / 400) >= 1) {
//					temp += "CD";
					int t = num / 400;
					for (int j = 0; j < t; j++) {
						temp += "CD";
					}
					num %= 400;
				}
				if ((num / 100) >= 1) {
//					temp += "C";
					int t = num / 100;
					for (int j = 0; j < t; j++) {
						temp += "C";
					}
					num %= 100;
				}
				if ((num / 90) >= 1) {
//					temp += "XC";
					int t = num / 90;
					for (int j = 0; j < t; j++) {
						temp += "XC";
					}
					num %= 90;
				}
				if ((num / 50) >= 1) {
//					temp += "L";
					int t = num / 50;
					for (int j = 0; j < t; j++) {
						temp += "L";
					}

					num %= 50;
				}
				if ((num / 40) >= 1) {
//					temp += "XL";
					int t = num/40;
					for(int j=0; j<t; j++) {
						temp += "XL";
					}
					num %= 40;
				}
				if ((num / 10) >= 1) {
//					temp += "X";
					int t = num/10;
					for(int j=0; j<t; j++) {
						temp += "X";
					}
					num %= 10;
				}

				if ((num / 9) >= 1) {
//					temp += "IX";
					int t = num/9;
					for(int j=0; j<t; j++) {
						temp += "IX";
					}
					num %= 9;
				}
				if ((num / 8) >= 1) {
//					temp += "VIII";
					int t = num/8;
					for(int j=0; j<t; j++) {
						temp += "VIII";
					}
					num %= 8;
				}
				if ((num / 7) >= 1) {
//					temp += "VII";
					int t = num/7;
					for(int j=0; j<t; j++) {
						temp += "VII";
					}
					num %= 7;
				}
				if ((num / 6) >= 1) {
//					temp += "VI";
					int t = num/6;
					for(int j=0; j<t; j++) {
						temp += "VI";
					}
					num %= 6;
				}
				if ((num / 5) >= 1) {
//					temp += "V";
					int t = num/5;
					for(int j=0; j<t; j++) {
						temp += "V";
					}
					num %= 5;
				}
				if ((num / 4) >= 1) {
//					temp += "IV";
					int t = num/4;
					for(int j=0; j<t; j++) {
						temp += "IV";
					}
					num %= 4;
					
				}
				if ((num / 3) >= 1) {
//					temp += "III";
					int t = num/3;
					for(int j=0; j<t; j++) {
						temp += "III";
					}
					num %= 3;
				}
				if ((num / 2) >= 1) {
//					temp += "II";
					int t = num/2;
					for(int j=0; j<t; j++) {
						temp += "II";
					}
					num %= 2;
				}
				if ((num / 1) >= 1) {
//					temp += "I";
					int t = num/1;
					for(int j=0; j<t; j++) {
						temp += "I";
					}
					num %= 1;
				}
			}
			l.add(temp);
		}

		return l;

	}

}
