def solution(angles):
    stack = []
    res = []
    for angle in angles:
        if angle == '>':
            stack.append(angle)
        elif stack:
            res.append(stack.pop() + angle)
        else:
            res.append('<' + angle)

    return ''.join(res)

from collections import Counter


def is_anaglam(s1: str, s2: str) -> bool:
    s_counter1 = Counter(s1)
    s_counter2 = Counter(s2)
    return s_counter1 == s_counter2


def q3(arr, target: int):
    set_nums = set(arr)
    res = set()
    for num in arr:
        s_num = abs(num - target)
        if s_num in set_nums:
            if num > s_num:
                num, s_num = s_num, num
            res.add((num, s_num))

    print(res)

from collections import defaultdict
def q4(words):
    dic = defaultdict(int)
    res = []
    for i, word in enumerate(words):
        if dic[word] == 0:
            res.append(word)
        else:
            res.append(word + f"{dic[word]}")
        dic[word] += 1
    print(res)


if __name__ == '__main__':
    words = ["tv", "musicPlayer", "microwave", "tv", "musicPlayer", "tv"]
    # Output: [tv, musicPlayer, microwave, tv1, musicPlayer1, tv2]
    q4(words)
    # print(solution("><<><"))
    # print(is_anaglam("strike", "listen"))
    # print(q3([1,2,3,0,2,3,4], 4))
