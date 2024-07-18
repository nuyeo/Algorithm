# 사람의 수 n 입력받기
n = int(input())

# 체력 정의
hp = 99

# 인사했을 때 잃는 체력 입력받기
hello_hp = list(map(int, input().split()))

# 인사했을 때 얻는 기쁨 입력받기
hello_joy = list(map(int, input().split()))

# dp를 통해 최적 값 구하기
def dp(hp, hello_hp, hello_joy, n):
    k = [[0 for _ in range(hp+1)] for _ in range(n+1)]

    for i in range(n+1):
        for h in range(hp+1):
            if i == 0 or h == 0:
                k[i][h] = 0
            elif hello_hp[i-1] <= h:
                k[i][h] = max(hello_joy[i-1]+k[i-1][h-hello_hp[i-1]], k[i-1][h])
            else:
                k[i][h] = k[i-1][h]
    return k[n][hp]

print(dp(hp, hello_hp, hello_joy, n))