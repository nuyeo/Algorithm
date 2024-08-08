n, m = map(int, input().split())

basket = []
for b in range(n):
    basket.append(b+1)

for _ in range(m):
    i, j = map(int, input().split())
    basket[i-1:j] = basket[i-1:j][::-1]
    
print(*basket)