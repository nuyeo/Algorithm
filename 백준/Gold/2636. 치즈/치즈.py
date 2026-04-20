import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    q = deque([(0, 0)])
    visited = [[False] * m for _ in range(n)]
    visited[0][0] = True

    melt_list = []

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                visited[nx][ny] = True

                if matrix[nx][ny] == 0:
                    q.append((nx, ny))
                elif matrix[nx][ny] == 1:
                    melt_list.append((nx, ny))
    
    for x, y in melt_list:
        matrix[x][y] = 0

    return len(melt_list)

time = 0
last_melt = 0

while True:
    melt_cnt = bfs()
    if melt_cnt == 0:
        break
    last_melt = melt_cnt
    time += 1

print(time)
print(last_melt)