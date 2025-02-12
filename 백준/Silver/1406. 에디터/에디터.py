import sys

left = list(sys.stdin.readline().rstrip())
right = []

for _ in range(int(sys.stdin.readline())):
    cmd = list(sys.stdin.readline().split())
    if cmd[0] == 'L':
        if left:
            right.append(left.pop())

    elif cmd[0] == 'D':
        if right:
            left.append(right.pop())

    elif cmd[0] == 'B':
        if left:
            left.pop()

    else:
        left.append(cmd[1])


left.extend(reversed(right))
print(''.join(left))
