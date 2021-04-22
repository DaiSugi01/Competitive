//
//  WhoIsMyParent.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/08.
//

import Foundation

func whoIsMyParent() {
  let N = Int(readLine()!)!
  var adj = [[Int]](repeating: [Int](), count: N + 1)
  let parent = [Int](repeating: 0, count: N + 1)
  
  for _ in 0 ..< N - 1 {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let u = input[0]
    let v = input[1]
    adj[u].append(v)
    adj[v].append(u)
  }
  

  
  
}
