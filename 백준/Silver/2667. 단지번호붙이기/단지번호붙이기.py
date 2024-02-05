import sys
sys.setrecursionlimit(10**8)

# 단지 크기 n 입력 받기
n = int(input())

# 2차원 리스트의 맵 정보 입력 받기
graph = []
for i in range(n):
    graph.append(list(map(int, input())))
count = 0
    
# DFS로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
def dfs(x, y):
    # 집의 수 변수 설정
    global count
    # 주어진 범위를 벗어날 경우 즉시 종료
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False
    # 현재 노드를 아직 방문하지 않았다면
    if graph[x][y] == 1:
        # 해당 노드 방문 처리
        count += 1
        graph[x][y] = 0
        # 상하좌우 위치 모두 재귀적 호출
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False
                 
# 총 단지 수 및 집의 수 출력
home = []
for i in range(n):
    for j in range(n):
        # 현재 위치에서 dfs 수행
        if dfs(i, j) == True:
            home.append(count)
            count = 0
home.sort()           
                 
print(len(home))
for i in home:
    print(i)
