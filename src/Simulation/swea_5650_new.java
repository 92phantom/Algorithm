package Simulation;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class swea_5650_new {
 
    static int T,N;
    static int[][] map;
    static int []dx = {0,0,1,-1};
    static int []dy = {1,-1,0,0};
    static int max;
    static Point[][] warm;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        int t = 1;
        
        while(T-- >0) {
            
            N = Integer.parseInt(br.readLine());
            
            map = new int[N+2][N+2];
            max = Integer.MIN_VALUE;
            warm = new Point[2][5];
            
            for (int i = 0; i < N+2; i++) {
                map[0][i] = map[N+1][i] = map[i][0] = map[i][N+1] = 5;
            }
            
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    
                    if(map[i][j] >= 6) {
                        if(warm[0][map[i][j]-6] != null) {
                            warm[1][map[i][j]-6] = new Point(i, j);
                        }
                        else {
                            warm[0][map[i][j]-6] = new Point(i, j);
                        }
                    }
                }
            }
            
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(map[i][j] != 0) continue;
                    for (int k = 0; k < 4; k++) {
                        solve(i,j,k);
                    }
                }
            }
            System.out.printf("#%d %d%n",t++,max);
        }
    }
    
    static void solve(int sx, int sy, int dir) {
        
        int tx = sx;
        int ty = sy;
        int cnt = 0;
        
        while(true) {
            int nx = tx + dx[dir];
            int ny = ty + dy[dir];
            
            if(map[nx][ny] == -1 || (nx == sx && ny == sy))
                break;
            
            if( map[nx][ny]>= 6 ) {    // warmhole
                Point p = move(map[nx][ny],nx,ny);
                tx = p.x;
                ty = p.y;
                continue; 
            }
            else if( map[nx][ny] >= 1 ) { // block 
                dir = change(map[nx][ny],dir);
                cnt++;
            }
            
            tx = nx;
            ty = ny;
        }
        max = Math.max(max, cnt);
    }
    
    static Point move(int warmhole, int x, int y) {
        Point f = warm[0][warmhole-6];
        Point s = warm[1][warmhole-6];
        
        if(f.x == x && f.y == y) {
            return s;
        }
        return f;
    }
    
    static int change(int block, int d) {
        switch(block) {
        case 1:
            switch(d) {
            case 0: d = 1; break;
            case 1: d = 3; break;
            case 2: d = 0; break;
            case 3: d = 2; break;
            }
            break;
        case 2:
            switch(d) {
            case 0: d = 1; break;
            case 1: d = 2; break;
            case 2: d = 3; break;
            case 3: d = 0; break;
            }
            break;
        case 3:
            switch(d) {
            case 0: d = 2; break;
            case 1: d = 0; break;
            case 2: d = 3; break;
            case 3: d = 1; break;
            }
            break;
        case 4:
            switch(d) {
            case 0: d = 3; break;
            case 1: d = 0; break;
            case 2: d = 1; break;
            case 3: d = 2; break;
            }
            break;
        case 5:
            switch(d) {
            case 0: d = 1; break;
            case 1: d = 0; break;
            case 2: d = 3; break;
            case 3: d = 2; break;
            }
            break;
        }
        return d;
    }
    
}