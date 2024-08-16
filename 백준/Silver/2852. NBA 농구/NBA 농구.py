import sys

input = sys.stdin.readline

n = int(input())
goal1 = 0
goal2 = 0
time1 = []
time2 = []
end1 = []
end2 = []

win = 0 # 0은 비김, 1은 1팀 이김, 2는 2팀 이김

for _ in range(n):
    team, t = input().split()
    team = int(team)
    m, s = map(int, t.split(":"))
    
    if team == 1:
        goal1 += 1
    elif team == 2:
        goal2 += 1  

    if goal1 > goal2 and win != 1:
        time1.append((m, s))
        win = 1
    elif goal2 > goal1 and win != 2:
        time2.append((m, s))
        win = 2
    elif goal1 == goal2:
        if win == 1:
            end1.append((m, s))
        elif win == 2:
            end2.append((m, s))
        win = 0

if win == 1:
    end1.append((48, 0))
elif win == 2:
    end2.append((48, 0))


t1 = [0, 0]
t2 = [0, 0]

for i in range(len(time1)):
    min = end1[i][0] - time1[i][0]
    sec = end1[i][1] - time1[i][1]

    if sec < 0:
        min -= 1
        sec += 60

    t1[0] += min
    t1[1] += sec

    if t1[1] >= 60:
        t1[0] += 1
        t1[1] -= 60

for i in range(len(time2)):
    min = end2[i][0] - time2[i][0]
    sec = end2[i][1] - time2[i][1]

    if sec < 0:
        min -= 1
        sec += 60
        
    t2[0] += min
    t2[1] += sec

    if t2[1] >= 60:
        t2[0] += 1
        t2[1] -= 60
        
print(str(t1[0]).zfill(2) + ":" + str(t1[1]).zfill(2))
print(str(t2[0]).zfill(2) + ":" + str(t2[1]).zfill(2))