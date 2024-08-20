from collections import deque

n = int(input())

cmd = []
q = deque()

for _ in range(n):
    cmd.append(input())

for i in cmd:
    if i == "pop":
        if len(q) == 0:
            print(-1)
        else:
            k = q.popleft()
            print(k)
    elif i == "size":
        print(len(q))
    elif i == "empty":
        if len(q) == 0:
            print(1)
        else:
            print(0)
    elif i == "front":
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
    elif i == "back":
        if len(q) == 0:
            print(-1)
        else:
            print(q[-1])
    else:
        p, m = i.split()
        q.append(m)