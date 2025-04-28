import sys
input = lambda: sys.stdin.readline().strip()
from collections import deque


def bfs(l, start, end):
    dx = [-2, -1, 1, 2, 2, 1, -1, -2]
    dy = [1, 2, 2, 1, -1, -2, -2, -1]
    visited = [[-1]*l for _ in range(l)]
    visited[start[0]][start[1]] = 0


    queue = deque()
    queue.append(start)
    
    while queue:
        x, y = queue.popleft()

        if (x, y) == end:
            return visited[x][y]
        
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
   
            if (nx < 0 or nx >= l or ny < 0 or ny >= l):
                continue

            if visited[nx][ny] == -1:
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))


t = int(input())

for _ in range(t):
    l = int(input()) # 체스판
    x1, y1 = map(int, input().split()) # 시작
    x2, y2 = map(int, input().split()) # 도착


    print(bfs(l, (x1, y1), (x2, y2)))