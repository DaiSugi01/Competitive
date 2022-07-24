import copy


def combination(elem):
    '''組合せ'''
    for i, v in enumerate(elem):
        for v2 in elem[i+1:]:
            print(v, v2)

def permutation(slot,elem, size):
    '''順列'''
    if len(elem) == 1:
        slot[size - 1] = elem[0]
        print(slot)
    else:
        for i,v in enumerate(elem):
            slot[size - len(elem)] = v
            e2 = copy.copy(elem)
            e2.remove(v)
            permutation(slot, e2, size)
    return


if  __name__ == '__main__':
    elem = range(4)
    slot = [-1 for x in elem]

    combination(elem)
    permutation(slot, elem, len(elem))