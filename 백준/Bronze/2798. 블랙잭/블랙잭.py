from itertools import combinations

n,m=map(int, input().split())
nums=list(map(int, input().split()))

total=0
best_sum = 0
for comb in combinations(nums,3):
    total=sum(comb)

    if total <= m and total > best_sum:
        best_sum = total

print(best_sum)