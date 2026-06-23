def is_palindrome(word):
    return palindrome_check(word, 0, len(word) - 1)

def palindrome_check(word, start, end):
    if start >= end:
        return True
    elif word[start] == word[end]:
        return palindrome_check(word, start + 1, end - 1)
    else:
        return False
    

# [1, 2, 4, 5, 6, 3, 7, 8]

def restore_result(lst):
    incorrect = -1
    for i in range(1, len(lst)):
        if lst[i] < lst[i - 1]:
            incorrect = lst[i]
            lst.pop(i)
            break

    if incorrect == -1:
        return lst
    
    for j in range(1, len(lst)):
        if lst[j - 1] <= incorrect <= lst[j]:
            lst.insert(j, incorrect)



def restore_result2(lst):
    incorrect = None
    for i in range(1, len(lst)):
        if lst[i] < lst[i - 1]:
            incorrect = lst[i]
            lst.pop(i)
            break

    if incorrect == None:
        return lst

    if incorrect <= lst[0]:
        lst.insert(0, incorrect)
        return lst

    for j in range(1, len(lst)):
        if lst[j - 1] <= incorrect <= lst[j]:
            lst.insert(j, incorrect)
            return lst

    lst.append(incorrect)
    return lst



# [3, 4, 8, 1, 5, 2] becomes [5, 2, 4, 3, 1, 8]

def dsa456Sort(lst):
    even = []
    odd = []
    result = [0] * len(lst)
    for i in range(len(lst)):
        if lst[i] % 2 == 0:
            even.append(lst[i])
        else:
            odd.append(lst[i])
    insertion_sort(even)
    insertion_sort(odd)
    odd.reverse()

    even_idx = 0
    odd_idx = 0
    for j in range(len(lst)):
        if lst[j] % 2 == 0:
            result[j] = even[even_idx]
            even_idx += 1
        else:
            result[j] = odd[odd_idx]
            odd_idx += 1
    return result

def insertion_sort(lst):
    for i in range(len(lst)):
        curr = lst[i]
        j = i
        while j > 0 and lst[j - 1] > curr:
            lst[j] = lst[j - 1]
            j -= 1
        lst[j] = curr
    return lst


#[4, 3, 5, 6, 5, 4, 4]
#[4, 4, 4, 5, 5, 6, 3]

def frequency_sort(lst):
    selection_sort(lst)
    result = []
    count = []
    values = []
    counter = 1
    for i in range(len(lst) - 1):
        if lst[i] == lst[i + 1]:
            counter += 1
        else:
            values.append(lst[i])
            count.append(counter)
            counter = 1
    values.append(lst[-1])
    count.append(counter)

    indices = []
    idx = 0
    for j in range(len(count)):
        indices.append(idx)
        idx += 1
    
    for i in range(len(indices) - 1):
        best_idx = i
        for j in range(i + 1, len(indices)):
            if count[indices[j]] > count[indices[best_idx]]:
                best_idx = j
            elif count[indices[j]] == count[indices[best_idx]]:
                if values[indices[j]] > values[indices[best_idx]]:
                    best_idx = j
        indices[i], indices[best_idx] = indices[best_idx], indices[i]


    for x in range(len(count)):
        y = 0
        while y < count[indices[x]]:
            result.append(values[indices[x]])
            y += 1         
    return result  



def selection_sort(lst):
    for i in range(len(lst)):
        minidx= i
        for j in range(i + 1, len(lst)):
            if lst[j] < lst[minidx]:
                minidx = j
        if minidx != i:
            lst[i], lst[minidx] = lst[minidx], lst[i]

def test_frequency_sort():
    tests = [
        ([4,3,5,6,5,4,3,4,4,5], [4,4,4,4,5,5,5,3,3,6]),
        ([4,5,6,5,4,3],          [5,5,4,4,6,3]),
        ([4,6,5,4,3],            [4,4,6,5,3]),
    ]

    for lst, expected in tests:
        result = frequency_sort(lst[:])  # copy so original isn't mutated
        if result == expected:
            print(f"PASS: {lst} → {result}")
        else:
            print(f"FAIL: {lst}")
            print(f"  expected: {expected}")
            print(f"  got:      {result}")

test_frequency_sort()