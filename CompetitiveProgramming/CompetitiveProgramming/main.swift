//
//  main.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/02.
//

import Foundation

//findPermutation()
//coin()
//scheduling()
//bestCowLine()
//fenceRepair()
//napSack()

//print(findCircleNum([[1,0,0],[0,1,0],[0,0,1]]))

//var uf = UF(10)
//uf.union(4, 3)
//uf.union(3, 8)
//uf.union(6, 5)
//uf.union(9, 4)
//uf.union(2, 1)
//uf.union(5, 0)
//uf.union(7, 2)
//uf.union(6, 1)
//uf.union(7, 3)

//whoIsMyParent()
//print(leastInterval(["A","A","A","B","B","B"], 2))
//print(leastInterval(["A","A","A","A","B","B","B","B","C","C","C","C","D","D","D","D","E","F"], 4))
//print(leastInterval(["A","A","A","B","B","B", "C","C","C", "D", "D", "E"], 2))
//print(leastInterval(["A","B","A","B"], 2))
//print(leastInterval(["A","A","A","A","A","A","B","C","D","E","F","G"], 2))
//print(leastInterval(["A","A","A","B","B","B","C","C","C","D","D","E"], 2)) // -> 12

//print(canCompleteCircuit([1,2,3,4,5], [3,4,5,1,2])) // -> 3
//print(canCompleteCircuit([2,3,4], [3,4,3])) // -> -1
//print(canCompleteCircuit([3,3,4], [3,4,4])) // -> -1
//print(canCompleteCircuit([5,1,2,3,4], [4,4,1,5,1])) // -> 4
//print(canCompleteCircuit([4,5,2,6,5,3], [3,2,7,3,2,9])) // -> -1
//print(canCompleteCircuit([5,8,2,8], [6,5,6,6])) // -> -3
//print(canCompleteCircuit([5,5,1,3,4], [8,1,7,1,1])) // -> -3

//canCompleteCircuit([1,2,3,4,5], [3,4,5,1,2]) // -> 3
//canCompleteCircuit([2,3,4], [3,4,3]) // -> -1
//canCompleteCircuit([3,3,4], [3,4,4]) // -> -1
//canCompleteCircuit([5,1,2,3,4], [4,4,1,5,1]) // -> 4



//print(partitionLabels("ababcbacadefegdehijhklij")) //->
//print(partitionLabels("eccbbbbdec"))


//(n + 1) * (3 - 1) + 3
//
//["A","A","A","B","B","B","C","C","C","D","D","E"], 2)) // -> 12
//[A, B, i, A, B, i, A]

let fileManager = FileManager.default
let filePath = "/Users/DKS/projects/Cornerstone/4_Swift/401/AlgorithmsDataStructures/AlgorithmsDataStructures/Assignments/testcase/mcf"
let contents = try! fileManager.contentsOfDirectory(atPath: filePath)
//for file in contents.sorted() {
//  if !file.contains(".in") { continue }
//  minimumCostFlow(testMode: true, filePath: "\(filePath)/\(file)")
//}
//minimumCostFlow()

//print(networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], 4, 2))
//print(networkDelayTime([[1,2,1],[2,1,3]], 2, 2))
//print(networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], 4, 2))
//print(networkDelayTime([[1,2,1],[2,3,2],[1,3,4]], 3, 1))
//print(networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], 4, 2))

//print(findCheapestPrice(3, [[0,1,100],[1,2,100],[0,2,500]], 0, 2, 1))

//print(findTheCity(4, [[0,1,3],[1,2,1],[1,3,4],[2,3,1]] ,4))
//print(findTheCity(39, [[32,33,6066],[9,24,4482],[12,23,1781],[6,25,1897],[7,15,8633],[12,16,2890],[1,30,349],[30,31,9738],[11,33,9791],[12,34,2418],[18,21,4112],[25,29,7258],[1,3,4596],[1,8,2224],[8,17,9142],[13,23,6498],[29,38,9590],[6,28,6956],[4,31,9774],[2,30,3967],[6,19,8528],[11,13,3068],[2,36,2987],[29,37,5395],[14,21,5175],[2,4,3214],[17,29,196],[9,20,4655],[19,36,9637],[15,25,1418],[6,33,5843],[22,27,2500],[13,34,2553],[0,16,1409],[20,30,795],[5,34,8623],[9,33,2352],[21,29,525],[11,30,1720],[14,17,7672],[2,34,8525],[3,29,6520],[26,29,847],[14,18,1323],[27,33,2360],[14,23,4009],[21,37,7194],[14,38,7686],[2,25,8244],[3,21,7009],[20,27,8794],[4,32,1865],[14,20,3548],[2,3,6502],[21,28,1577],[9,15,1030],[24,32,5566],[3,5,4979],[18,26,4109],[25,33,6545],[12,36,5506],[5,33,564],[13,22,691],[8,13,1955],[18,19,4031],[15,37,841],[7,27,318],[1,25,1626],[15,18,7242],[11,12,1446],[24,26,725],[5,24,7100],[7,37,9453],[20,26,2597],[2,10,6982],[19,25,1081],[1,35,7350],[4,37,8618],[4,17,3751],[16,38,1582],[8,15,2040],[18,36,3113],[2,11,4287],[13,28,3813],[0,32,4375],[3,33,5513],[19,26,244],[11,23,2454],[16,28,3209],[3,34,7579],[2,24,6368],[10,25,6483],[8,22,5691],[7,19,4154],[17,23,8757],[7,11,1931],[4,19,7856],[22,32,8456],[2,12,2615],[29,36,4506],[14,37,9937],[11,27,4164],[26,38,7275],[6,11,9853],[3,31,9498],[6,27,835],[6,35,9750],[14,28,2564],[8,21,2069],[3,38,6068],[0,25,2793],[4,23,5182],[15,36,6692],[18,25,8000],[12,31,8724],[15,27,146],[1,7,6611],[1,36,5780],[9,23,5532],[20,28,3097],[30,38,108],[15,17,7243],[6,36,2094],[32,34,6015],[11,26,5442],[16,17,1454],[18,35,5012],[28,38,73],[0,38,5039],[17,33,8088],[33,35,1675],[10,38,2895],[29,31,1275],[13,38,7541],[13,17,3776],[13,26,3980],[0,22,5068],[5,14,420],[11,38,3823],[24,37,6245],[7,18,745],[11,22,894],[14,19,7170],[0,15,7181],[10,18,5059],[0,20,2448],[8,33,9989],[28,30,5110],[6,20,8021],[5,15,4099],[3,37,1375],[8,29,2438],[5,27,3915],[16,37,1430],[10,30,5871],[8,9,4053],[23,24,2305],[23,30,1723],[11,35,43],[23,25,377],[11,28,949],[2,27,2637],[26,36,1856],[9,25,994],[7,8,9375],[19,24,9937],[6,23,1727],[3,10,6053],[22,28,9815],[12,24,1033],[17,30,1795],[2,23,9458],[0,34,4091],[21,34,8096],[1,18,1031],[20,34,944],[2,5,4024],[0,24,285],[11,20,8137],[22,24,4782],[0,17,8309],[15,28,3969],[15,21,2276],[31,34,5448],[10,34,6433],[1,31,1736],[10,16,8362],[16,22,4084],[2,6,7867],[7,32,1865],[2,16,3438],[11,16,1160],[8,32,3509],[6,9,1658],[5,19,2762],[0,5,4162],[19,30,2333],[3,16,3306],[25,27,3425],[22,23,8181],[9,18,3861],[16,34,7057],[14,34,9239],[9,16,1192],[16,32,8649],[23,28,2251],[10,37,9831],[4,36,1830],[0,28,4997],[35,36,1370],[21,38,1609],[4,18,2630],[5,20,8504],[10,22,1379],[26,35,9343],[16,18,2038],[10,23,491],[24,38,6111],[35,38,8084],[8,20,7034]] ,6586))

//test()

//print(minCostClimbingStairs([1,100,1,1,1,100,1,1,100,1]))
//print(minCostClimbingStairs([10,15,20]))
//print(findJudge(2, [[1,2]])) // -> 2
//print(findJudge(3, [[1,3],[2,3]])) // -> 3
//print(findJudge(3, [[1,3],[2,3],[3,1]])) // -> -1
//print(findJudge(3, [[1,2],[2,3]])) // -> -1
//print(findJudge(4, [[1,3],[1,4],[2,3],[2,4],[4,3]])) // -> 3
//print(findJudge(1, [])) // -> 1
//print(findJudge(2, [])) // -> -1

//traversal()
//connectedComponents()
//cyclicPermutation()
//town()
//maze()
//topologicalSortDAG()
//print(canFinish(2, [[1,0]]))
//print(findOrder(2, [[1,0]]))
//Dijkstra()
var t = TreeNode(1)
t.left = TreeNode(3)
t.left?.left = TreeNode(5)
t.right = TreeNode(2)
//print(binaryTreePaths(t))
//print(sumOfLeftLeaves(t))
//print(diameterOfBinaryTree(t))
//print(bstToGst(t))
//print(mergeTrees(t, t))

//print(numTilePossibilities("AAABBC"))



  let testTree1: BinaryNode<Int> = {
    let rootNode = BinaryNode<Int>(value: 1)
    let node1 = BinaryNode<Int>(value: 4)
    let node2 = BinaryNode<Int>(value: 5)
    let node3 = BinaryNode<Int>(value: 2)
    let node4 = BinaryNode<Int>(value: 6)
    let node5 = BinaryNode<Int>(value: 7)
    
    rootNode.leftChild = node1
    rootNode.rightChild = node2
    node1.leftChild = node3
    node2.leftChild = node4
    node2.rightChild = node5
    return rootNode
  }()
  
  let testArray1: [Int?] = [1, 4, 2, nil, nil, nil, 5, 6, nil, nil, 7, nil, nil]
  
  let testTree2: BinaryNode<Int> = {
    let rootNode = BinaryNode<Int>(value: 7)
    let node1 = BinaryNode<Int>(value: 1)
    let node2 = BinaryNode<Int>(value: 9)
    let node3 = BinaryNode<Int>(value: 0)
    let node4 = BinaryNode<Int>(value: 5)
    let node5 = BinaryNode<Int>(value: 8)
    
    rootNode.leftChild = node1
    rootNode.rightChild = node2
    node1.leftChild = node3
    node1.rightChild = node4
    node2.leftChild = node5
    node2.rightChild = nil
    return rootNode
  }()
  
  let testArray2: [Int?] = [7, 1, 0, nil, nil, 5, nil, nil, 9, 8, nil, nil, nil]
  
  func testDeserializeArray1() {
    var arr = Array(testArray1.reversed())
    print(arr)
    let deserializedArray = deserialize(&arr)
  }
  
  func testDeserializeArray2() {
    var arr = Array(testArray2.reversed())
    print(arr)
    let deserializedArray = deserialize(&arr)
  }
  



testDeserializeArray1()
testDeserializeArray2()
func test<T>(_ arr: inout [T?]) -> BinaryNode<T>? {

  var cnt = 0
  func convert() -> BinaryNode<T>? {
    guard let val = arr[cnt] else { return nil }
    
    let root = BinaryNode<T>(value: val)
    cnt += 1
    root.leftChild = convert()
    cnt += 1
    root.rightChild = convert()
    return root
  }

//  var root = BinaryNode(value: arr[0]!)
  let root = convert()
  print(arr)
  return root
}

var testArr = [7, 1, 0, nil, nil, 5, nil, nil, 9, 8, nil, nil, nil]
print(test(&testArr))

