from datetime import timedelta


def add_gigasecond(dt):
    """
    returns the gigasecond date given the birth date passed in
    revision 1: I decided to go with the one line solution after all,
    the more I looked at it the less sense it made to split it and
    create a new datetime
    """
    return dt + timedelta(seconds=(10**9))
