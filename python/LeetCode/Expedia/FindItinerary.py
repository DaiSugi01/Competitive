# https://leetcode.com/problems/reconstruct-itinerary/
from collections import defaultdict
from typing import List


class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        # I feel like I can use dfs
        # make a map {"JFK": ["SFO", "AAA"], }
        # sort arrays
        # execute dfs
        #   get destination list from map
        #   go to the each destination
        #   append it to res array
        flight_map = defaultdict(list)
        res = []

        def dfs(origin: str):
            dest_list = flight_map[origin]
            while dest_list:
                next_dest = dest_list.pop()
                dfs(next_dest)
            res.append(origin)

        for ticket in tickets:
            origin, dest = ticket[0], ticket[1]
            flight_map[origin].append(dest)

        for origin, itinerary in flight_map.items():
            itinerary.sort(reverse=True)

        print(flight_map)
        dfs('JFK')

        print(res)
        return res[::-1]
