# name1 = []
# name2 = []

name1 = list(input())
name2 = list(input())
arr1 = []
arr2 = []


l = [3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]

def name_match(arr):
    arr2 = []
    for m in range(len(arr)-1):
        a = ord(arr[m]) - 65
        b = ord(arr[m+1]) - 65
        sum = l[a] + l[b]
        if sum > 9:
            sum -= 10
        arr2.append(sum)
        
    while True:
        k = len(arr2) - 1
        arr3 = []
        if len(arr2) == 2:
            return arr2
        else:
            for i in range(k):
                sum = arr2[i] + arr2[i+1]
                if sum > 9:
                    sum -= 10
                arr3.append(sum)
            arr2 = arr3
            k = len(arr2) - 1
            arr3 = []

for j in range(len(name1)):
    arr1.append(name1[j])
    arr1.append(name2[j])

result = name_match(arr1)
print(str(result[0]) + str(result[1]))