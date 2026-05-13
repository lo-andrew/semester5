def sum_of_digits(num):
    if not isinstance(num, int) or num < 0:
        return None
    
    total = 0

    while num > 0:
        total += num % 10
        num //= 10

    return total;

    