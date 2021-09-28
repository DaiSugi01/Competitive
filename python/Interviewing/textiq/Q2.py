import collections


def coolFeature(a, b, queries):
    count_a = dict(collections.Counter(a))
    count_b = dict(collections.Counter(b))

    res = []

    for q in queries:
        if q[0] == 1:
            total = 0
            for key in count_a:
                target = q[1] - key
                if target in count_b:
                    total += count_a[key] * count_b[target]
            if total > 0:
                res.append(total)

        if q[0] == 0:
            count_b[b[q[1]]] -= 1

            b[q[1]] = q[2]

            if q[2] in count_b:
                count_b[q[2]] += 1
            else:
                count_b[q[2]] = 1

    return res


# a = [1,2,3]
# b = [3,4]
# queries = [[1,5],[0,0,1],[1,5]]

a = [1, 2, 2]
b = [2, 3]
queries = [[1, 4], [0, 0, 3], [1, 5]]

print(coolFeature(a, b, queries))

