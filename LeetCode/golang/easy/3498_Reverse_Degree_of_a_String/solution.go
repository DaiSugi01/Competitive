package reverse_Degree_of_a_String

func reverseDegree(s string) int {
	var sum int
	for i, str := range s {
		val := int('z' - str + 1)
		sum += val * (i + 1)
	}

	return sum
}
