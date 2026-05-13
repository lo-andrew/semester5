

def is_multiple_of_3(num):

    while True:
        total = 0 #have to reset total inbetween while iterations
        for digit in str(num):
            total += int(digit)
        if total > 9:
            num = total
        else:
            break
    
    if total in [0, 3, 6, 9]:
        return True
    else:
        return False

def main():
    print(is_multiple_of_3(9992))       


if __name__ == "__main__":
    main()