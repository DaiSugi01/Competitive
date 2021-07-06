# https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def checkBST(root):
    def check(node: node, min: int, max: int) -> bool:
        if node is None:
            return True

        if node.data <= min or node.data >= max:
            return False

        return check(node.left, min, node.data) and check(node.right, node.data, max)

    return check(root, 0, 100000)


if __name__ == '__main__':
    n = node(4)
    n.left = node(2)
    n.left.left = node(1)
    n.left.right = node(3)

    n.right = node(6)
    n.right.left = node(5)
    n.right.right = node(7)

    print(checkBST(n))
