# n:바구니 개수, m:바구니 번호
n, m= map(int,input().split())
d=[0]*n

temp=0
for i in range(n):
    d[i]=i+1


for i in range(m):
    n1,n2=map(int,input().split())
    d[n1-1],d[n2-1] = d[n2-1], d[n1-1]


for i in range(n):
    print(d[i],end=" ")    


