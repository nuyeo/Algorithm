t = int(input())
for i in range(t):
    n, s = input().split()
    arr = []
    for j in s:
        for k in range(int(n)):
            arr.append(j)
    print("".join(arr))