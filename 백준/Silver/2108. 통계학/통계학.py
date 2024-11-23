import sys

input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))
arr.sort()

def mode(arr):
    dict = {}
    for i in arr:
        if i in dict:
            dict[i] += 1
        else:
            dict[i] = 1
    max_dict = max(dict.values())
    mode_nums = []
    for i in dict:
        if dict[i] == max_dict:
            mode_nums.append(i)
    if len(mode_nums) > 1:
        return mode_nums[1]
    else:
        return mode_nums[0]

# 산술 평균
print(round(sum(arr)/n))
# 중앙값
print(arr[len(arr)//2])
# 최빈값
print(mode(arr))
# 범위
print(max(arr) - min(arr))