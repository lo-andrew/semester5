def how_many_a(text):
    if len(text) == 0:
        return 0
    
    first = 1 if text[0].lower() == 'a' else 0
    return first + how_many_a(text[1:])
    

