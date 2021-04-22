//
//  Maze.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/02.
//

import Foundation

/*
10 10
# S # # # # # # . #
. . . . . . # . . #
. # . # # . # # . #
. # . . . . . . . .
# # . # # . # # # #
. . . . # . . . . #
. # # # # # # # . #
. . . . # . . . . .
. # # # # . # # # .
. . . . # . . . G #
*/
func Maze() {
  
  struct Square {
    let x: Int
    let y: Int
  }
  
  // get input
  let input = readLine()!.split(separator: " ").map { Int($0)! }
  let n = input[0]
  let m = input[1]
  var mazeMap = [[String]](repeating: [String](), count: n)
  
  var sx = 0
  var sy = 0
  var gx = 0
  var gy = 0
  
  for i in 0..<n {
    let row = readLine()!.split(separator: " ").map { String($0) }
    if row.contains("S") {
      sx = i
      sy = row.firstIndex(of: "S")!
    } else if row.contains("G") {
      gx = i
      gy = row.firstIndex(of: "G")!
    }
    
    mazeMap[i].append(contentsOf: row)
  }

  var d = [[Int]](repeating: [Int](repeating: 0, count: m), count: n)
  var visited = [[Bool]](repeating: [Bool](repeating: false, count: m), count: n)
  
  let dx = [0, 1, 0, -1]
  let dy = [-1, 0, 1, 0]
  
  func bfs(square: Square) {
    let q = Queue<Square>()
    q.enqueue(item: square)
    
    while !q.isEmpty() {
      let sq = q.dequeue()!
      let x = sq.x
      let y = sq.y
      
      if mazeMap[x][y] == "G" { break }
      
      for i in 0..<4 {
        let nx = x + dx[i]
        let ny = y + dy[i]
        
        if nx < 0 || nx >= n || ny < 0 || ny >= m {
          continue
        }
        
        if mazeMap[nx][ny] != "#" && !visited[nx][ny] {
          visited[nx][ny] = true
          q.enqueue(item: Square(x: nx, y: ny))
          d[nx][ny] = d[x][y] + 1
        }
      }
    }
  }

  visited[sx][sy] = true
  bfs(square: Square(x: sx, y: sy))
  
  print(d[gx][gy])
}
