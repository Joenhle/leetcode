def get_dp1(arr):
    n = len(arr)
    dp = [[0 for i in range(n)] for j in range(n)]
    for i in range(n):
        dp[i][i] = arr[i]
        res = arr[i]
        for j in range(i + 1, n):
            dp[i][j] = dp[i][j - 1]
            res += arr[j]
            if res > dp[i][j]:
                dp[i][j] = res
    return dp


def get_dp2(arr):
    n = len(arr)
    dp = [[0 for i in range(n)] for j in range(n)]
    for i in range(n-1, -1, -1):
        dp[i][i] = arr[i]
        res = arr[i]
        for j in range(i-1, -1, -1):
            dp[j][i] = dp[j+1][i]
            res += arr[j]
            if res > dp[j][i]:
                dp[j][i] = res
    return dp


def get_dp3(arr):
    n = len(arr)
    dp = [[0 for i in range(n)] for j in range(n)]
    for i in range(0, n):
        res = 0
        for j in range(i, n):
            res += arr[j]
            dp[i][j] = res
    return dp


def solve():
    n = int(input())
    arr = list(map(int, input().split(' ')))
    dp1 = get_dp1(arr)
    dp2 = get_dp2(arr)
    dp3 = get_dp3(arr)

    res = None
    for i in range(n):
        for j in range(i, n):
            if i-1 >= 0:
                x = dp2[0][i-1] + dp2[i][j]
                if res is None:
                    res = x
                else:
                    if x > res:
                        res = x
            if n-1 >= j+1:
                y = dp1[i][j] + dp1[j+1][n-1]
                if res is None:
                    res = y
                else:
                    if y > res:
                        res = y
            if n-1 >= j+1 and i-1 >= 0:
                z = dp2[0][i-1] + dp3[i][j] + dp1[j+1][n-1]
                if res is None:
                    res = z
                else:
                    if z > res:
                        res = z

    return res


if __name__ == '__main__':
    print(solve())