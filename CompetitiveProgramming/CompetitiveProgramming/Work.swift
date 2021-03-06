//  MinimumCostFlow.swift
//  AlgorithmsDataStructures
//
//  Created by 杉原大貴 on 2021/04/13.
//

import Foundation

func deserialize<T>(_ arr: inout [T?]) -> BinaryNode<T>? {
  
  let newRoot = BinaryNode(value: arr[0])
  func convert(_ node: BinaryNode<T>?, _ cnt: Int) {
    guard let node = node else { return }
    
    newRoot.value = arr[cnt]
    convert(node.leftChild, cnt + 1)
    convert(node.rightChild, cnt + 1)
  }
  
  return nil
}

class BinaryNode<Element> {
  var value: Element
  var leftChild: BinaryNode?
  var rightChild: BinaryNode?
  init(value: Element) {
    self.value = value
  }
}

extension BinaryNode {
  func traversePreOrder(visit: (Element?) -> Void) {
    visit(value)
    if let leftChild = leftChild {
      leftChild.traversePreOrder(visit: visit)
    } else {
      visit(nil)
    }
    if let rightChild = rightChild {
      rightChild.traversePreOrder(visit: visit)
    } else {
      visit(nil)
    }
  }
  
  func traverseInOrder(visit: (Element?) -> Void) {
    if let leftChild = leftChild {
      leftChild.traverseInOrder(visit: visit)
    } else {
      visit(nil)
    }
    visit(value)
    if let rightChild = rightChild {
      rightChild.traverseInOrder(visit: visit)
    } else {
      visit(nil)
    }
  }
  
  func traversePostOrder(visit: (Element?) -> Void) {
    if let leftChild = leftChild {
      leftChild.traversePostOrder(visit: visit)
    } else {
      visit(nil)
    }
    if let rightChild = rightChild {
      rightChild.traversePostOrder(visit: visit)
    } else {
      visit(nil)
    }
    visit(value)
  }
}

extension BinaryNode: CustomStringConvertible {
  var description: String {
    return diagram(for: self)
  }
  
  private func diagram(for node: BinaryNode?,
                       _ top: String = "",
                       _ root: String  = "",
                       _ bottom: String = "") -> String {
    
    guard let node = node else {
      return root + "nil\n"
    }
    if node.leftChild == nil && node.rightChild == nil {
      // leaf node
      return root + "\(node.value)\n"
    }
    return diagram(for: node.rightChild,
                   top + " ",
                   top + "┌──",
                   top + "│ ") + root
      + "\(node.value)\n"
      + diagram(for: node.leftChild,
                bottom + "│ ",
                bottom + "└──",
                bottom + " ")
  }
}
