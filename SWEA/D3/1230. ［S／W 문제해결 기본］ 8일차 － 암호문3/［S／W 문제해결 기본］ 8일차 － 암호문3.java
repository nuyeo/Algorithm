import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // nodePool 객체 생성
        for (int i = 0; i < 100000; i++) nodePool[i] = new Node();

        for (int t = 1; t <= 10; t++) {
            init();

            // 1. 입력 받기
            int N = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                add(Integer.parseInt(st.nextToken()));
            }

            int cmdCnt = Integer.parseInt(br.readLine());
            
            // 2. 명령어 처리
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < cmdCnt; c++) {
                if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();

                switch (cmd) {
                    case "I":
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());
                        int[] ins_s = new int[y];
                        for (int j = 0; j < y; j++) ins_s[j] = Integer.parseInt(st.nextToken());
                        insert(x, ins_s);
                        break;
                    case "D":
                        int del_x = Integer.parseInt(st.nextToken());
                        int del_y = Integer.parseInt(st.nextToken());
                        delete(del_x, del_y);
                        break;
                    case "A":
                        int add_y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < add_y; j++) add(Integer.parseInt(st.nextToken()));
                        break;
                }
            }

            // 결과 출력
            sb.append("#").append(t).append(" ");
            int cur = nodePool[head].link;
            for (int i = 0; i < 10; i++) {
                sb.append(nodePool[cur].data).append(" ");
                cur = nodePool[cur].link;
                if (cur == -1) break;
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
	
	static class Node {
		int data;
		int link;
		
		void set(int data, int link) {
			this.data = data;
			this.link = link;
		}
	}
	
	static Node[] nodePool = new Node[1000000];
	static int nodeCnt, head, tail;
	
	static void init() {
		nodeCnt = 0;
		head = 0;
		tail = 0;
		nodePool[head].set(-1, -1);
		nodeCnt++;
	}
	
	
	public static void insert(int x, int[] s) {
		int cur = head;
        
		// 1. x번째 노드 주소 찾기
		for (int i=0; i<x; i++) {
			cur = nodePool[cur].link;			
		}
        
		// 2. x번째 노드의 link를 임시 변수에 저장
		int nextTmp = nodePool[cur].link;
        
		// 3. nodePool의 맨 뒤에 차례로 데이터 추가하고 link에 인덱스 저장
		for (int val : s) {
			int newIdx = nodeCnt++;
			nodePool[newIdx].set(val, -1);
			nodePool[cur].link = newIdx;
			cur = newIdx;	
		}
        
		// 4. 추가한 데이터 중 가장 마지막 노드의 link를 저장해둔 주소로 설정
		nodePool[cur].link = nextTmp;
		
		// 5. 만약 맨 마지막 위치에 삽입했으면 tail 업데이트
		if (nextTmp == -1) tail = cur;
	}
	
	public static void delete(int x, int y) {
		int cur = head;
		
		// 1. x번째 노드 주소 찾기
		for (int i=0; i<x; i++) {
			cur = nodePool[cur].link;
		}
		
		// 2. 삭제 범위 다음 노드 찾기
		int nextIdx = nodePool[cur].link; // 삭제될 첫 번째 노드
		for (int j=0; j<y; j++) {
			if (nextIdx == -1) break;
			nextIdx = nodePool[nextIdx].link;
		}
		
		// 3. x번째 노드의 link를 삭제 범위 다음 노드 인덱스로 변경
		nodePool[cur].link = nextIdx;
		if (nextIdx == -1) tail = cur;
	}
	
	public static void add(int val) {
        int newNodeIdx = nodeCnt++;
        nodePool[newNodeIdx].set(val, -1);
        nodePool[tail].link = newNodeIdx;
        tail = newNodeIdx;
    }


}
