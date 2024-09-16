n = int(input())

p = list(map(int, input().split()))

p.sort()

cnt = 0
result = []
sum = 0

for i in p:
    cnt += i
    result.append(cnt)

for j in result:
    sum += j

print(sum)