package _9_Sqrt

func mySqrt(x int) int {
	if x < 2 { // 0,1 はそのまま
		return x
	}
	lo, hi := 1, x/2+1 // √x は x/2+1 を越えない（x>=2）
	for lo <= hi {
		mid := lo + (hi-lo)/2
		// mid*mid <= x を安全に判定（オーバーフロー回避）
		if mid <= x/mid {
			lo = mid + 1
		} else {
			hi = mid - 1
		}
	}
	// ループ終了時、hi は最大の mid で mid*mid <= x
	return hi
}

func MySqrt() int {
	return mySqrt(20)
}
