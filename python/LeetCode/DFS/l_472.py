# https://leetcode.com/problems/concatenated-words/
def findAllConcatenatedWordsInADict(words):
    d = set(words)

    def dfs(word):
        for i in range(1, len(word)):
            prefix = word[:i]
            suffix = word[i:]

            if prefix in d and suffix in d:
                return True
            if prefix in d and dfs(suffix):
                return True
            if suffix in d and dfs(prefix):
                return True

        return False

    res = []
    for word in words:
        if dfs(word):
            res.append(word)

    return res


if __name__ == '__main__':
    words = ["cat", "dog", "catdog"]
    print(findAllConcatenatedWordsInADict(words))
