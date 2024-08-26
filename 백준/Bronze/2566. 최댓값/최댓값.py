arr = []

for _ in range(9):
    k = list(map(int, input().split()))
    arr.append(k)

max = 0

for i in range(9):
    for j in range(9):
        if arr[i][j] >= max:
            max = arr[i][j]
            result = [i+1, j+1]

print(max)
print(*result)