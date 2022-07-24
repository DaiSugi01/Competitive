# https://www.geeksforgeeks.org/run-length-encoding/
def run_length_encoding(st: str) -> str:
    i = 0
    n = len(st)
    res = []
    while (i < n):
        count = 1

        while (i < n - 1 and st[i] == st[i + 1]):
            count += 1
            i += 1

        res.append(st[i] + f"{count}")
        i += 1

    return "".join(res)


if __name__ == '__main__':
    # output: w4a3d1e1x6
    inp = "wwwwaaadexxxxxxa"
    print(run_length_encoding(inp))
