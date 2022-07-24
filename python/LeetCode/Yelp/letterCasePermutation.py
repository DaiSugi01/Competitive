def letterCasePermutation(self, s):
    # make an array to store the result -> res[[]]
    # loop through the given string
    # if it's alphabet, loop through the array n times which is the length of the res array
    #   ->  1. copy the ith array and add it to res array res[[]]   -> res[[]],          res[[a1], [A1], [a1]]
    #       2. add the lower char to the ith array                  -> res[[a], []]      res[[a1b], [A1], [a1]]
    #       3. add the upper char to the n+ith array                -> res[[a], [A]]     res[[a1b], [A1], [a1B]
    # Otherwise, just add it to the all inside array                -> res[[a,1], [A,1]] res[[a,1], [A,1]]
    res = [[]]
    for char in s:
        n = len(res)
        if char.isalpha():
            for i in range(n):
                res.append(res[i][:])
                res[i].append(char.lower())
                res[n+i].append(char.upper())
        else:
            for i in range(n):
                res[i].append(char)

    return map(''.join(), res)


