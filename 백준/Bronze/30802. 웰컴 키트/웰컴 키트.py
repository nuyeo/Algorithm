import sys
import math

input = sys.stdin.readline

n = int(input())
shirt = list(map(int, input().rstrip().split()))
t, p = map(int, input().rstrip().split())

t_cnt = 0
for i in shirt:
    b = int(math.ceil(i / t))
    t_cnt += b

print(t_cnt)
print(n//p, n%p)