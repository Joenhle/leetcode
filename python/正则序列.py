def solve():
    n = int(input())
    arr = list(map(int, input().split(' ')))
    arr.sort()
    res = sum([abs(i+1-v) for i, v in enumerate(arr)])
    return res


if __name__ == "__main__":
    print(solve())


