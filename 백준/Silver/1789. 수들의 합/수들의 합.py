import sys
input = sys.stdin.readline

n=int(input())
sum_val=0
d=[]
for i in range(0, n+1):
    if n==1:
        d.append(1)
    if sum_val>n:
        break
    d.append(i-1)
    sum_val+=i


print(max(d))


