# another exercise where I'm not sure
# if it's better to split the types of phrases
# into other methods or put them into the if statements
# and add the if statement into hey


def nothing(s):
    return len(s) == 0


def yelling(s):
    hasLetters = any(c.isalpha() for c in s)
    return ((s.upper()) == s and hasLetters)


def question(s):
    return len(s) > 0 and s[-1] == '?'


def bobsays(phrase):

    if nothing(phrase):
        return 'Fine. Be that way!'

    if yelling(phrase):
        return 'Whoa, chill out!'

    if question(phrase):
        return 'Sure.'

    return 'Whatever.'


def hey(what):
    """
    returns a message depending on what is passed to hey
    """
    return bobsays(what.strip())
