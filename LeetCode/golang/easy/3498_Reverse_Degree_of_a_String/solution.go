package reverse_Degree_of_a_String

func reverseDegree(s string) int {
	const alpDivide = 26
	var sum int
	for i, str := range s {
		val := alpDivide - int((str - 'a'))
		sum += val * (i + 1)
	}

	return sum
}
