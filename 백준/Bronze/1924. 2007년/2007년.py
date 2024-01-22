m, d = input().split()
m = int(m)
d = int(d)
s = 0

list = [3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3]
day = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"]

for i in range(0, m-1):
    s += list[i]

c = (s+d)%7        
        
print(day[c])

