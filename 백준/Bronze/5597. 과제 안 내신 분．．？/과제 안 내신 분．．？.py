student = []
for _ in range(28):
    student.append(int(input()))

student.sort()

for i in range(1, 31):
    if i not in student:
        print(i)