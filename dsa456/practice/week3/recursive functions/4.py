def formula(n):
    if n <= 1:
        return 0
    return n * (n - 1) + formula(n - 1)


def main():
    print(formula(5))

if __name__ == "__main__":
    main()