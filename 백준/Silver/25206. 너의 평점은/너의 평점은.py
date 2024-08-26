cnt = 0.0
score = 0.0

for _ in range(20):
    s, n, m = input().split()
    k = float(n)
    cnt += k
    if m == 'A+':
        score += 4.5 * k
    elif m == 'A0':
        score += 4.0 * k
    elif m == 'B+':
        score += 3.5 * k
    elif m == 'B0':
        score += 3.0 * k
    elif m == 'C+':
        score += 2.5 * k
    elif m == 'C0':
        score += 2.0 * k
    elif m == 'D+':
        score += 1.5 * k
    elif m == 'D0':
        score += 1.0 * k
    elif m == 'P':
        cnt -= k

print(score / cnt)