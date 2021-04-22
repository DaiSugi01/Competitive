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
/// Find: N
struct QuickUnionUF {
  private var parent: [Int]
  private(set) var count: Int
  
  init(_ n: Int) {
    self.count = n
    self.parent = [Int](repeating: 0, count: n)
    for i in 0 ..< n {
      self.parent[i] = i
    }
  }
  
  public func findRoot(of i: Int) -> Int {
    var i = i
    while parent[i] != i {
      i = parent[i]
    }
    return i
  }
  
  public func isConnected(p: Int,  and q: Int) -> Bool {
    
    return findRoot(of: p) == findRoot(of: q)
  }
    
  public mutating func union(_ p: Int, _ q: Int) {
    let parentP = findRoot(of: p)
    let parentQ = findRoot(of: q)
    parent[parentP] = parentQ
    
    print(parent)
  }
}
