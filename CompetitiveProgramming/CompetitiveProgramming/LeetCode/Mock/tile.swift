//
//  tile.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

func numTilePossibilities(_ tiles: String) -> Int {
  
  var dic = [String: Int]()
  for c in tiles {
    dic[String(c), default: 0] += 1
  }
  
  let n = dic.keys.count
  var d = [[Int]](repeating: [Int](repeating: 1, count: n), count: tiles.count + 1)
//  for i in 0 ..< n {
//    d[1][i] = 1
//  }
  for (i, cnt) in dic.values.sorted().enumerated() {
    d[0][i] = cnt
  }

  print(d)
  for i in 2 ..< tiles.count {
    for j in 0 ..< n {
      d[i][j] = d[i - 1].reduce(0) { $0 + $1 }
      
      let diff = d[0][j] - i
      if diff < 0 {
        d[i][j] = d[i][j] - Int(pow(Double(diff), 2))
      }
    }
    print(i, d)
  }
  
  for i in d {
    print(i)
  }
  
  return d[tiles.count - 1][n - 1] + 1
}

// AAABBC

// A
// B
// C

// AA
// AB
// AC
// BA
// BB
// BC
// CA
// CB

// AAA
// AAB
// AAC
// ABA
// ABB
// ABC
// ACA
// ACB
// BAA
// BAB
// BAC
// BBA
// BBC
// BCA
// BCB
// CAA
// CAB
// CBA

// AAAB
// AAAC
// AABA
// AABB
// AABC
// AACA
// AACB
// ABAA
// ABAB
// ABAC
// ABBA

// CAAA
// CAAB
// CABA
// CABB
// CBAA
// CBAB
// CBBA
// CBCB

// CAAC
// CABC
// CACA
// CACB
// CBAC
// CBBC
// CBCA
// CCAA
// CCAB
// CCBA

// BAAA
// BAAB
// BAAC
// BABA
// BABC
// BBAA
// BBAC
// BBCA
// BCAA
// BCAB
// BCBA

// BBAA
// BBAA
