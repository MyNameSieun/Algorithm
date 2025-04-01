import sys

n=int(sys.stdin.readline().strip())
d=[]

for _ in range(n):
    d.append(int(sys.stdin.readline().strip()))

for i in sorted(d):
    print(i)

