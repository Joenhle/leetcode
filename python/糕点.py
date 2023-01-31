if __name__ == '__main__':
    str = input()
    while str != '':
        arr = [int(x) for x in str.split(' ')]
        temp = [int(x) for x in input().split(' ')]
        a, b = max([arr[2], arr[3]]), min([arr[2], arr[3]])
        left = arr[0] - arr[1]
        max_num = max(temp)
        min_num = min(temp)
        if max_num == a and min_num == b:
            print("YES")
        elif a > max_num and b < min_num and left >= 2:
            print("YES")
        elif ((a == max_num and b < min_num) or (b == min_num and a > max_num)) and left >= 1:
            print("YES")
        else:
            print("NO")
        try:
            str = input()
        except EOFError:
            str = ''