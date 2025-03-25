n = set()
for _ in range(28):
    n.add(int(input()))


all_students = set(range(1,31))
not_submitted = sorted(all_students-n)

print(not_submitted[0])
print(not_submitted[1])
        
