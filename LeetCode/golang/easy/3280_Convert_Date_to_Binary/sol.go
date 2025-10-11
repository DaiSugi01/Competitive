package _280_Convert_Date_to_Binary

import (
	"strconv"
	"strings"
)

func convertDateToBinary(date string) string {
	dateArr := strings.Split(date, "-")
	for i := 0; i < len(dateArr); i++ {
		n, _ := strconv.Atoi(dateArr[i])
		dateArr[i] = strconv.FormatInt(int64(n), 2)
	}

	return strings.Join(dateArr, "-")
}
