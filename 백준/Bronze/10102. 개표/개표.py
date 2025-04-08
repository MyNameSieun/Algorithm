import sys
input = sys.stdin.readline

n=int(input())
vote=input()

a_count=0
b_count=0

for i in vote:
    if i=="A":
        a_count+=1
    elif i=="B":
        b_count+=1

if a_count>b_count:
    print("A")

elif a_count<b_count:
    print("B")
else:
    print("Tie")
