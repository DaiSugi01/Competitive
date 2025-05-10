package _304_Find_the_K_th_Character_in_String_Game_I

// https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/
func kthCharacter(k int) byte {
	length := 1
	for length < k {
		length <<= 1
	}

	return findK(k, length)
}

func findK(k, length int) byte {
	if length == 1 {
		return 'a'
	}
	half := length >> 1
	if k <= half {
		return findK(k, half)
	}
	c := findK(k-half, half)

	return byte((int(c-'a')+1)%26) + 'a'
}

// a
// ab  --> [a] and [b]
// abbc  --> [ab] and [bc]
// abbcbccd  --> [abbc] and [bccd]
