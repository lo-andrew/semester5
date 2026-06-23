lst = [61, 42, 23, 8, 74, 10]

def isSorted(lst):
    for i in range(0, len(lst) - 1):
        if lst[i] > lst[i + 1]:
            return False
    return True

def bubbleSort(lst):
    for i in range(len(lst) - 1):
        for j in range(0, len(lst) - 1 - i):
            if lst[j] > lst[j + 1]:
                tmp = lst[j]
                lst[j] = lst[j + 1]
                lst[j + 1] = tmp


def selectionSort(lst):
    for i in range(len(lst)):
        minIdx = i
        for j in range(i + 1, len(lst)):
            if lst[j] < lst[minIdx]:
                minIdx = j
        if minIdx != i:
            lst[i], lst[minIdx] = lst[minIdx], lst[i]

#lst = [61, 42, 23, 8, 74, 10]


def insertionSort(lst):
    for i in range(len(lst)):
        curr = lst[i]
        j = i
        while j > 0 and lst[j - 1] > curr:
            lst[j] = lst[j - 1]
            j -= 1
        lst[j] = curr

def testSort(sortFn, lst):
    copy = lst[:]  # don't mutate the original
    print(f"Before {sortFn.__name__}: {copy}, isSorted: {isSorted(copy)}")
    sortFn(copy)
    print(f"After  {sortFn.__name__}: {copy}, isSorted: {isSorted(copy)}")
    print()
 
testSort(bubbleSort, lst)
testSort(selectionSort, lst)
testSort(insertionSort, lst)