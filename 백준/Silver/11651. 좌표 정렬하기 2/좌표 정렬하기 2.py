import sys

input = sys.stdin.readline

n = int(input())
arr = []

for _ in range(n):
    x, y = map(int, input().split())
    arr.append([x, y])

arr.sort()
arr.sort(key = lambda x: x[1])
for i in arr:
    print(*i)
