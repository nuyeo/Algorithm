n = int(input())
word = []
for _ in range(n):
    word.append(input())
    
w = list(set(word))

w.sort(key=lambda x: (len(x), x))

for i in w:
       print(i)