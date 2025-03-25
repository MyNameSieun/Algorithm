import sys

d = list(map(int, sys.stdin.readline().strip().split()))

reversed_list = []
for i in d:
    reversed_num = int("".join(reversed(str(i))))
    reversed_list.append(reversed_num)

print(max(reversed_list))