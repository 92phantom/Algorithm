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
         
        // �����̵��� Ű������� �����Ѵ�.
        Collections.sort(input);
         
        int rslti = -1;
        int rsltj = -1;
         
        int sum = 0;
 
        // ������ ù��° ������ ����
        for(int i = 0; i < 9; i++)   {
            // ������ �ι�° ������ ����
            for(int j = 0; j < 9; j++)   {
                if(i==j)    {
                    continue;
                }
                 
                // ���õ� �θ��� �����̸� �����ϰ� ������ �����̵��� Ű�� ��� ���Ѵ�.
                for(int k = 0; k < 9; k++)   {
                    if(k == i || k == j)    {
                        continue;
                    }else   {
                        sum = sum + input.get(k);
                    }
                }
                 
                // �����̵��� Ű�� ���� 100�̸� ����
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
 
        // ���õ� �����̵��� ����Ѵ�.
        for(int i = 0; i < 9; i++)   {
            if(i != rslti && i != rsltj)    {
                System.out.println(input.get(i));
            }
        }
        
        sc.close();
    }
 
}
