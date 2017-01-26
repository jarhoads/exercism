import string


def is_pangram(phrase):
    """
    second exercism.io submission while learning python
    revision 1: changing this to a shorter version
                although I'm still confused about what the point 
                of the umlaut test case is. it doesn't test for 
                German pangrams.
    I'm not sure if the way I'm checking for German is 'pythonic'
    but I can't think of another way to do it right now
    returns true if phrase is a pangram
    false otherwise
    """
    phrase = phrase.lower()

    letters = len({c for c in phrase if c in string.ascii_lowercase})

    return letters == len(string.ascii_lowercase)
