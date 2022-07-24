from collections import defaultdict
from typing import List


def find_last_dest(original_click, start):
    # make a map -> {origin: [dest]} --> {"Home": ["Home Cleaning"]}
    # deep first search
    if not start or not original_click:
        return None

    # O(N)
    adj_list = defaultdict(list)
    for click in original_click:
        origin, dest = click[0], click[1]
        adj_list[origin].append(dest)

    # O(N)
    def dfs(origin: str, adj_list: List[str]):
        if origin not in adj_list:
            return origin

        if origin in adj_list and not adj_list[origin]:
            return origin

        return dfs(adj_list[origin].pop(), adj_list)

    return dfs(start, adj_list)


if __name__ == '__main__':
    original_click = [
        ("Home", "Home Cleaning"),
        ("Home Cleaning", "Restaurants"),
        ("Restaurants", "Delivery"),
        ("Delivery", "Address Search"),
        ("Address Search", "Burgers"),
        ("Burgers", "Order Delivery"),
        ("Order Delivery", "Start Order"),
        ("Start Order", "Turkey Burger"),
        ("Turkey Burger", "Start Order"),
    ]
    # original_click = [
    #     ("Home", "Home Cleaning"),
    #     ("Home Cleaning", "Home"),
    # ]
    start = "Home"
    print(find_last_dest(original_click, start))
