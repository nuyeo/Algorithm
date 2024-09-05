import sys

input = sys.stdin.readline

n = int(input())
arr = []

for _ in range(n):
    arr.append(int(input()))

def what_seq(arr):
    if arr[1] * arr[1] == arr[0] * arr[2]:
        result = arr[-1] * (arr[1] // arr[0])
    else:
        result = arr[-1] + (arr[1] - arr[0])
    return result

print(what_seq(arr))