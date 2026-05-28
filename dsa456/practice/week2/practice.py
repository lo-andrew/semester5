def increment(x):
    y = x + 1   # =, + : 2
    return y    # return : 1

## T(n) = 3
## O(1)

def sum_to_n_iterative(n):
    total = 0                       # 1
    for i in range(1, n + 1):       # n + 1 + 1
        total += i                  # n 
    return total                    # 1

# T(n) = 2n + 4
# O(n)

def sum_to_n_formula(n):
    return n * (n + 1) // 2      # 4 (return, *, +, //)

#T(n) = 4
#O(1) 

def find_max(arr):
    max_val = arr[0]        # 1
    for x in arr:           # n
        if x > max_val:     # n
            max_val = x     # n-1
    return max_val          # 1

# T(n) = 3n + 1
# O(n)

def linear_search(arr, target):
    for i in range(len(arr)):       # n + 1 + 1
        if arr[i] == target:        # 1 + n ??
            return i                # 1
    return -1                       # 

# T(n) = 2n + 4
# O(n) 

def count_occurrences(arr, target):
    count = 0                   # 1
    for x in arr:               # n
        if x == target:         # n    
            count += 1          # n
    return count                # 1

# T(n) = 3n + 2
# O(n)


def reverse(arr):
    left = 0                    # 1
    right = len(arr) - 1        # 1 + 1 + 1
    while left < right:         # n // 2
        temp = arr[left]        # 1
        arr[left] = arr[right]  # 1
        arr[right] = temp       # 1
        left = left + 1         # 2
        right = right - 1       # 2

# T(n) = 3 + (7 * n/2)
# O(n)

def factorial(n):
    result = 1                  # 1
    for i in range(2, n + 1):   # n - 1 + 1 + 1
        result = result * i     # 2(n - 1)
    return result               # 1

# T(n) = 1 + n - 1 + 1 + 1 + 2(n - 1) + 1
# T(n) = 3n + 2 - 3
# T(n) = 3n - 1
# O(n)


def binary_search(arr, value):
    left = 0                            # 1
    right = len(arr) - 1                # 3
    while left <= right:                # (n/2) + 1
        mid = (left + right) // 2       # (1 + 1 + 1)(n/2)
        if arr[mid] == value:           
            return mid
        elif arr[mid] < value:          # 1(n/2)
            left = mid + 1              # 2(n/2)
        else:
            right = mid - 1
    return -1

# T(n) = 1 + 3 + (n/2) + 1 + (1 + 1 + 1)(n/2) + n/1 + 2n + 4
# T(n) = 
# O(n)


def insertion_sort(arr):
    for i in range(1, len(arr)):        # n + 1 + 1   
        key = arr[i]                    # 1
        j = i - 1                       # 2
        while j >= 0 and arr[j] > key:  # n(n-1) + 2
            arr[j + 1] = arr[j]         # 2
            j -= 1                      # 1    
        arr[j + 1] = key                # 2

# T(n) = n + 2 + 3 + n(n - 1) + 2 + 5
# T(n) = n + 12 + n^2 - n
# T(n) = n^2 + 12
# O(n^2)

def merge_sorted(a, b):
    i = 0                               # 1
    j = 0                               # 1
    result = []                         # 1 
    while i < len(a) and j < len(b):    # 2n
        if a[i] <= b[j]:                # 2n
            result.append(a[i])         # 2n
            i += 1                      # 2n
        else:                           #
            result.append(b[j])         # 2n
            j += 1                      # 2n
    while i < len(a):                   # 1
        result.append(a[i])             # 1
        i = i + 1                       # 1
    while j < len(b):                   #
        result.append(b[j])             #
        j = j + 1                       #
    return result                       # 1

# worst case, it crawls up both arrays at the same time
# then at the final one, it goes through either i < len(a) or j < len(b)
# once.


def fib_iter(n):
    a = 0               # 1
    b = 1               # 1
    for i in range(n):  # n + 1
        tmp = a + b     # 2n
        a = b           # 1n
        b = tmp         # 1n
    return a            # 1

# T(n) = 5n + 4
# O(n)

def matrix_multiplication(A, B):
    n = len(A)                                  # 2
    C = [[0]*n for _ in range(n)]               # n + 2
    for i in range(n):                          # n + 1
        for j in range(n):                      # (n + 1) (n + 1)
            for k in range(n):                  # (n + 1)(n + 1)(n + 1)
                C[i][j] += A[i][k] * B[k][j]    # 2(n + 1)(n + 1)(n + 1)
    return C                                    # 1   

# T(n) = 
# O(n^3)


def count_digits(n):
    count = 0       # 1
    while n > 0:    # depends on how big number is, by factor of 10.
        n //= 10    # 1   
        count += 1  # 1
    return count    # 1

# Start:      n
# After 1st:  n/10
# After 2nd:  n/100
# After 3rd:  n/1000
# ...
# After k:    n/10^k
# n/10^k = 1
# 10^k = n
# k = log10(n)


def reverse_digits(n):
    rev = 0                         # 1
    while n > 0:                    # log10(n)
        rev = rev * 10 + n % 10     # 4(log10(n))
        n //= 10                    # 1(log10(n))
    return rev                      # 1

# T(n) = 6log10(n) + 2
# O(log10(n))

def is_palindrome(s):
    left = 0;                       # 1
    right = len(s) - 1              # 3
    while left < right:             # n / 2
        if s[left] != s[right]:     # 1
            return False            #
        left += 1                   # 1(n / 2)
        right -= 1                  # 1(n / 2)
    return True                     # 1

# T(n) = 4 + n / 2 + 1 + n / 2 + n / 2 + 1
# T(n) = 3n/2 + 6
# O(n)