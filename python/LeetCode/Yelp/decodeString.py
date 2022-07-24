def decodeString(s: str) -> str:
    # I can use stack for this kind of problem
    # loop through the string and find the close bracket
    # if it's not the close bracket, add it to stack

    # 3[a2[c]]
    # stack -> 3, [, a
    # decoded_str -> [c]
    # base = 1 --- 2 * 1 = 2

    # stack -> blank
    # decoded_str -> [cc, a]
    # base = 1 --- 3 * 1 = 3
    # reverse the string and join it -> [acc] * 3
    # stack = [accaccacc]

    stack = []
    for c in s:
        if c == ']':
            decoded_str = []
            while stack[len(stack) - 1] != "[":
                decoded_str.append(stack.pop())
            stack.pop()
            base = 1
            k = 0

            while len(stack) > 0 and stack[len(stack) - 1].isdecimal():
                k += int(stack.pop()) * base
                base *= 10
            stack.append(''.join(reversed(decoded_str)) * k)
        else:
            stack.append(c)

    return ''.join(stack)
