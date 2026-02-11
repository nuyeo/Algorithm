import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, answer;
	static int[][] matrix = new int[4001][4001];
	static int[] dx = {0, 0, -1, 1}; // 0:상, 1:하, 2:좌, 3:우
	static int[] dy = {1, -1, 0, 0};
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			answer = 0;
			ArrayList<Atom> atoms = new ArrayList<>();
			
			for (int n=0; n<N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				
				// 좌표 2배 확대, 음수 제거
				atoms.add(new Atom(2*(x+1000), 2*(y+1000), dir, energy)); 
			}
			
			simul(atoms);
			sb.append("#"+t+" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void simul(ArrayList<Atom> atoms) {
		// 범위 내에서 이동
		for (int s=0; s<=4000; s++) {
			if (atoms.isEmpty()) break;
			
			// 모든 원자 이동
			for (Atom a : atoms) {
				a.move();
			}
			
			// 맵에 에너지 표시
			for (Atom a : atoms) {
				if (a.x<0 || a.x>4000 || a.y<0 || a.y>4000) {
					a.isOut = true;
					continue;
				}
				matrix[a.x][a.y] += a.energy; 
			}
			
			// 충돌 검사 및 소멸 처리
			Iterator<Atom> it = atoms.iterator();
			while (it.hasNext()) {
				Atom a = it.next();
				
				if (a.isOut) {
					it.remove();
					continue;
				}
				
                // 충돌했을 경우 (내 에너지보다 저장된 에너지가 클 경우)
				if (matrix[a.x][a.y] > a.energy) {
					answer += a.energy;
					a.isDead = true; // 소멸 처리
				}
			}
			
            // 맵 청소
			it = atoms.iterator();
            while (it.hasNext()) {
				Atom a = it.next();
				// 맵에 기록한 좌표 초기화
				if (!a.isOut()) {
					matrix[a.x][a.y] = 0;
				}
				// 소멸한 원자들 목록에서 제거
				if (a.isDead) {
					it.remove();
				}
			}
		}
	}

	static class Atom {
		int x, y;
		int dir;
		int energy;
		boolean isOut, isDead;
		
		public Atom(int x, int y, int dir, int energy) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}
		
		public void move() {
			this.x += dx[dir];
			this.y += dy[dir];
		}

        public boolean isOut() {
			return x< 0 || x>4000 || y<0 || y>4000;
		}
	}
}
