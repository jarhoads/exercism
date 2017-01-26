from itertools import groupby


def counter(ltrs):
    """
    used in encode
    """
    return ltrs[0] if len(ltrs) == 1 else str(len(ltrs)) + ltrs[0]


def encode(s):
    """
    encodes the string
    """

    groups = [list(letters) for (letter, letters) in groupby(s)]
    counts = list(map(counter, groups))

    return ''.join(counts)


def decode(s):
    """
    decodes the string passed into it
    I was trying to do something with iterators from itertools
    like encode above. I couldn't find anything that both
    works and doesn't look overly convoluted. So I left it like this.
    I plan on coming back to refactor this though.
    """
    decoded = ""

    num = ""
    for c in s:

        if c.isdigit():
            num += str(c)

        elif c.isalpha and len(num) == 0:
            decoded += c

        else:
            decoded += (c * int(num))
            num = ""

    return decoded
