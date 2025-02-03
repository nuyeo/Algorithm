import sys

input = sys.stdin.readline

n, k = map(int, input().split())
max_x = 2000001
buckets = [0] * max_x

for _ in range(n):
    g, x = map(int, input().split())
    buckets[x] = g
    
window = sum(buckets[:2*k+1])
max_ice = window

for i in range(1, max_x - 2*k):
    window += buckets[i + 2*k]
    window -= buckets[i-1]
    max_ice = max(max_ice, window)
        
print(max_ice)