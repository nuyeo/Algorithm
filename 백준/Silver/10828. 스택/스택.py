n = int(input())

cmd = []
arr = []

for _ in range(n):
    cmd.append(input())

for i in cmd:
    if i == "pop":
        if len(arr) == 0:
            print(-1)
        else:
            k = arr.pop()
            print(k)
    elif i == "size":
        print(len(arr))
    elif i == "empty":
        if len(arr) == 0:
            print(1)
        else:
            print(0)
    elif i == "top":
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[-1])
    else:
        p, m = i.split()
        arr.append(m)