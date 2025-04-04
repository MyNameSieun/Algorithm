n=int(input())

d=[]
for i in range(n):
    d.append(int(input()))


if d.count(1) > d.count(0):
        print("Junhee is cute!")
else:
    print("Junhee is not cute!")