import sys

input = sys.stdin.readline

n = int(input())
w = []
for _ in range(n):
    w.append(int(input()))

weight = 0
k = 0
arr = []

w = sorted(w, reverse=True)

for i in range(n):
    max_w = w[i] * (i+1)
    arr.append(max_w)

print(max(arr))