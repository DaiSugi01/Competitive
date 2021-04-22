//
//  Napsack.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/03.
//

import Foundation

func napSack() {
  let n = 4
  let w = [2, 1, 3, 2]
  let v = [3, 2, 4, 2]
  let W = 5
  
  func napSackHelper(i: Int, j: Int) -> Int {
    var res: Int
    if i == n {
      res = 0
    } else if j < w[i] {
      res = napSackHelper(i: i + 1, j: j)
    } else {
      res = max(napSackHelper(i: i + 1, j: j), napSackHelper(i: i + 1, j: j - w[i]) + v[i])
    }
    
    return res
  }
  
  print(napSackHelper(i: 0, j: W))

}
