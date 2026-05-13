def count_vowels(text):
    if not isinstance(text, str):
        return None
    
    vowels = ["a", "e", "i", "o", "u"]
    count = 0

    for c in text:
        for vowel in vowels.lower():
            if c == vowel:
                count += 1
    
    return count

# def count_vowels(text):
#     if not isinstance(text, str):
#         return None

#     vowels = "aeiou"
#     count = 0

#     for char in text.lower():
#         if char in vowels:
#             count += 1

#     return count


def main():
    print(count_vowels("Hello"))          # Expected: 2
    print(count_vowels("Hello WORLD"))    # Expected: 3
    print(count_vowels("PYTHON"))         # Expected: 1
    print(count_vowels(""))               # Expected: 0
    print(count_vowels(123))              # Expected: None
    print(count_vowels(["cat", "dog"]))   # Expected: None

if __name__ == "__main__":
    main()  
