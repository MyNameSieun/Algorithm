import sys

n=int(sys.stdin.readline())

for i in range(n):

    s=sys.stdin.readline().strip()
    print(s[0],end="")
    print(s[-1])

