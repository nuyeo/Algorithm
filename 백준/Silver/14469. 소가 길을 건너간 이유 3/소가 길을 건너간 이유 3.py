import sys

input = sys.stdin.readline

n = int(input())
cow = []
for _ in range(n):
    a, b = map(int, input().split())
    cow.append([a, b])

cow.sort()

time = 0
for i in cow:
    if time < i[0]:
        time = i[0]
    time += i[1]

print(time)