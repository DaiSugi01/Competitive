//
//  PracticeTravasal.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/21.
//

import Foundation

func traversal() {

  let N = Int(readLine()!)!
  var tree = [[Int]](repeating: [Int](repeating: 0, count: 2), count: 26)
  for _ in 0 ..< N {
    let input = readLine()!.split(separator: " ").map { String($0) }
    let parent = Int(Character(input[0]).asciiValue!) - 65
    let left = Int(Character(input[1]).asciiValue!)
    let right = Int(Character(input[2]).asciiValue!)
    tree[parent][0] = left == 46 ? -1 : left - 65
    tree[parent][1] = right == 46 ? -1 : right - 65
  }
  
  func preOrder(_ node: Int) {
    if node == -1 {
      return
    }
    
    print(Character(UnicodeScalar(node + 65)!), terminator: "")
    preOrder(tree[node][0])
    preOrder(tree[node][1])
  }
  
  func inOrder(_ node: Int) {
    if node == -1 {
      return
    }
    
    inOrder(tree[node][0])
    print(Character(UnicodeScalar(node + 65)!), terminator: "")
    inOrder(tree[node][1])
  }
  
  func postOrder(_ node: Int) {
    if node == -1 {
      return
    }
    
    postOrder(tree[node][0])
    postOrder(tree[node][1])
    print(Character(UnicodeScalar(node + 65)!), terminator: "")
  }

  preOrder(0)
  print()
  inOrder(0)
  print()
  postOrder(0)
  print()

}
