import sys
input = sys.stdin.readline

n = int(input())
word = set()
for _ in range(n):
    word.add(input().rstrip())
    
w = list(word)

w.sort(key=lambda x: (len(x), x))

for i in w:
       print(i)