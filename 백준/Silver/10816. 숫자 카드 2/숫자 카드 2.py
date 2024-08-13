import sys

input = sys.stdin.readline

# 상근이가 가진 카드 개수 n
n = int(input())

# 숫자 카드에 적힌 정수
card = list(map(int, input().split()))

# 구해야 할 번호의 수 m
m = int(input())

# 상근이가 몇 개 가지고 있는지 구해야 할 카드의 숫자
numbers = list(map(int, input().split()))

# 딕셔너리에 카드와 개수 저장하기
dic = {}
for i in card:
    if i not in dic:
        dic[i] = 1
    else:
        dic[i] += 1

      
# 개수 출력하기
arr = []
for j in numbers:
    if j not in dic:
        arr.append(0)
    else:
        arr.append(dic[j])
        
print(*arr)
# print(' '.join(arr))