from collections import deque

# 도시의 수 n 입력받기
n = int(input())

# 여행 계획에 속한 도시들의 수 m 입력받기
m = int(input())

# 도시 연결 정보 입력받기
city = [list(map(int, input().split())) for _ in range(n)]

# 여행 계획 입력받기
plan = list(map(int, input().split()))

# bfs로 연결 정보 탐색하기
def bfs(start, end):
    q = deque()
    q.append(start)
    visited = [False] * n
    visited[start] = True

    while q:
        p = q.popleft()

        if p == end:
            return True

        for i in range(n):
            if city[p][i] == 1 and not visited[i]:
                visited[i] = True
                q.append(i)

    return False

answer = True
for i in range(m-1):
    if plan[i] != plan[i+1]:
        if not bfs(plan[i]-1, plan[i+1]-1):
            answer = False
            break

# 정답 판별하기
if answer == True:
    print('YES')
else:
    print('NO')