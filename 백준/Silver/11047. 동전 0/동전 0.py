n,k=map(int, input().split())

coins=[]
count=0
for _ in range(n):
    a=coins.append(int(input()))

coins.sort(reverse=True)

for coin in coins:
    if k>=coin:
        count+=k//coin
        k%=coin



print(count)
