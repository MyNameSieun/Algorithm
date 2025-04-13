import sys
input = lambda: sys.stdin.readline().strip()

from collections import deque


def bfs(x, y):
    global size
    queue = deque()
    queue.append((x,y))
    graph[x][y] = 0
    size = 1 

    while queue:
        x,y = queue.popleft()
        
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx = dx + x
            ny = dy + y

            if nx < 0 or nx >= n or ny <0 or ny >= m:
                continue

            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))
                size += 1

    return size



n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

cnt = 0
max_size = 0

for x in range(n):
    for y in range(m):
        if graph[x][y] == 1:
            
            cnt += 1
            max_size = max(max_size, bfs(x, y))
            

print(cnt)
print(max_size) 