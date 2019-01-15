package BFS_DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class boj_7576 {
 
    private static int max = Integer.MIN_VALUE;
    private static int n, m;
    private static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        
        map = new int[n][m];
        
        for(int i =0; i<n; i++) {
            input = br.readLine().trim().split(" ");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1) {
                    bfs(i,j);
                }
            }    
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
                if(max < map[i][j]) {
                    max = map[i][j];
                }
            }    
        }
        
        System.out.print(max-1);
    }
    
    static void bfs(int a, int b) {
        Queue<Node> q = new <Node>LinkedList();
        q.offer(new Node(a, b));
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            int x, y, ax, ay;
            
            x= node.getX();
            y = node.getY();
            
            int[] dx = {1,-1, 0, 0};
            int[] dy = {0, 0, 1,-1};
            
            for(int i=0; i<4; i++) {
                ax = x + dx[i];
                ay = y + dy[i];
                if(ax >= 0 && ax < n && ay >=0 && ay <m) {
                    if((map[ax][ay] == 0 || map[ax][ay] > map[x][y]+1)) {
                        map[ax][ay] = map[x][y]+1;
                        q.offer(new Node(ax, ay));
                    }
                }
            }
        }
        
    }
    
    static class Node {
        private int x;
        private int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
    }
}

