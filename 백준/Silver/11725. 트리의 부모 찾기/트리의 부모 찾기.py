import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

# 그래프 만들기
g = [[] for _ in range(n+1)]
parents = [0 for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

# bfs 함수 정의
def bfs(graph, start):
    q = deque([start])
    while q:
        v = q.popleft()
        for i in g[v]:
            if parents[i] == 0:
                parents[i] = v
                q.append(i)

bfs(g, 1)

for j in range(2, n+1):
    print(parents[j])