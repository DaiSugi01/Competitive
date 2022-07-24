from typing import List


def sol(tools: List[str], target: str, startIndex: int):
    minimum = len(tools)

    for i, tool in enumerate(tools):
        if tool != target: continue

        right = abs(startIndex - i)
        left = abs(len(tools) - startIndex) + i
        minimum = min(minimum, min(right, left))

    return minimum


if __name__ == '__main__':
    tools = ["a", "c", "c", "d", "f", "g"]
    startIndex = 4
    print(sol(tools, "c", startIndex))
