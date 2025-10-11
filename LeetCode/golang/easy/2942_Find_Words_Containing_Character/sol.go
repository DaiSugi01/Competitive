package _942_Find_Words_Containing_Character

import (
	"strings"
)

// https://leetcode.com/problems/find-words-containing-character/
func findWordsContaining(words []string, x byte) []int {
	collection := make([]int, 0, len(words))
	for i, w := range words {
		if strings.Ind.exByte(w, x) >= 0 {
			collection = append(collection, i)
		}
	}

	return collection
}
