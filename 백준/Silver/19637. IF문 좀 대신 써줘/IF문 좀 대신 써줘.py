import sys

n, m = map(int, sys.stdin.readline().split())

system = {}
for i in range(n):
    name, standard = sys.stdin.readline().split()
    system[i] = int(standard), name

def binary_search(array, target, start, end):
    res = 0
    while start <= end:
        mid = (start + end) // 2 
        if array[mid][0] >= target:
            end = mid - 1
            res = mid
        else:
            start = mid + 1
    return array[res][1]

for j in range(m):
    target = int(sys.stdin.readline())
    result = binary_search(system, target, 0, n-1)
    print(result)
