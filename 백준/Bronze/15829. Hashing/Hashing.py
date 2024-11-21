l = int(input())
word = list(input())

hash = 0
for i in range(l):
    hash += (ord(word[i]) - 96) * (31**i)
print(hash)