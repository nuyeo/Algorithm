import sys

input = sys.stdin.readline

n, l = map(int, input().split())

result = 0
max = 0

for i in range(n):
    zebra = input().rstrip()
    k = zebra.count('10')

    if zebra[l-1] == '1':
        k += 1

    if k > max:
        max = k
        result = 1
    elif k == max:
        result += 1

print(max, result)