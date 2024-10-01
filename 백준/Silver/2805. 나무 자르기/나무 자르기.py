import sys

input = sys.stdin.readline

n, m = map(int, input().split())
wood = list(map(int, input().split()))
start = 1
end = max(wood)

def cut(start, end):
    while start <= end:
        mid = (start + end) // 2
        get_wood = 0
        for w in wood:
            if w >= mid:
                get_wood += w - mid
        if get_wood >= m:
            start = mid + 1
        else:
            end = mid - 1
    return end

print(cut(start, end))