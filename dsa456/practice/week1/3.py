def is_valid_password(text):

    if not isinstance(text, str):
        return False
    if len(text) < 8 or len(text) > 32:
        return False
    
    special_characters = "!@#$%^&*()-+?_=,<>/"
    has_upper = False
    has_lower = False
    has_digit = False
    has_special = False


    for c in text:
        if " " == c:
            return False
        if c.isupper():
            has_upper = True
        elif c.islower():
            has_lower = True
        elif c.isdigit():
            has_digit = True
        elif c in special_characters:
            has_special = True

    return has_upper and has_lower and has_digit and has_special
            
    

    
