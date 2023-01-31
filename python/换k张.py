def solve():
    n = int(input())
    arr = list(map(int, input().split(' ')))
    arr.sort()
    dp = [1]
    for i in range(1, len(arr)):
        dp.append(dp[i-1])
        for j in range(i-1, -1, -1):
            if arr[i]-1 != arr[j] and arr[i] != arr[j]:
                dp[i] = max([dp[i], dp[j]+1])
                break
    return dp[n-1]



if __name__ == '__main__':
    print(solve())