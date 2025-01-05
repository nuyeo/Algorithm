def balance(text):
    stack = []
    for c in text:
        if c == '(' or c == '[':
            stack.append(c)
        elif c == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                return False
        elif c == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                return False
    return len(stack) == 0

while True:
    text = input()
    if text == ".":
        break

    if balance(text):
        print("yes")
    else:
        print("no")
