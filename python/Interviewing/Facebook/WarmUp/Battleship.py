from typing import List

def getHitProbability(R: int, C: int, G: List[List[int]]) -> float:
  return sum(map(sum, G)) / (R * C)


if __name__ == '__main__':
    R = 2
    C = 3
    G = [
        [0, 1, 0],
        [1, 0, 1]
    ]
    getHitProbability(R, C, G)
