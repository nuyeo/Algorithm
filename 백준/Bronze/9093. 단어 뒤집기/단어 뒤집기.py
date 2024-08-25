import sys

input = sys.stdin.readline

n = int(input())

for _ in range(n):
    str = input().rstrip()
    arr = list(str.split())
    arr2 = []
    for i in arr:
        arr2.append(i[::-1])
    result = " ".join(arr2)
    print(result)