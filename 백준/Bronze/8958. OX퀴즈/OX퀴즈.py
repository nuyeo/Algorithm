n = int(input())

for i in range(n):
    score = 0
    count = 1
    s = list(input())
    for j in s :
        if j=="O":
            score+=count
            count+=1
        else:
            count=1
    print(score)