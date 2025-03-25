import sys

n=int(sys.stdin.readline())
n=sys.stdin.readline().strip()

sum=0
for x in n:
    sum+=int(x)

print(sum)