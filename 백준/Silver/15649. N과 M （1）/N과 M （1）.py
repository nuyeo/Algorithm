n, m = map(int, input().split())

visited = [False] * (n+1)


def dfs(n, m, visited, result):
    if len(result) == m:
        print(*result)
        return
    for i in range(1, n+1):
        if visited[i] == False:
            result.append(i)
            visited[i] = True
            dfs(n, m, visited, result)
            result.pop()
            visited[i] = False

dfs(n, m, visited, [])
