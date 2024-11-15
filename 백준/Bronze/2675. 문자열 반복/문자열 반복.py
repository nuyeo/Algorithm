t = int(input())
for _ in range(t):
    n, s = input().split()
    for i in s:
        print(i*int(n), end="")
    print()