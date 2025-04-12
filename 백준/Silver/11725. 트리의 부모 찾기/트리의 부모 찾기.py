from collections import deque


def bfs(start):
    queue = deque([start])
    visited[start] = 1

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                parent[i] = v  
                queue.append(i)
                visited[i] = 1


n = int(input())
graph = [[] for _ in range(n+1)]
visited =[0] * (n+1)
parent =[0] * (n+1)

for _ in range(n-1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

bfs(1)

for i in range(2, n+1):
    print(parent[i])