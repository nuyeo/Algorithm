import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static long[] guitars;
	static int maxSongs = 0;
	static int minGuitars = -1;

	public static void main(String[] args) throws Exception {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		guitars = new long[N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			String songs = st.nextToken();
			
			// 연주 가능한 곡을 비트마스크로 저장
			long bitmask = 0;
			for (int j=0; j<M; j++) {
				if (songs.charAt(j) == 'Y') bitmask |= (1L << (M-1-j));
			}
			guitars[i] = bitmask;
		}
		
		dfs(0, 0, 0);
		
		System.out.println(maxSongs==0 ? -1 : minGuitars);
		
	}
	
	// 백트래킹으로 모든 경우의 수 탐색
	static void dfs(int idx, long curMask, int cnt) {
		// 현재까지 합친 곡의 수
		int songCnt = Long.bitCount(curMask);
		
		if (songCnt > maxSongs) {
			maxSongs = songCnt;
			minGuitars = cnt;
		} else if (songCnt==maxSongs && songCnt>0) {
			if (minGuitars==-1 | cnt<minGuitars) minGuitars = cnt;
		}
		
		if (idx==N) return;
		
		// 현재 기타 선택
		dfs(idx+1, curMask|guitars[idx], cnt+1);
		
		// 현재 기타 선택 X
		dfs(idx+1, curMask, cnt);
	}

}
