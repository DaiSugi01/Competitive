//
//  997.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/21.
//

import Foundation

func findJudge(_ N: Int, _ trust: [[Int]]) -> Int {
  if trust.isEmpty {
    if N < 2 {
      return 1
    } else {
      return -1
    }
  }
  
  var indegree = [Int: Int]()
  
  for i in 0 ..< trust.count {
    let u = trust[i][0]
    let v = trust[i][1]
    indegree[v, default: 0] += 1
    indegree[u, default: 0] -= 1
  }
  
  for i in 1 ... N {
    if indegree[i] == N - 1 {
      return i
    }
  }
  
  return -1
}
