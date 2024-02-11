# 이진 탐색 소스코드 구현 (반복문)
def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        # 찾은 경우 중간점 인덱스 반환
        if array[mid] == target:
            return mid
        # 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        elif array[mid] > target:
            end = mid - 1
        # 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else:
            start = mid + 1
    return None

# n개의 정수 입력
n = int(input())
array = list(map(int, input().split()))
array.sort() # 이진 탐색 수행을 위해 정렬

# m개의 수 입력
m = int(input())
x = list(map(int, input().split()))

# x가 n개의 정수 배열에 속해있는지 하나씩 확인
for i in x:
    # 해당 수가 존재하는지 확인
    result = binary_search(array, i, 0, n - 1)
    if result != None:
        print("1")
    else:
        print("0")