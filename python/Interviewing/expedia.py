from typing import List


def sol(tools: List[str], target: str, startIndex: int):
    minimum = len(tools)

    for i, tool in enumerate(tools):
        if tool != target: continue

        right = abs(startIndex - i)
        left = abs(len(tools) - startIndex) + i
        current_min = min(right, left)
        minimum = min(minimum, current_min)

    return minimum


if __name__ == '__main__':
    tools = ["a", "b", "c", "d", "f", "c"]
    
    startIndex = 4
    print(sol(tools, "c", startIndex))
