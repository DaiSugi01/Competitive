# Write a method that takes in a string and will validate whether it is a correct ipv4 address or not.
# The method will return a boolean.

# 192.168.1.1 -> true
# 001.1.1.1
# 0 to 254


def is_validid(ip_adrress: str):
    # 192.168.1.1 -> true

    # make an array -> [192, 168, 1, 1]
    # validate if the length of the array is 4, otherwise return false;
    #
    if ip_adrress is None:
        return False

    adrressed = ip_adrress.split('.')
    if len(adrressed) != 4: return False

    for adrress in adrressed:
        if not adrress.isdecimal():
            return False

        if int(adrress) < 0 or int(adrress) > 254:
            return False

    return True


if __name__ == '__main__':
    print(is_validid(None)) # false
    print(is_validid("")) # false
    print(is_validid("1.1.1.1")) # true
    print(is_validid("192.169.1.1")) # true
    print(is_validid("001.1.1.1")) # true
    print(is_validid("192.168.1.1.1")) # false
    print(is_validid("192.168.1")) # false
    print(is_validid("192.169.i.1")) # false
    print(is_validid("192.169.255.1")) # false
    print(is_validid("192.168.1.1.")) # false
    print(is_validid("123")) # false
