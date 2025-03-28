a=int(input())
b=int(input())
c=int(input())

cal=str(a*b*c)

for i in range(10):
    print(cal.count(str(i)))