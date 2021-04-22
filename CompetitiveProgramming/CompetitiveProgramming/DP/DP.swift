//
//  DP.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/17.
//

import Foundation

var dp = [Int](repeating: 0, count: 11)
func fibonatch(_ n: Int) -> Int {
  print(dp)
  if n <= 1 {
    dp[n] = n
    return n
  }

  if dp[n] > 0 {
    return dp[n]
  }
  
  dp[n] = fibonatch(n - 1) + fibonatch(n - 2)
  return dp[n]
}
