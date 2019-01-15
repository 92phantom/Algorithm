package BFS_DFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;


public class DFSandBFS {

	

	static int N;

	static int M;

	static int V;

	static int[][]G;

	static boolean[]visit;

	

	

	

	public static void dfs(int n){

		visit[n]=true;

		System.out.print(n+" ");

		

		for(int i=1; i<=N;i++){

			if(G[n][i]==1 && visit[i]==false){

				dfs(i);

			}

		}

	}

	public static void bfs(int n){

		Queue<Integer> q = new LinkedList<Integer> ();

		

		q.offer(n);

		visit[n]=true;

		int temp;

		while(!q.isEmpty()){

			temp = q.poll();

			System.out.print(temp+" ");

			for(int i=0;i<=N;i++){

				if(G[temp][i]==1 && visit[i]==false){

					q.offer(i);

					visit[i]=true;

					

				}

			}

			

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
	
			M = Integer.parseInt(br.readLine());
	
			V = Integer.parseInt(br.readLine());

		G = new int[1001][1001];

		visit = new boolean[10001];

		int t1,t2;

		for(int i=0;i<M;i++){

			t1 = Integer.parseInt(br.readLine());

			t2 = Integer.parseInt(br.readLine());

			G[t1][t2] = G[t2][t1] =1;

		}

		

		dfs(V);

		for(int i=1;i<=N;i++)

			visit[i]=false;

		System.out.println("");

		bfs(V);

		

	}

}

