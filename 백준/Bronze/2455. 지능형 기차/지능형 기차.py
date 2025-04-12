take=0
d=[]
for _ in range(4):
    a, b= map(int, input().split())
    take += (b-a)
    d.append(take)

print(max(d))