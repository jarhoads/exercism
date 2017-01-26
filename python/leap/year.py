def is_leap_year(year):
    """
    first submission for exercism.io
    learning python
    returns true if the year is a leap year, false otherwise
    """
    return (year % 4 == 0) and ((year % 100 != 0) or (year % 400 == 0))