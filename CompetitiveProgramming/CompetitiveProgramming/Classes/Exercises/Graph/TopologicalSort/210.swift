//
//  210.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/21.
//

import Foundation

// LeetCode: https://leetcode.com/problems/course-schedule-ii/
func findOrder(_ numCourses: Int, _ prerequisites: [[Int]]) -> [Int] {
  var res = [Int]()
  var adj = [[Int]](repeating: [Int](), count: numCourses)
  var indegree = [Int](repeating: 0, count: numCourses)
  
  for preReq in prerequisites {
    let u = preReq[0]
    let v = preReq[1]
    adj[v].append(u)
    indegree[u] += 1
  }
  
  let q = Queue<Int>()
  for i in 0 ..< numCourses {
    if indegree[i] == 0 {
      q.enqueue(item: i)
      res.append(i)
    }
  }
  
  while !q.isEmpty() {
    let u = q.dequeue()!
    for v in adj[u] {
      indegree[v] -= 1
      if indegree[v] == 0 {
        q.enqueue(item: v)
        res.append(v)
      }
    }
  }

  return indegree.reduce(0) { $0 + $1 } == 0 ? res: []
}
