def sum(lst):
    if len(lst) == 0:
        return 0
    elif not isinstance(lst[0], int, float):
        return sum(lst[1:])
    
    return lst[0] + sum(lst[1:])