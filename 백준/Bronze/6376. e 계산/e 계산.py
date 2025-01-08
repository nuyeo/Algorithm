def factorial(n):
    fac = 1
    for i in range(1, n+1):
        fac *= i
    return fac

e = [1, 2]
for i in range(2, 10):
    e.append(e[i-1] + (1 / factorial(i)))

print("n e")
print("- -----------")
for i in range(3):
    print(i, e[i])
for i in range(3, 10):
    print(i, "{:.9f}".format(e[i]))
