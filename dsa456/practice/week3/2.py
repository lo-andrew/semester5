def print_dots_v2(n, i=1):
    if n == 0:
        return ""
    elif i > n:
        return ""
    
    print(f"{"":.<{i}}")
    return print_dots_v2(n, i + 1)
    
    
def main():
    print(print_dots_v2(3))

if __name__ == "__main__":
    main()