import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
graph = [list(input().rstrip()) for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True
    current_color = graph[x][y]
    
    while queue:
        cx, cy = queue.popleft()
        
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            
            if 0 <= nx < n and 0 <= ny < n:
                if not visited[nx][ny] and graph[nx][ny] == current_color:
                    visited[nx][ny] = True
                    queue.append((nx, ny))

visited = [[False] * n for _ in range(n)]
normal_count = 0

# 일반 사람
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j)
            normal_count += 1

# 적록색약
for i in range(n):
    for j in range(n):
        if graph[i][j] == 'R':
            graph[i][j] = 'G'

visited = [[False] * n for _ in range(n)]
color_blind_count = 0

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j)
            color_blind_count += 1

print(normal_count, color_blind_count)