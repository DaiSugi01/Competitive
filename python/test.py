def solution(angles):
    stack = []
    res = []
    for angle in angles:
        if angle == '>':
            stack.append(angle)
        elif stack:
            res.append(stack.pop() + angle)
        else:
            res.append('<' + angle)

    return ''.join(res)


if __name__ == '__main__':
    print(solution("><<><"))
