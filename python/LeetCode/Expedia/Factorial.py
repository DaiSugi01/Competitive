def fact(x: int) -> int:
    if x == 0:
        return 1

    return x * fact(x - 1)


if __name__ == '__main__':
    print(fact(5))
