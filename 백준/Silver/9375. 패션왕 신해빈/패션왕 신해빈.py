t = int(input())
for _ in range(t):
    n = int(input()) # 의상 수
    dic = {}
    for _ in range(n):
        name, category = input().split()
        if category not in dic:
            dic[category] = 1
        else:
            dic[category] += 1

    ans = 1
    for category in dic:
        ans *= (dic[category] + 1)
        
    print(ans - 1)
