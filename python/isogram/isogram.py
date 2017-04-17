import string


def is_isogram(word):
    unique = {c for c in word.lower() if c in string.ascii_lowercase}
    letters = [c for c in word.lower() if c in string.ascii_lowercase]
    return len(letters) == len(unique)
