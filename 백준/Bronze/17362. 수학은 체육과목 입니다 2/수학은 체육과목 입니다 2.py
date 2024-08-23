n = int(input())

k = n % 8
if k == 1:
    print("1")
elif k == 2 or k == 0:
    print("2")
elif k == 3 or k == 7:
    print("3")
elif k == 4 or k == 6:
    print("4")
elif k == 5:
    print("5")