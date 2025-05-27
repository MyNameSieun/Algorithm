from collections import Counter

s = input().upper()
counter = Counter(s)

max_counter=max(counter.values())

most_str= [str for str in counter if counter[str] == max_counter]

if len(most_str) > 1:
    print("?")
else:
    print(most_str[0])