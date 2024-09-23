import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
m = int(input())

g = [[] for _ in range(n+1)]
result = []
visited = [False for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

for i in g:
    i.sort()

def dfs(graph, start, visited):
    q = deque([start])
    visited[start] = True

    while q:
        v = q.popleft()
        result.append(v)
        
        for i in g[v]:
            if not visited[i]:
                q.append(i)
                visited[i] = True

dfs(g, 1, visited)
print(len(result)-1)