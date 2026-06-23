lst = [61, 42, 23, 8, 74, 10]

def isSorted(lst):
    for i in range(0, len(lst) - 1):
        if lst[i] > lst[i + 1]:
            return False
    return True

def testSort(sortFn, lst):
    copy = lst[:]  # don't mutate the original
    print(f"Before {sortFn.__name__}: {copy}, isSorted: {isSorted(copy)}")
    sortFn(copy)
    print(f"After  {sortFn.__name__}: {copy}, isSorted: {isSorted(copy)}")
    print()


