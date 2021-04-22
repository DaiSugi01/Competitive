//
//  BestCowLine.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/02.
//

import Foundation

func bestCowLine() {
  let n = 6
  let s = "ACDBCB"
  let ans = NSMutableString()
  
  var pl = 0
  var pr = n - 1
  while pl <= pr {
    var isLeftSmall = false

    for i in 0...pr {
      let leftChar = getChar(s: s, index: i + pl)
      let rightChar = getChar(s: s, index: pr - i)
      
      if leftChar < rightChar {
        isLeftSmall = true
        break
      } else if leftChar > rightChar {
        isLeftSmall = false
        break
      }
    }
    
    if isLeftSmall {
      ans.append(getChar(s: s, index: pl))
      pl += 1
    } else {
      ans.append(getChar(s: s, index: pr))
      pr -= 1
    }
  }
  
  print(ans)
}

private func getChar(s: String, index: Int) -> String {
  return String(s[s.index(s.startIndex, offsetBy: index)])
}
