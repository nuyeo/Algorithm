n, q = map(int, input().split())
arr = [0] * (n)

for _ in range(q):
    l, i = map(int, input().split())
    for j in range(l-1, n, i):
        arr[j] = 1

print(arr.count(0))