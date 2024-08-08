from collections import deque

n = int(input())

card = deque()

for i in range(1, n+1):
    card.append(i)
    
while True:
    if len(card) == 1:
        break
    card.popleft()
    card.append(card.popleft())

result = card.popleft()
print(result)