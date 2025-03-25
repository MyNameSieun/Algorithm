# n=바구니 개수, m=바구니 역순 개수
n,m=map(int,input().split())

d=[]

for i in range(n):
    d.append(i+1)

for _ in range(m):
    a,b=map(int,input().split())
    d[a-1:b] = reversed(d[a-1:b])  

for i in d:
    print(i,end=" ")

