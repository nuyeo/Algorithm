import sys

input = sys.stdin.readline

n = int(input())
s = set()


for _ in range(n):
    string = input().rstrip().split()
    cmd = string[0]
    k = 0
    if len(string) > 1:
        k = int(string[1])

    if cmd == "add":
        s.add(k)
    elif cmd == "remove":
        s.discard(k)
    elif cmd == "check":
        if k in s:
            print(1)
        else:
            print(0)
    elif cmd == "toggle":
        if k in s:
            s.discard(k)
        else:
            s.add(k)
    elif cmd == "all":
        s = set(range(1, 21))
    elif cmd == "empty":
        s = set()