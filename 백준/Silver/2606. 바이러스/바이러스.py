import sys
input = lambda: sys.stdin.readline().strip()

from collections import deque

def bfs(start):
    queue = deque([start])
    visited[start] = 1

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = 1


n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]
visited =[0] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

bfs(1)


result=0
for i in range(2, n+1):
    if visited[i]>0:
        result +=1

    
print(result)