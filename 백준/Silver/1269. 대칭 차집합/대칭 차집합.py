import sys

input = sys.stdin.readline

# a의 원소의 개수 n, b의 원소의 개수 m
n, m = map(int, input().split())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

C = []

D = dict.fromkeys(A)

for i in B:
    if i in D:
        C.append(i)

k = len(C)
sum = (n - k) + (m - k)

print(sum)