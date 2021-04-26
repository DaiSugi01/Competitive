# https://leetcode.com/problems/goal-parser-interpretation/
def interpret(command: str) -> str:
    res: [str] = []
    i = 0

    while i < len(command):
        if command[i] == "G":
            res.append("G")
        elif command[i] + command[i+1] == "()":
            res.append("o")
            i += 1
        else:
            res.append("al")
            i += 3
        i += 1

    return ''.join(res)
