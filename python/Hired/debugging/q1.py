import typing


def solution(prices: typing.List[float], trades: typing.List[typing.List[int]]) -> float:
    shares_held = []
    profit = 0

    for i, trade in enumerate(trades):
        is_purchase = trade[1] > 0
        shares_traded = trade[1]
        price = prices[i]

        for i in range(abs(shares_traded)):
            if is_purchase:
                shares_held.append(price)
            else:
                profit += price - shares_held.pop()

    return profit


if __name__ == '__main__':
    prices = [1, 2, 3, 4]
    trades = [[0, 10], [1, -5], [2, 10], [3, -15]]
    print(solution(prices, trades)) # 30
