import sys

input = sys.stdin.readline

n, m = map(int, input().split())

never_heard = []
result = []

for _ in range(n):
    name = input().rstrip()
    never_heard.append(name)

d = dict.fromkeys(never_heard, 0)

for _ in range(m):
    name = input().rstrip()
    if name in d:
        result.append(name)

result.sort()
print(len(result))
for k in result:
    print(k)