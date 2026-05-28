def print_dots_v1(n):
    if n == 0:
        return ""
    print(f"{"":.<{n}}")
    return print_dots_v1(n - 1)


def main():
    print(print_dots_v1(6))

if __name__ == "__main__":
    main()