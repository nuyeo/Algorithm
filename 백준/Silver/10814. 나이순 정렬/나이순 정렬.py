import sys

input = sys.stdin.readline

n = int(input())
member = []

for _ in range(n):
    age, name = input().rstrip().split()
    member.append((int(age), name))
    
member = sorted(member, key=lambda x: x[0])

for i in member:
    print(*i)