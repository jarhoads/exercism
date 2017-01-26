def distance(s1, s2):
    """
    returns the hamming distance of two strings
    """
    return sum([0 if a == b else 1 for (a, b) in zip(s1, s2)])
