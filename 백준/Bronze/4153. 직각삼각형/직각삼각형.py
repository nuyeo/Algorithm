while True:
    arr = list(map(int, input().split()))
    arr.sort()
    x = arr[0]
    y = arr[1]
    z = arr[2]
    
    if x == y == z == 0:
        break
    else:
        if (x*x) + (y*y) == (z*z):
            print("right")
        else:
            print("wrong")