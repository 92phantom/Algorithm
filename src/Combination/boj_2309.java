package Combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
/*
 * 
 * @result 11444KB, 112ms
 * 
 */

public class boj_2309 {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
         
        ArrayList<Integer> input = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++)   {
            input.add(sc.nextInt());
        }
         
        // 난쟁이들을 키순서대로 정렬한다.
        Collections.sort(input);
         
        int rslti = -1;
        int rsltj = -1;
         
        int sum = 0;
 
        // 제외할 첫번째 난쟁이 선택
        for(int i = 0; i < 9; i++)   {
            // 제외할 두번째 난쟁이 선택
            for(int j = 0; j < 9; j++)   {
                if(i==j)    {
                    continue;
                }
                 
                // 선택된 두명의 난쟁이를 제외하고 나머지 난쟁이들의 키를 모두 더한다.
                for(int k = 0; k < 9; k++)   {
                    if(k == i || k == j)    {
                        continue;
                    }else   {
                        sum = sum + input.get(k);
                    }
                }
                 
                // 난쟁이들의 키의 합이 100이면 정답
                if(sum == 100)  {
                    rslti = i;
                    rsltj = j;
                    break;
                }else   {
                    sum = 0;
                }
            }
             
            if(rslti >= 0)   {
                break;
            }
        }
 
        // 선택된 난쟁이들을 출력한다.
        for(int i = 0; i < 9; i++)   {
            if(i != rslti && i != rsltj)    {
                System.out.println(input.get(i));
            }
        }
        
        sc.close();
    }
 
}
