//
//  207.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/21.
//

import Foundation

// LeetCode: https://leetcode.com/problems/course-schedule/
func canFinish(_ numCourses: Int, _ prerequisites: [[Int]]) -> Bool {

  var adj  = [[Int]](repeating: [Int](), count: numCourses)
  var indegree = [Int](repeating: 0, count: numCourses)
  
  for req in prerequisites {
    let u = req[0]
    let v = req[1]
    indegree[v] += 1
    adj[u].append(v)
  }
  
  let q = Queue<Int>()
  for i in 0 ..< numCourses {
    if indegree[i] == 0 {
      q.enqueue(item: i)
    }
  }
  
  while !q.isEmpty() {
    let u = q.dequeue()!
    for v in adj[u] {
      indegree[v] -= 1
      if indegree[v] == 0 {
        q.enqueue(item: v)
      }
    }
  }
  
  return indegree.reduce(0) { $0 + $1 } == 0
}
