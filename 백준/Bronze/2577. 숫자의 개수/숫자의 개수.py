a = int(input())
b = int(input())
c = int(input())

s = list(str(a * b * c))
result = [0] * 10

for i in range(10):
    for j in s:
        if int(j) == i:
            result[i] += 1

for k in result:
    print(k)