//
//  FenceRepair.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/02.
//

import Foundation

func fenceRepair() {
  var n = 5
//  var l = [8, 5, 8]
  var l = [3, 4, 5, 1, 2]
  var ans = 0
  
  while n > 1 {
    var mii1 = 0, mii2 = 1
    if l[mii1] > l[mii2] {
      let temp = mii1
      mii1 = mii2
      mii2 = temp
    }
    
    for i in 2..<n {
      if l[i] < l[mii1] {
        mii2 = mii1
        mii1 = i
      } else if l[i] < l[mii2] {
        mii2 = i
      }
    }
    
    let t = l[mii1] + l[mii2]
    ans += t
    
    if mii1 == n - 1 {
      let temp = mii1
      mii1 = mii2
      mii2 = temp
    }
    l[mii1] = t
    l[mii2] = l[n - 1]
    n -= 1
  }
  
  print(ans)
}

