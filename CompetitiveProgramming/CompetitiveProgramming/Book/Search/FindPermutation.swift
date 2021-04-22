//
//  FindPermutation.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/02.
//

import Foundation

func findPermutation() {
  let perm = [0, 1, 2, 3, 4, 5]
  let n = perm.count
  var used = [Bool](repeating: false, count: n)
  findPermutationHelper(pos: 0, n: 4, perm: perm, used: &used)
}

func findPermutationHelper(pos: Int, n: Int, perm: [Int], used: inout [Bool]) {
  if pos == n {
    print(perm[pos])
    return
  }
  
  print(perm[pos], terminator: " , ")
  for i in 0..<n {
    if !used[i] {
      used[i] = true
      findPermutationHelper(pos: pos + 1, n: n, perm: perm, used: &used)
      used[i] = false
    }
  }
}
