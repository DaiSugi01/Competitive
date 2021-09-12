def add_angle(angles: str):
    stack = []
    open_count = 0
    for a in angles:
        if not stack and a == '>':
            open_count += 1
        elif stack and a == '>':
            stack.pop()
        else:
            stack.append(a)

    print(f"{'<' * open_count}{angles}{'>' * len(stack)}")


if __name__ == '__main__':
    angle = '<<'
    # angle = '><<><'
    add_angle(angle)


# ><<><
# <><<><>>