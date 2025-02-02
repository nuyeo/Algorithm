import sys

input = sys.stdin.readline
k, n = map(int, input().split())
lan = []
for _ in range(k):
    lan.append(int(input()))
start = 1
end = max(lan)
while start <= end:
    mid = (start + end) // 2
    l = 0
    for i in lan:
        l += i // mid
    if l >= n:
        start = mid + 1
    else:
        end = mid - 1

print(end)
        