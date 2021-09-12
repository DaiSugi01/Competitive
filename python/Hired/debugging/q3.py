from functools import reduce
import typing


class VendingItem:
    def __init__(self, arr):
        self.column = arr[0]
        self.row = arr[1]
        self.cost_cents = arr[2]
        self.remaining_quantity = arr[3]


def solution(inventory: typing.List[typing.List[int]], purchaseAttempts: typing.List[typing.List[int]]) -> int:
    items = list(map(VendingItem, (i for i in inventory if len(i) == 4)))
    column_count = reduce(lambda acc, item: max(acc, item), (i.row for i in items)) + 1
    row_count = reduce(lambda acc, item: max(acc, item), (i.column for i in items)) + 1

    grid = [[None for row in range(column_count)] for col in range(row_count)]
    for item in items:
        grid[item.column][item.row] = item

    for purchase_coordinate in purchaseAttempts:
        purchase_column = purchase_coordinate[0]
        purchase_row = purchase_coordinate[1]
        if len(grid) <= purchase_column:
            continue

        column = grid[purchase_column]
        if column is None or len(column) <= purchase_row:
            continue
        if column[purchase_row] is None:
            continue

        item = column[purchase_row]
        item.remaining_quantity -= 1

    return reduce(lambda acc, item: acc + (item.remaining_quantity * item.cost_cents), items, 0)


if __name__ == '__main__':
    inventory = [[0], [0, 5, 20, 3]]
    purchaseAttempts = [[0, 1], [0, 5]]
    print(solution(inventory, purchaseAttempts))
