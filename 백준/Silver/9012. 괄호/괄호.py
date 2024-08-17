import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    ps = list(input().rstrip())
    check = []
    cnt = True
    for i in ps:
        if i == "(":
            check.append(1)
        else:
            if len(check) == 0:
                cnt = False
                break
            else:
                check.pop()
                
    if len(check) > 0:
        cnt = False

    if cnt == True:
        print("YES")
    else:
        print("NO")