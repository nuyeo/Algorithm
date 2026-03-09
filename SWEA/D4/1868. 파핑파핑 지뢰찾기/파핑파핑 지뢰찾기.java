import java.io.*;
import java.util.*;

public class Solution {
	
	static int n;
	static char[][] matrix;
	static int[][] cntMap;
	static Node[][] nodes;
	static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1}; // 좌상, 상, 우상, 좌, 우, 좌하, 하, 우하
	static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			matrix = new char[n][n];
			cntMap = new int[n][n];
			nodes = new Node[n][n];
			
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					matrix[i][j] = s.charAt(j); // *: 지뢰 O, .: 지뢰 X
					nodes[i][j] = new Node(i, j);
					nodes[i][j].head = nodes[i][j];
				}
			}
			
			// 지뢰 개수 맵 채우기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					fillCntMap(i, j);
				}
			}
			
			// 인접한 0끼리 union
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] == '.' && cntMap[i][j] == 0) {
						makeUnion(i, j);
					}
				}
			}
			
			// 최종 head 개수 세기
			HashSet<Node> roots = new HashSet<>();
			boolean[][] popped = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] == '.' && cntMap[i][j] == 0) {
						roots.add(findSet(nodes[i][j]));
						popped[i][j] = true;
						// 0인 칸과 인접한 칸도 같이 터짐
						for (int d = 0; d < 8; d++) {
							int ni = i + dr[d];
							int nj = j + dc[d];
							if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
								if (matrix[ni][nj] == '.') popped[ni][nj] = true;
							}
						} 
					}
				}
			}
			
			// 클릭 횟수 = 0 그룹 개수(루트 개수) + 나머지 .인 칸들
			int clickCnt = roots.size();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] == '.' && !popped[i][j]) clickCnt++;
				}
			}
			
			
			sb.append("#").append(t).append(" ").append(clickCnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static class Node {
		
		int r;
		int c;
		int rank;
		Node head;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
			rank = 0;
			head = null;
		}
		
		protected Node(int r, int c, int rank, Node head) {
			this.r = r;
			this.c = c;
			this.rank = rank;
			this.head = head;
		}
	}
	
	static Node findSet(Node node) {
		
		if (node.head == node) {
			return node;
		}
		return node.head = findSet(node.head);
	}
	
	static void union(Node node1, Node node2) {
		
		Node root1 = findSet(node1);
		Node root2 = findSet(node2);
		
		// 두 노드의 루트가 다르면 하나로 합치기
		if (root1 != root2) {
			// 높이(rank)가 낮은 트리를 높은 트리에 붙이기
			if (root1.rank >= root2.rank) {
				root2.head = root1;
			} else {
				root1.head = root2.head;
				if (root1.rank == root2.rank) {
					root2.rank++;
				}
			}
		}
	}
	
	// 주변 8방향 지뢰 개수를 저장
	static void fillCntMap(int r, int c) {
		
		int bombCnt = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
				if (matrix[nr][nc] == '*') bombCnt++;
			}
		}
		cntMap[r][c] = bombCnt;
	}
	
	static void makeUnion(int r, int c) {
		
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
				if (matrix[nr][nc] == '.' && cntMap[nr][nc] == 0) {
					union(nodes[r][c], nodes[nr][nc]);
				}
			}
		}
	}

}
