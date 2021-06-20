
# Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
# An input string is valid if:
# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.

# s = "({[]})"
# True

# s = "()[]{}"
# True

# s = "([)]"
# False

# s = "[][]"
# True

def is_valid(s: str) -> bool:
    stack: [str] = []
    opening: [str] = ["(", "{", "["]

    for c in s:
        if c in opening:
            stack.append(c)
        else:
            bracket = stack.pop()
            if c != bracket:
                return False

    return True

# Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
# starti < endi
# [[0, 10], [5, 7], [20, 25]]
# False
#
# [[5, 7], [7, 10],  [20, 25]]
# False
#
# [ [2 ,4], [7 ,10]]
# True

def is_join(intervals: [int]) -> bool :
    intervals.sort(key=lambda x: x[1])
    for i in range(len(intervals) - 1):
        end: int = intervals[i][1]
        nx_start: int = intervals[i + 1][0]
        if nx_start < end:
            return False

    return True
