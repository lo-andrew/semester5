def linear_search(lst, val):
    for i in range(0, len(lst)):
        if lst[i] == val:
            return i
    return None

def binary_search(lst, val):
    low = 0
    high = len(lst) - 1

    while low <= high:
        mid = (high + low) // 2

        if lst[mid] < val:
            low = mid + 1
        elif lst[mid] > val:
            high = mid - 1
        else:
            return mid
    
    return None

def first_occurence(lst, val):
    left = 0
    right = len(lst) - 1
    result = None

    while left <= right:
        mid = (high + low) // 2

        if lst[mid] < val:
            low = mid + 1
        elif lst[mid] > val:
            high = mid - 1
        else:
            result = mid
            high = mid - 1
    
    return result


def last_occurrence(lst, val):
    left = 0
    right = len(lst) - 1
    result = None

    while left <= right:
        mid = (high + low) // 2

        if lst[mid] < val:
            low = mid + 1
        elif lst[mid] > val:
            high = mid - 1
        else:
            result = mid
            low = mid + 1
    
    return result

def find_missing(lst):
    lst.sort()