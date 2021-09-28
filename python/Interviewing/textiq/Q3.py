def hasDeadlock(connections):
    visited = [False for _ in range(len(connections))]

    def dfs(vertex, adjList, visited):
        visited[vertex] = True
        for v in adjList[vertex]:
            if visited[v]:
                return True
            else:
                return dfs(v, adjList, visited)

        return False

    return dfs(1, connections, visited)


if __name__ == '__main__':
    inp = [[1],
 [2],
 [3,4],
 [4],
 [0]]
    # inp = [
    #     [1, 6],
    #     [2],
    #     [3],
    #     [4],
    #     [5],
    #     [3],
    # ]
    print(hasDeadlock(inp))