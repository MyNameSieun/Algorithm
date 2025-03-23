# 1. 2차원 배열로 받는다(3x3)
# 2. 1번째 열의 요소들을 100으로 나눈 나머지를 join으로 문자열 이어 붙여 첫 번째 팀명을 구한다
# 3. 0번째 열의 요소들을 기준으로 오름차순으로 sorted를 통해 정렬한다.
# 4. 그 후, 2번째 열의 요소들의 리스트로 변환하여 0번째 인덱스를 추출한다.
# 5. 마지막으로 join을 통해 리스트를 이어 붙여 두 번째 팀명을 구한다.


arr=[input().split() for _ in range(3)]
col_1 = sorted([int(arr[i][1]) % 100 for i in range(3)])


result1="".join(str(x) for x in col_1)

print(result1)



sorted_arr=sorted(arr, key=lambda x:int(x[0]), reverse=True)

col_2 = [x[2][0] for x in sorted_arr]
result2 = "".join(col_2)
print(result2)