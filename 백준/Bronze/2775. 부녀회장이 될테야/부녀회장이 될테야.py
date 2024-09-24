import sys

input = sys.stdin.readline

# k층의 n호 : (k-1)층의 1호부터 n호까지 사람들의 수의 합만큼 거주
# k층의 n호 == h[k][n-1]

bottom = list(range(1, 15))
h = [[]]
h[0] = bottom

t = int(input())
for _ in range(t):
    k = int(input())
    n = int(input())
    if k >= len(h):
        for i in range(len(h), k+1):
            sum = 0
            arr = []
            for j in range(14):
                sum += h[i-1][j]
                arr.append(sum)
            h.append(arr)
    print(h[k][n-1])