def get_bit(num: int, i: int) -> bool:
    """
        check whether ith bit is 1 or not
    """
    print(bin(num), bin(1 << i))
    return (num & (1 << i)) != 0


def set_bit(num: int, i: int):
    """
        set 1 to ith bit
    """
    print(bin(num), bin(1 << i))
    return bin(num | 1 << i)


def clear_bit(num: int, i: int):
    """
        clear ith bit to 0
    """
    print(bin(num), bin(~(1 << i)))
    return bin(num & ~(1 << i))


def clear_bits(num: int, i: int):
    """
        clear ith bits to 0
    """
    mask: int = (1 << i) - 1
    print(bin(num), bin(mask))

    return bin(num & mask)


def update_bits(num: int, i: int, is_bit_1: bool):
    """
        update ith bit
    """
    value: int = 1 if is_bit_1 else 0
    mask: int = ~(1 << i)
    print('num', bin(num), ', value', bin(value), ', mask', bin(mask))

    return bin((num & mask) | (value << i))


if __name__ == '__main__':
    # print(get_bit(5, 1))
    # print(set_bit(2, 1))
    # print(clear_bit(10, 1))
    # print(clear_bits(18, 6))
    print(update_bits(18, 1, False))
