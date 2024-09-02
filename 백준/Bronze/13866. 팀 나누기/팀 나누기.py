arr = list(map(int, input().split()))
arr.sort()

result = (arr[0]+arr[3]) - (arr[1]+arr[2])

if result < 0:
    result = -result
    
print(result)