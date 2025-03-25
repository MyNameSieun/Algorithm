s=int(input())

for _ in range(s):
    a,b=input().split()
    a=int(a)

    for str in b:
        print(str*a,end="")
    print("")