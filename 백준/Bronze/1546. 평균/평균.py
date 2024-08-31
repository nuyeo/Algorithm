import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
m = max(arr)
new_arr = []

for i in arr:
    k = (i / m) * 100
    new_arr.append(k)
    
result = sum(new_arr) / n
print(result)