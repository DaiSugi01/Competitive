//
//  Scheduling.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/02.
//

import Foundation

func scheduling() {
  let n = 5
  let s = [1, 2, 4, 6, 8]
  let t = [3, 5, 7, 9, 10]
  
  var minIndex = t.firstIndex(of: t.min()!)!
  var count = 1
  
  for i in minIndex+1..<n {
    if s[i] > t[minIndex] {
      minIndex = i
      count += 1
    }
  }
  
  print(count)

}
