change=[500, 100, 50, 10, 5, 1]

buy=int(input())
price=1000-buy

d=[]
for i in change:
    d.append(price//i)
    price%=i

print(sum(d))
