package _347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram

// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/?envType=company&envId=twitter&favoriteSlug=twitter-more-than-six-months
func minSteps(s string, t string) int {
	chars := [26]int{}
	for i := 0; i < len(s); i++ {
		chars[s[i]-'a']++
		chars[t[i]-'a']--
	}

	var steps int
	for _, c := range chars {
		if c > 0 {
			steps += c
		}
	}

	return steps
}
