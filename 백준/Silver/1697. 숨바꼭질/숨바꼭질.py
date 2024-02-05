# n, k 입력 받기
n, k = map(int, input().split())

# 큐에 pos, time 넣기
from collections import deque


# bfs 함수 구현
def bfs():
    # 위치, 시간(초) 변수 선언
    pos = n
    time = 0
    Q = deque([[pos, time]])
    
    # 방문 처리
    visited = [False] * 100001
    visited[pos] = True
    
    while Q:
        v = Q.popleft()
        pos, time = v[0], v[1]
        # k에 도달할 경우 종료
        if v[0] == k:
            print(time)
            break
            
        # 100,000 이하일 때까지 수행
        for npos in [pos+1, pos-1, pos*2]:
            if 0 <= npos <= 100000 and not visited[npos]:
                Q.append([npos, time+1])
                visited[npos] = True

        
bfs()
