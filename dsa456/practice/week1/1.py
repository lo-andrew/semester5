
def average(lst):
    sum = 0.0
    length = 0

    for num in lst:
        if isinstance(num, (int, float)):
            sum += num
            length += 1
        else:
            continue
    
    if length == 0:
        return "None"

    average = sum / length 
    return average

# def average(numbers):
#     if not isinstance(numbers, list):
#         return None

#     if len(numbers) == 0:
#         return None

#     total = 0
#     count = 0

#     for value in numbers:
#         if not isinstance(value, (int, float)):
#             continue
#         total += value
#         count += 1

#     if count == 0:
#         return None
#     return total / count



def main():
    print(average([1, 2, 3, 4]))        # Expected: 2.5
    print(average([10]))                # Expected: 10.0
    print(average([]))                  # Expected: None
    print(average("123"))               # Expected: None
    print(average([1, "a", 3]))         # Expected: 2.0

if __name__ == "__main__":
    main()