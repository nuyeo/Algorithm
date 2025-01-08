import sys

input = sys.stdin.readline

n = int(input())
stack, answer, yes = [], [], True
now = 1

for _ in range(n):
    num = int(input())
    while now <= num:
        stack.append(now)
        answer.append("+")
        now += 1
    if stack[-1] == num:
        stack.pop()
        answer.append("-")
    else:
        yes = False

if yes:
    for i in answer:
        print(i)
else:
    print("NO")
