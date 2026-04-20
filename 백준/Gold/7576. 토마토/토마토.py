import sys
from collections import deque

input = sys.stdin.readline

m, n = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

q = deque()

for i in range(n):
    for j in range(m):
        if matrix[i][j] == 1:
            q.append((i, j))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and matrix[nx][ny] == 0:
                
                matrix[nx][ny] = matrix[x][y] + 1
                q.append((nx, ny))
    
bfs()
max_day = 0
for i in range(n):
    for j in range(m):
        if matrix[i][j] == 0:
            print(-1)
            exit(0)
        max_day = max(max_day, matrix[i][j])

print(max_day - 1)