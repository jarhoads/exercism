from itertools import groupby


def counter(ltrs):
    return ltrs[0] if len(ltrs) == 1 else str(len(ltrs)) + ltrs[0]


def encode(s):

    groups = [list(letters) for (letter, letters) in groupby(s)]
    counts = list(map(counter, groups))

    return ''.join(counts)


def decode_iterator(s):
    group = [list(values) for (key, values) in groupby(s, str.isalpha)]
    groups = [''.join(l) if l[0].isnumeric() else l for l in group]
    zipped = zip(groups[::2], groups[1::2])
    letters = [(int(n) * c[0]) + c[1] if len(c) > 1 else int(n) * c[0] for (n, c) in zipped]
    return ''.join(letters)
