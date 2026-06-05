def array_sum(arr, n):
    if n == 0:      # 1
        return 0    # 0
    return arr[n - 1] + array_sum(arr, n - 1)  # 4 + (n - 1)

# T(n) = 1 + 4 + T(n - 1)
# T(n) = T(n - 1) + 5
# T(n) = T(n - k) + k x 5

# base case when n == 0
# 0 = n - k
# n = k


def factorial(n):
    if n <= 1:                      # 1
        return 1                    # 0
    return n * factorial(n - 1)     # 2 + T(n - 1)

# T(n) = 3 + T(n - 1)
# = 3 + 3 + T(n - 2)
# = T(n - 1) + 1 x 3
# = T(n - 2) + 2 x 3
# = T(n - 3) + 3 x 3
# T(n) = T(n - k) + k x 3

# base case == 1
# 1 = n - k
# k = n - 1

# T(n) = T(n - (n-1)) + (n-1) × 3 [distribute the negative]
# T(n) = T(1) + (n-1) × 3
# T(n) = 1 + 3n - 3
# T(n) = 3n - 2

# dominant factor = 3n
# T(n) = O(n)


def power(x, n):
    if n == 0:                  # 1
        return 1                # 0
    return x * power(x, n-1)    # 2 + T(n - 1)

# T(n) = 1 + 2 + T(n - 1)
# T(n) = T(n - 1) + 3
# T(n) = T(n - 2) + 3 + 3
# T(n) = T(n - 3) + 3 + 3 + 3
# T(n) = T(n - k) + k x 3

# base case T(0) = n - k
# 0 = n - k
# n = k

# T(n) = T(n - k) + k x 3
# T(n) = T(n - n) + n x 3
# T(n) = T(0) + 3n
# T(n) = 1 + 3n


def reverse_string(s):
    if len(s) == 0:                         # 2
        return s                            # 0
    return reverse_string(s[1:]) + s[0]     # T(n-1) + (n-1) + 1 [recursive call, slicing, +]

# T(n) = 2 + T(n-1) + (n-1) + 1
# T(n) = T(n-1) + n + 2

# T(n) = T(n-1) + n + 2
# T(n) = T(n-2) + (n-1) + 2 + n + 2
# T(n) = T(n-3) + (n-2) + 2 + (n-1) + 2 + n + 2
# T(n) = T(n-k) + [n + (n-1) + (n-2) + ... + (n-k+1)] + 2k

# setting k = n

# T(n) = T(0) + [n + (n-1) + (n-2) + ... + 1] + 2n
# T(n) = 2 + n(n-1)/2 + 2n
# T(n) = O(n^2)

def is_palindrome(s):
    if len(s) <= 1:                                     # 2
        return True                                     # 0 
    return s[0] == s[-1] and is_palindrome(s[1:-1])     # T(n - 2) + (n - 2) + 5
                                                            # 5 operations [==, -, and, -, return]

# T(n) = T(n - 2) + (n - 2) + 5 + 2
# T(n) = T(n - 2) + (n - 2) + 7
# T(n) = T(n - 4) + (n - 4) + 7 + (n - 2) + 7
# T(n) = T(n - k) + n(n-2k)/2 + 7k


def linear_search(arr, x, i = 0):
    if i == len(arr):                       # 2
        return -1                           # 0
    if arr[i] == x:                         # 1
        return i                            # 0
    return linear_search(arr, x, i + 1)     # T(n - 1) + 2

# T(n) = T(n - 1) + 5
# T(n) = T(n - 2) + 5 + 5
# T(n) = T(n - 3) + 5 + 5 + 5          
# T(n) = T(n - k) + 5k
# 
# base case when i == n   
# 
# T(n) = T(n - k)
# 0 = n - k
# n = k
#
# T(n) = T(n - n) + 5n
# T(n) = T(0) + 5n
# T(n) = 5n + 2
# T(n) = O(n)