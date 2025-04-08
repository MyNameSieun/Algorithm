import sys
input = sys.stdin.readline

times=[300, 60, 10]
n=int(input())

d=[]

for time in times:

    if n%times[2]!=0:
        print(-1)
        break


    d.append(n//time)
    n%=time

print(*d)