def get_width(x, n):
    if len(x) == 0:
        return n
    res = 0
    x.sort()
    for i in range(len(x)):
        if i == 0:
            res = max([res, x[i]])
        else:
            res = max([res, x[i]-x[i-1]])
    res = max([res, n-x[len(x)-1]])
    return res


def get_max(x, y, z, n):
    return get_width(x, n) * get_width(y, n) * get_width(z, n)


def solve():
    n, m = list(map(int, input().split(' ')))
    s1 = list(input().split(' '))
    s2 = list(map(int, input().split(' ')))
    x, y, z = [], [], []
    for i in range(m):
        ch = s1[i]
        num = s2[i]
        if ch == 'x':
            x.append(num)
        elif ch == 'y':
            y.append(num)
        else:
            z.append(num)
        print(get_max(x, y, z, n))


if __name__ == '__main__':
    solve()
