import bisect

def slove():
    s1 = list(map(int, input().split(' ')))
    s2 = list(map(int, input().split(' ')))
    s2.sort()
    n, x, y = s1
    if n < 2*x or n > 2*y:
        print(-1)
        return
    for i in range(x-1, y):
        num = s2[i]
        index = bisect.bisect(s2, num)
        if x <= n-index <= y:
            print(num)
            return
    print(-1)
    return


if __name__ == '__main__':
    slove()


