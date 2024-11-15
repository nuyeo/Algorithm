import sys

input = sys.stdin.readline

n, x = map(int, input().split())
a = list(map(int, input().split()))
arr = []

for i in a:
    if i < x:
        arr.append(i)
        
print(*arr)