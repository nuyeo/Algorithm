from collections import deque

n, k = map(int, input().split())

q = deque([i for i in range(1, n+1)])
result = []

for _ in range(n):
    q.rotate(-k+1)
    a = q.popleft()
    result.append(a)

str = ", ".join(map(str, result))
print("<"+str+">")