def update_bits(n: int, m: int, i: int, j: int):
    all_ones: int = ~0
    left: int = (all_ones << (j + 1)) if j < 31 else 0
    right: int = ((1 << i) - 1)
    print(bin(all_ones), bin(left), bin(right))

    mask: int = left | right
    print('n:', bin(n), 'mask:', bin(mask))

    n_cleared: int = n & mask
    m_shifted: int = m << i
    print(bin(n_cleared), bin(m_shifted))

    return bin(n_cleared | m_shifted)


if __name__ == '__main__':
    a = 0x100000000000
    b = 0x10011
    print('n:', a, 'm:', b)
    print((update_bits(a, b, 2, 6)))
