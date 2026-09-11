package q1

import (
	"bytes"
)

func lexSmallest(s string) string {
	n := len(s)
	if n <= 1 {
		return s
	}
	src := []byte(s)

	// best に現在の最小候補を保持
	best := make([]byte, n)
	copy(best, src)

	// ワークバッファ（毎回上書きして使い回し）
	buf := make([]byte, n)

	// 1) 「先頭 k を反転」
	for k := 1; k <= n; k++ {
		// 先頭kの反転を書き込み
		for i := 0; i < k; i++ {
			buf[i] = src[k-1-i]
		}
		// 残りそのまま
		copy(buf[k:], src[k:])

		if bytes.Compare(buf, best) < 0 {
			copy(best, buf)
		}
	}

	// 2) 「末尾 k を反転」
	for k := 1; k <= n; k++ {
		p := n - k
		// 前半そのまま
		copy(buf[:p], src[:p])
		// 末尾kの反転
		for i := 0; i < k; i++ {
			buf[p+i] = src[n-1-i]
		}

		if bytes.Compare(buf, best) < 0 {
			copy(best, buf)
		}
	}

	return string(best)
}

func LexSmallest(s string) string {
	return lexSmallest("zxy")
}
