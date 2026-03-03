import java.io.*;
import java.util.*;

public class Main {
    
    static int cntR;
    static int cntC;
    static char[][] matrix;
    static int[][] fireMatrix;
    static boolean[][] visited;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        cntR = Integer.parseInt(st.nextToken()); // r (행)
        cntC = Integer.parseInt(st.nextToken()); // c (열)
        
        matrix = new char[cntR][cntC];
        fireMatrix = new int[cntR][cntC];
        Queue<int[]> fireQ = new LinkedList<>();
        visited = new boolean[cntR][cntC];
        
        int startR = 0;
        int startC = 0;
        for (int i = 0; i < cntR; i++) {
            String s = br.readLine();
            Arrays.fill(fireMatrix[i], Integer.MAX_VALUE);
            
            for (int j = 0; j < cntC; j++) {
                matrix[i][j] = s.charAt(j);
                if (matrix[i][j] == 'J') {
                    startR = i;
                    startC = j;
                } else if (matrix[i][j] == 'F') {
                	fireQ.offer(new int[] {i, j, 0});
                	fireMatrix[i][j] = 0;
                }
            }
        }
        
        // 좌표별 불이 붙는 시간 저장
        while(!fireQ.isEmpty()) {
        	int[] cur = fireQ.poll();
        	for (int i = 0; i < 4; i++) {
        		int nr = cur[0] + dr[i];
        		int nc = cur[1] + dc[i];
        		
        		if (nr >= 0 && nr < cntR && nc >= 0 && nc < cntC) {
        			if (matrix[nr][nc] != '#' && fireMatrix[nr][nc] == Integer.MAX_VALUE) {
        				fireMatrix[nr][nc] = cur[2] + 1;
        				fireQ.offer(new int[] {nr, nc, cur[2]+1});
        			}
        		}
        	}
        }
        
        // 지훈이 이동
        visited = new boolean[cntR][cntC];
        int result = solve(startR, startC, 0);
        
        if (result == -1) {
        	System.out.println("IMPOSSIBLE");
        } else {
        	System.out.println(result);
        }

    }
    
    
    static int solve(int r, int c, int t) {
    	
    	 Queue<int[]> q = new LinkedList<>();
         visited[r][c] = true;
         q.offer(new int[] {r, c, t});
         
         while(!q.isEmpty()) {
             int[] cur = q.poll();
             int curR = cur[0];
             int curC = cur[1];
             int curT = cur[2];
             
             for (int i = 0; i < 4; i++) { 
                 int nr = curR + dr[i];
                 int nc = curC + dc[i];
                 
                 if (nr < 0 || nr >= cntR || nc < 0 || nc >= cntC) {
                	 return curT + 1;
                 } else {
                	 
                     if (!visited[nr][nc] && matrix[nr][nc] == '.' && fireMatrix[nr][nc] > curT + 1) {
                         visited[nr][nc] = true;
                         q.offer(new int[] {nr, nc, curT+1});
                     }
                 }
             }
         }
         
         return -1;
         
    }

}
