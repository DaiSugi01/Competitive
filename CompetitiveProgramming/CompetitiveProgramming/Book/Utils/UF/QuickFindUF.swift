//
//  UF.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/07.
//

import Foundation


/// Time Complexity
/// Initialize: N
/// Union: N
/// Find: 1
struct QuickFindUF {
  private var parent: [Int]
  private(set) var count: Int
  
  init(_ n: Int) {
    self.count = n
    self.parent = [Int](repeating: 0, count: n)
    for i in 0 ..< n {
      self.parent[i] = i
    }
  }
  
  public func isConnected(p: Int,  and q: Int) -> Bool {
    
    return parent[p] == parent[q]
  }
    
  public mutating func union(_ p: Int, _ q: Int) {
    let parentP = parent[p]
    let parentQ = parent[q]
    
    for i in 0 ..< parent.count {
      if parent[i] == parentP { parent[i] = parentQ }
    }
    print(parent)
  }
}
