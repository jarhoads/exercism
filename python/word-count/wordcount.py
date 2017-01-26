def convert(x):
    return x if x.isalnum() else ' '


def word_count(phrase):
    """
    returns a word count for the words in the phrase
    revision 1: added convert and combine methods, not sure if it's better
    than lambdas
    revision 2: used join instead of reduce and removed import.
    revision 3: read about the count method for lists and realized I could
    use it in a dictionary comprehension for this problem
    definitely feel like I'm missing a "trick" with this one
    this is what I came up with though
    """
    phrase = phrase.lower()
    words = ''.join(list(map(convert, phrase))).split()

    return {word: words.count(word) for word in words}
