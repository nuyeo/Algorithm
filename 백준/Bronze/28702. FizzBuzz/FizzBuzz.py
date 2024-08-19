import sys

input = sys.stdin.readline

def fizzbuzz(i):
    if i % 3 == 0 and i % 5 == 0:
        print("FizzBuzz")
    elif i % 3 == 0:
        print("Fizz")
    elif i % 5 == 0:
        print("Buzz")
    else:
        print(i)

arr = []
for _ in range(3):
    arr.append(input().rstrip())

for j in arr:
    if j != "Fizz" and j != "Buzz" and j != "FizzBuzz":
        k = int(j) + (3 - arr.index(j))

fizzbuzz(k)
        

