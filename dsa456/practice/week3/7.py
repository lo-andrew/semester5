def how_many_even(lst):
    if len(lst) == 0:
        return 0

    if lst[0] % 2 == 0:
        return 1 + how_many_even(lst[1:])
    else:
        return how_many_even(lst[1:])