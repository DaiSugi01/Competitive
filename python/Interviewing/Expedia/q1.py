# FizzBuzz
# Write a method that takes in an integer and will print integers 1 to N (including N). But print
# “Fizz” if the integer is divisible by 3 and “buzz” if an integer is divisible by “5” and “fizzbuzz” for integers divisible by both 3 and 5

# Input: FizzBuzz(20);
# Output:
# 1
# 2
# fizz
# 4
# buzz
# fizz
# 7
# 8
# fizz
# buzz
# 11
# fizz
# 13
# 14
# fizzbuzz
# 16
# 17
# fizz
# 19
# buzz

def fizzbuzz(n: int):
    for i in range(1, n+1):
        if i % 5 == 0 and i % 3 == 0:
            print("fizzbuzz")
        elif i % 3 == 0:
            print("Fizz")
        elif i % 5 == 0:
            print("buzz")
        else:
            print(i)


if __name__ == '__main__':
    fizzbuzz(20)