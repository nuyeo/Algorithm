import sys
from collections import deque

input = sys.stdin.readline

n, m, r = map(int, input().split())
g = [[] for _ in range(n+1)]
result = [0 for _ in range(n+1)]
visited= [False for _ in range(n+1)]

for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)

def bfs(graph, start, visited):
    for j in graph:
        j.sort()
    q = deque([start])
    cnt = 0
    visited[start] = True

    while q:
        v = q.popleft()
        cnt += 1
        result[v] = cnt
        for i in g[v]:
            if not visited[i]:
                q.append(i)
                visited[i] = True

bfs(g, r, visited)
for j in range(1, n+1):
    print(result[j])