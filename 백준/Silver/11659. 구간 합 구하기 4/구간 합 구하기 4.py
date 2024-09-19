n, m = map(int, input().split())

arr = list(map(int, input().split()))

arr2 = []
sum = 0

arr2.append(0)

for k in arr:
    sum += k
    arr2.append(sum)

for _ in range(m):
    i, j = map(int, input().split())
    result = arr2[j] - arr2[i-1]
    print(result)