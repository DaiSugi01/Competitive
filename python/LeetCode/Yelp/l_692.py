from collections import Counter
from typing import List


def topKFrequent(words: List[str], k: int) -> List[str]:
    # loop through the words array
    # check if the words is the most frequent or not maping the words to frequent { "i": 2,  }
    # sort result array and return it

    c = Counter(words)
    res = sorted(c.keys(), key=lambda x: (-c[x], x))

    return res[:k]


if __name__ == '__main__':
    words = ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"]
    k = 4
    print(topKFrequent(words, k))
