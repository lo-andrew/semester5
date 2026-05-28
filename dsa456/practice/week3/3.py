def formula(n):
    if n <= 0:
        return
    
    if n % 2 == 0:
        return 2 * n + formula(n - 1)
    else:
        return n + formula(n - 1)