def addTwoDigits(n):
    total = 0
    while n // 10 != 0:
        temp = n // 10
        total += temp
        n = n % 10


    return total + n

if __name__ == '__main__':
    print(addTwoDigits(29))