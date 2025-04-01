import sys

n=int(sys.stdin.readline().strip())

n=str(n)
n=sorted(n, reverse=True)

for i in n:
    print(i, end="")