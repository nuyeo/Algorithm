n, k = map(int, input().split())
count = 0
sum = 0

coin = []
for j in range(n):
    coin.append(int(input()))

for i in range(n):
    c = n-i-1
    count = k//coin[c]
    sum += count
    k -= count*coin[c]
    
print(sum)
    