pice=[1,1,2,2,2,8]
d=list(map(int,input().split()))


for i in range(6):
    d[i]= pice[i]-d[i]

print(*d)