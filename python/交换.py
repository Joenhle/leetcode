def sort(a, b):
    i = 0
    while i < len(a):
        if a[i] > b[0]:
            a[i], b[0] = b[0], a[i]
        i += 1
    return a, b

if __name__ == '__main__':
    a = [1, 3, 5, 7]
    b = [2, 4, 6, 8]
    sort(a, b)
    print(sort(a, b))
