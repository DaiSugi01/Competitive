def solve(meal_cost, tip_percent, tax_percent):
    tip_cost = meal_cost * tip_percent * 0.01
    tax_cost = meal_cost * tax_percent * 0.01

    print(round(meal_cost + tip_cost + tax_cost))


if __name__ == '__main__':
    a = 12.00
    b = 20
    c = 8
    solve(a, b, c)
