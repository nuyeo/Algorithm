n = int(input())
arr = []

for _ in range(n):
    a, b = map(int, input().split())
    arr.append((a, b))
    

for i in range(n):
    a = arr[i][0]
    b = arr[i][1]
    sum = a + b
    print("Case #{0}: {1} + {2} = {3}".format(i+1, a, b, sum))