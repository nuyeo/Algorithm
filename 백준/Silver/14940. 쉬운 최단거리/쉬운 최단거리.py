import sys
from collections import deque

input = sys.stdin.readline

# bfs
def bfs(x_start, y_start):
    q = deque()
    q.append([x_start, y_start])
    
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            # 그래프 밖을 벗어날 경우
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
                
            # 이미 방문한 지점일 경우
            if ans[nx][ny] != -1:
                continue
                
            # 유효한 지점
            ans[nx][ny] = ans[x][y] + 1
            q.append([nx, ny])
            
# 그래프 입력받기 (가로 m, 세로 n)
n, m = map(int, input().split())
graph = [] * n
# 변화율 (nesw)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
for _ in range(n):
    graph.append(list(map(int, input().split())))
    

x_start, y_start = 0, 0
ans = []
for i in range(n):
    ans.append([])
    for j in range(m):
        if graph[i][j] == 2:
            x_start, y_start = i, j
            ans[i].append(0)
        elif graph[i][j] == 1:
            ans[i].append(-1)
        else:
            ans[i].append(0)
    
bfs(x_start, y_start)

for i in range(n):
    print(*ans[i])