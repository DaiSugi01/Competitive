def longestPathToSki(area):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    memo = {}
    def dfs(x: int, y: int, prev: int):
        nonlocal count
        nonlocal maximum
        # if (x, y) in memo:
        #     return memo[(x, y)] + 1

        if area[x][y] > prev:
            return

        for i in range(len(dx)):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= len(area) or ny < 0 or ny >= len(area[0]):
                continue
            if area[nx][ny] > area[x][y]:
                continue

            count += 1
            dfs(nx, ny, area[x][y])
            maximum = max(maximum, count + 1)
            memo[(x, y)] = count
            count -= 1


    maximum = 0
    count = 0
    for x in range(len(area)):
        for y in range(len(area[0])):
            dfs(x, y, area[x][y])

    for k, v in memo.items():
        print(k, v)

    return maximum + 1


if __name__ == '__main__':
    inp = [
        [1,2,3,4,5],
         [16,17,18,19,6],
         [15,24,25,20,7],
         [14,23,22,21,8],
         [13,12,11,10,9]]
    # inp = [
    #     [1, 2],
    #     [3, 4]
    # ]
    print(longestPathToSki(inp))