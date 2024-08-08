student = []
for _ in range(28):
    student.append(int(input()))

for i in range(1, 31):
    if i not in student:
        print(i)