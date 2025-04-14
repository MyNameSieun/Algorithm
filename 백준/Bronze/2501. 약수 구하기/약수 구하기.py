import sys
input = sys.stdin.readline

n, k = map(int, input().split())

d=[]
for i in range(1,n+1):
    if n%i==0:
        d.append(i)


d.sort()

if k <= len(d):
    print(d[k-1])
else:
    print(0)