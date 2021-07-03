# https://leetcode.com/problems/nested-list-weight-sum/
from typing import List


class NestedInteger:
   def __init__(self, value=None):
       """
       If value is not specified, initializes an empty list.
       Otherwise initializes a single integer equal to value.
       """

   def isInteger(self):
       """
       @return True if this NestedInteger holds a single integer, rather than a nested list.
       :rtype bool
       """

   def add(self, elem):
       """
       Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
       :rtype void
       """

   def setInteger(self, value):
       """
       Set this NestedInteger to hold a single integer equal to value.
       :rtype void
       """

   def getInteger(self):
       """
       @return the single integer that this NestedInteger holds, if it holds a single integer
       Return None if this NestedInteger holds a nested list
       :rtype int
       """

   def getList(self):
       """
       @return the nested list that this NestedInteger holds, if it holds a nested list
       Return None if this NestedInteger holds a single integer
       :rtype List[NestedInteger]
       """


def depthSum(nestedList: List[NestedInteger]) -> int:
    def helper(d: int, nl: NestedInteger) -> int:
        def helper(d: int, nl: NestedInteger):
            if nl.isInteger():
                return d * nl.getInteger()

            total: int = 0
            for i in nl.getList():
                total += helper(d+1, i)

            return total

        total = 0
        for i in nestedList:
            total += helper(1, i)

        return total


if __name__ == '__main__':
    print(depthSum([[1,1],2,[1,1]]))
