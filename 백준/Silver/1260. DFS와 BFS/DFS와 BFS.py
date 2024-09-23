import sys
from collections import deque

input = sys.stdin.readline

n, m, v = map(int, input().split())

# dfs 그래프 만들기
visited = [0] * (n+1)
g = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

for i in g:
    i.sort()

# dfs 함수
def dfs(g, v, visited):
    visited[v] = 1
    print(v, end=' ')
    for i in g[v]:
        if visited[i] == 0:
            dfs(g, i, visited)

# bfs 함수
def bfs(g, v, visited):
    q = deque([v])
    visited[v] = 0

    while q:
        p = q.popleft()
        print(p, end=' ')

        for i in g[p]:
            if visited[i] == 1:
                q.append(i)
                visited[i] = 0

dfs(g, v, visited)
print()
bfs(g, v, visited)