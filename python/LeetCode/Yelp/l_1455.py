def isPrefixOfWord(sentence: str, searchWord: str) -> int:
    # make an string array by spliting the sentence -> [this, problem, is, an, easy, problem]
    # loop through the array, and check if the search word is prefix of the word or not
    #   if it's prefix -> return the index
    # return -1
    words = sentence.split(' ')

    for i, word in enumerate(words):
        n = len(searchWord)
        if len(word) < n: continue

        if word[0:n] == searchWord:
            return i + 1

    return -1
