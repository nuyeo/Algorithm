import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
arr = list(map(int, input().split()))

dic = {}
for i in arr:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1

cnt = 0

for j in arr:
    pair = m - j
    
    if j in dic and pair in dic:
        if j == pair:
            if dic[j] > 1:
                cnt += 1
                dic[j] -= 2
        else:
            cnt += 1
            dic[j] -= 1
            dic[pair] -= 1
            
        if dic[j] == 0:
            del dic[j]
        if pair in dic and dic[pair] == 0:
            del dic[pair]

print(cnt)