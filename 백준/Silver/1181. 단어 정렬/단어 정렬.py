n = int(input())
w = []
for _ in range(n):
    word = input()
    l = list(word)
    w.append((len(l), word))
    
w.sort(key=lambda x: (x[0], x[1]))

lst = []

for i in w:
    lst.append(i[1])

result = dict.fromkeys(lst)
result = list(result)

for j in result:
    print(j)