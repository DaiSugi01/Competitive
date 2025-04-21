package _402_Minimum_Operations_to_Make_Columns_Strictly_Increasing

func minimumOperations(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	var totalOP int
	for col := 0; col < n; col++ {
		for row := 0; row < m-1; row++ {
			if grid[row][col] >= grid[row+1][col] {
				addedNum := grid[row][col] - grid[row+1][col] + 1
				totalOP += addedNum
				grid[row+1][col] += addedNum
			}
		}
	}

	return totalOP
}

func MinimumOperations(grid [][]int) int {
	return minimumOperations(grid)
}
