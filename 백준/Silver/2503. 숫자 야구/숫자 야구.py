import sys

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

answer = 0

for a in range(1, 10): # 100의 자리
    for b in range(1, 10): # 10의 자리
        for c in range(1, 10): # 1의 자리
            if a == b or b == c or c == a:
                continue
            cnt = 0
            for question in arr:
                num = question[0] # 민혁이가 말한 수
                strike = question[1]
                ball = question[2]
                
                strike_cnt = 0
                ball_cnt = 0

                x = num // 100
                y = (num - x*100) // 10
                z = (num - x*100 - y*10)

                if a == x:
                    strike_cnt += 1
                elif a == y or a == z:
                    ball_cnt += 1

                if b == y:
                    strike_cnt += 1
                elif b == x or b == z:
                    ball_cnt += 1

                if c == z:
                    strike_cnt += 1
                elif c == x or c == y:
                    ball_cnt += 1

                if strike_cnt == strike and ball_cnt == ball:
                    cnt += 1

            if cnt == n:
                answer += 1

print(answer)
