import sys

input = sys.stdin.readline

n, m = map(int, input().split())

board = []
result = []

for _ in range(n):
    board.append(input().rstrip())

for k in range(n-7):
    for l in range(m-7):
        w = 0
        b = 0
        
        for i in range(k, k+8):
            for j in range(l, l+8):
                if ((i+j) % 2) == 0:
                    if board[i][j] != 'W':
                        b += 1
                    else:
                        w += 1
                else:
                    if board[i][j] != 'B':
                        b += 1
                    else:
                        w += 1
                                            
        result.append(min(w, b))

print(min(result))