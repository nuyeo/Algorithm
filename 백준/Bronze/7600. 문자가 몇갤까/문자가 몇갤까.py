alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

while True:
    text = input()
    result = 0
    if text == '#':
        break
    t = set(text.lower())
    for i in t:
        if i in alphabet:
            result += 1
    print(result)
