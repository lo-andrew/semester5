def replace_blanks(text):
    if len(text) == 0:
        return ""
    
    first = "_" if text[0] == " " else text[0]
    # strings are immutable, so have to do it this way

    return first + replace_blanks(text[1:])

        