def fib_memo(n, memo={}):
    if n in memo:
        return memo[n]
    if n <= 1:
        return n
    memo[n] = fib_memo(n-1, memo) + fib_memo(n - 2, memo)
    return memo[n]

# case 1: n has already been calculated
#   T(n) = 1 + 1 = 2
#   T(n) = O(n)
# only line 2 and 3 run
#
#
# case 2: n = 1
#   T(n) = 1 +1 + 1
#   T(n) = 3
#   T(n) = O(n)
# line 6 and 7 don't run
#
# case 3: n > 1, not calculated yet
#   T(n) = 1 + 1 + 4 operations
#       memo[n] insertion has constant complexity
#   T(n) = 1 + 1 + 4 + T(n - 1) + 1
# fib_memo(n - 2, memo) has constant complexity. we already calculated n-2 inside n-1 ?
#   T(n) = T(n - 1) + 7
#   T(n) = T(n - 2) + 7 + 7
#   T(n) = T(n - k) + 7k

