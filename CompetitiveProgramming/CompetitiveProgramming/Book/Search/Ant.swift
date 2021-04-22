//
//  Ant.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/02.
//

import Foundation


/// Ant
/// - Parameters:
///   - L: the length of match
///   - n: the number of ant
///   - x: the array representing the position of ants
func ant(L: Int, n: Int, x: [Int]) {
  var maxDis = 0
  for i in 0..<x.count {
    maxDis = max(maxDis, max(x[i], L - x[i]))
  }
  
  var minDis = 0
  for i in 0..<x.count {
    minDis = max(minDis, min(x[i], L - x[i]))
  }
  
  print(maxDis)
  print(minDis)
}
