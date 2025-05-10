package _330_Find_the_Original_Typed_String_I

// https://leetcode.com/problems/find-the-original-typed-string-i/
func possibleStringCount(word string) int {
	res := 1
	memo := make(map[int32]int)
	for i, w := range word {
		if idx, ok := memo[w]; ok && idx+1 == i {
			res++
		}
		memo[w] = i
	}

	return res
}

func PossibleStringCount(word string) int {
	return possibleStringCount(word)
}
