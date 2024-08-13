import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

def isPrime(k):
    if k == 1:
        return False
    for j in range(2, k):
        if k % j == 0:
            return False
    return True
            
cnt = 0
for i in arr:
    if isPrime(i) == True:
        cnt += 1

print(cnt)