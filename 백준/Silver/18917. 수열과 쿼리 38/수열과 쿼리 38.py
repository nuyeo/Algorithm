import sys

input = sys.stdin.readline

A = [0]
total = 0
xor = 0
m = int(input())
for _ in range(m):
    query = list(map(int, input().split()))
    if query[0] == 1:
        A.append(query[1])
        total += query[1]
        xor ^= query[1]
    elif query[0] == 2:
        total -= query[1]
        xor ^= query[1]
    elif query[0] == 3:
        print(total)
    elif query[0] == 4:
        print(xor)
