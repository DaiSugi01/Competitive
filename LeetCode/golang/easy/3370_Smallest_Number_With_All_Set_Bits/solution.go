package _370_Smallest_Number_With_All_Set_Bits

func smallestNumber(n int) int {
	for {
		if (n & (n + 1)) == 0 {
			return n
		}
		n++
	}
}

func SmallestNumber(n int) int {
	return smallestNumber(n)
}
