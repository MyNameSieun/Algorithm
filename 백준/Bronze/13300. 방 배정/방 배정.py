import math
# 1. 3*6 크기의 2차원 배열생성 (students[학년][성별])
students=[[0] *2 for _ in range(7)]

# n=참가하는 학생 수, k=최대인원수
# 2. 사용자 입력(성별s, 학년y)을 받아 배열에다 추가
n,k=map(int, input().split())
for _ in range(n):
    s,y=map(int,input().split())
    students[y][s]+=1


# 3. 방 배정,
room=0
for grade in range(1,7):
    for gender in range(2):
        if students[grade][gender] >0:
            room+=math.ceil(students[grade][gender]/k)

print(room)