import sys

input = sys.stdin.readline

n = int(input())
score = [[], [], []]
result = []

for _ in range(n):
    a, b, c = map(int, input().split())
    score[0].append(a)
    score[1].append(b)
    score[2].append(c)

for i in range(n):
    s = 0
    for j in range(3):
        if score[j].count(score[j][i]) == 1:
            s += score[j][i]
    result.append(s)

for i in result:
    print(i)