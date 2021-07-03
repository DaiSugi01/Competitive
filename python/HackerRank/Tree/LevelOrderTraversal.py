# https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
import queue


class Node:
    def __init__(self, info):
        self.info = info
        self.left = None
        self.right = None
        self.level = None

    def __str__(self):
        return str(self.info)


class BinarySearchTree:
    def __init__(self):
        self.root = None

    def create(self, val):
        if self.root == None:
            self.root = Node(val)
        else:
            current = self.root

            while True:
                if val < current.info:
                    if current.left:
                        current = current.left
                    else:
                        current.left = Node(val)
                        break
                elif val > current.info:
                    if current.right:
                        current = current.right
                    else:
                        current.right = Node(val)
                        break
                else:
                    break


def level_order_traversal(root: BinarySearchTree):
    q = queue.Queue()
    q.put(root)

    while not q.empty():
        for _ in range(q.qsize()):
            node = q.get()
            print(node.val, end = " ")
            if node.left:
                q.put(node.left)
            if node.right:
                q.put(node.right)
