import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
card = list(map(int, input().split()))
card.reverse()
q = deque()

for i in range(n):
    if card[i] == 1:
        q.appendleft(i + 1)
    elif card[i] == 2:
        q.insert(1, i + 1)
    elif card[i] == 3:
        q.append(i + 1)

for i in q:
    print(i, end=" ")