s = list(input())
dict = {}
result = [-1] * 26

for i in range(len(s)):
    if s[i] not in dict:
        dict[s[i]] = i

for i in range(26):
    if chr(i + 97) in dict:
        result[i] = dict[chr(i + 97)]

print(*result)