import sys

input = sys.stdin.readline

t = int(input())
zero = [1, 0, 1]
one = [0, 1, 1]

def fibo(x):
    if x >= len(zero):
        for i in range(len(zero), x+1):
            zero.append(zero[i-2] + zero[i-1])
            one.append(one[i-2] + one[i-1])
    print(" ".join([str(zero[x]), str(one[x])]))

for _ in range(t):
    n = int(input())
    fibo(n)