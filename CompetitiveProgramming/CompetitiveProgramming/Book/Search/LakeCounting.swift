//
//  KakeCounting.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/02.
//

import Foundation

/*
10 12
W . . . . . . . . W W .
. W W W . . . . . W W W
. . . . W W . . . W W .
. . . . . . . . . W W .
. . . . . . . . . . W .
. . W . . . . . . W . .
. W . W . . . . W W . .
W . W . W . . . . . W .
. W . W . . . . . . W .
. . W . . . . . . . W .
*/
func lakeCounting() {
  
  // get input
  let input = readLine()!.split(separator: " ").map { Int($0)! }
  let n = input[0]
  let m = input[1]
  var lakeMap = [[String]](repeating: [String](), count: n)

  for i in 0..<n {
    let row = readLine()!.split(separator: " ").map { String($0) }
    lakeMap[i].append(contentsOf: row)
  }
    
  let dx = [0, 1, 1, 1, 0, -1, -1, -1]
  let dy = [-1, -1, 0, 1, 1, 1, 0, -1]
  
  func dfs(x: Int, y: Int, visited: inout [[Bool]], lakeMap: [[String]]) {
    
    for i in 0..<8 {
      let nx = x + dx[i]
      let ny = y + dy[i]
      
      // check the bounds
      if nx < 0 || nx >= n || ny < 0 || ny >= m {
        continue
      }
      
      if lakeMap[nx][ny] == "W" && !visited[nx][ny] {
        visited[nx][ny] = true
        dfs(x: nx, y: ny, visited: &visited, lakeMap: lakeMap)
      }
    }
    

  }

  var visited = [[Bool]](repeating: [Bool](repeating: false, count: m), count: n)
  var count = 0
  for x in 0..<n {
    for y in 0..<m {
      if !visited[x][y] && lakeMap[x][y] == "W" {
        visited[x][y] = true
        dfs(x: x, y: y, visited: &visited, lakeMap: lakeMap)
        count += 1
      }
    }
  }
  print(count)
}
