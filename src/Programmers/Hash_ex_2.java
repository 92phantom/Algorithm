package Programmers;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Hash_ex_2 {

    static Set<String> map = ConcurrentHashMap.newKeySet();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] phone_book = { "119", "97674223", "1195524421" };
//		String[] phone_book = { "123", "456", "789" };
//		String[] phone_book = { "123", "12", "1235", "567", "88" };
//		String[] phone_book = { "113", "12340", "123440", "12345", "9" };

		System.out.println(solution(phone_book));

	}

	static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i=0; i<phone_book.length; i++){
            
            int size = phone_book[i].length();
            String input = phone_book[i];       
            if(!map.contains(input)){
                for(String s : map){
                    if(s.length() > size){
                        String temp = s.substring(0, size);
                        if(temp.equals(input)){
                            return false;
                        }
                    }else{
                        String temp = input.substring(0,s.length());
                        if(temp.equals(s)){
                            return false;
                        }
                    }
                }
                map.add(input);
            }
            
        }
        
        return answer;
	}

}
