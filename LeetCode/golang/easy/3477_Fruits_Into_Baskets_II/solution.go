package fruits_Into_Baskets_II

// https://leetcode.com/problems/fruits-into-baskets-ii/description/
func numOfUnplacedFruits(fruits []int, baskets []int) int {
	occupied := len(baskets)
	for i := 0; i < len(fruits); i++ {
		for j := 0; j < len(baskets); j++ {
			if baskets[j] >= fruits[i] {
				baskets[j] = 0
				occupied--
				break
			}
		}
	}

	return occupied
}
