//
//  CanMakeTriangle.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/02.
//

import Foundation


/// check if I can make triangle by given matches
/// - Parameters:
///   - n: the number of matches
///   - a: the array of match length
func canMakeTriangle(n: Int, a: [Int]) {

  var i = a.count - 1
  var j = i - 1
  while j > 0 && a[i] >= a[j] + a[j - 1] {
    i -= 1
    j = i - 1
  }
  
  let answer = j > 0 ? a[i] + a[j] + a[j - 1] : 0
  print(answer)
}
