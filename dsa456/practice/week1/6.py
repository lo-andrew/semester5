def remove_invalid(items):
    validList = []
    for item in items:
        if isinstance(item, int):
            if item > 0:
                validList.append(item)

    return validList

def main():
    print(remove_invalid([12,-2,3, 0, 131, -1, "1"]))       


if __name__ == "__main__":
    main()