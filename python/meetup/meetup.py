import calendar
from datetime import date


class MeetupDayException(Exception):
    """
    MeetupDayException
    I'm not sure if this is what this exercise is looking for
    I'm still learning python so adding a custom exception was new to me
    """
    def __init___(self, dErrorMsg):
        Exception.__init__(self,
                           "Problem with meetup day: {0}".format(dErrorMsg))
        self.dErrorMessage = dErrorMsg


def meetup_day(year, month, day, day_type):
    """
    used for meetup day checking
    definitely need to refactor this one
    I thought this would be easier than it turned out to be
    """
    singles = ['1st', '2nd', '3rd', '4th', '5th']
    days = ['Monday',
            'Tuesday',
            'Wednesday',
            'Thursday',
            'Friday',
            'Saturday',
            'Sunday']
    d = 0

    monthdays = calendar.monthcalendar(year, month)

    find_day = days.index(day)

    if day_type in singles:
        # find out which one it is and get the number
        find_th = singles[singles.index(day_type)][0]
        d = get_date_single(monthdays, int(find_day), int(find_th))

        if d < 1:
            raise MeetupDayException("{0} does not have a {1} {2} in it"
                                     .format(month, day_type, day))
        return date(year, month, d)

    elif day_type == 'teenth':
        d = get_date_teenth(monthdays, int(find_day))

        if d < 1:
            raise MeetupDayException("Invalid teenth day lookup for {0}"
                                     .format(month))
        return date(year, month, d)

    elif day_type == 'last':
        d = get_date_last(monthdays, int(find_day))

        if d < 1:
            raise MeetupDayException("{0} does not have a last {1}"
                                     .format(month, day))
        return date(year, month, d)

    else:
        raise MeetupDayException("Invalid day type")


def get_date_single(mds, fd, th):
    """
    used by meetup_day to get the nth day
    takes 3 arguements:
    mds - monthday list of weeks
    fd - day to find
    th - nth day to find
    """
    fd_days = [week[fd] for week in mds if week[fd] != 0]
    return fd_days[th - 1] if th <= len(fd_days) else 0


def get_date_teenth(mds, fd):
    """
    used by meetup_day to get the n-teenth day
    takes 2 arguements:
    mds - monthday list of weeks
    fd - day to find
    """
    fd_teenth = [week[fd] for week in mds if week[fd] in range(13, 20)]
    return fd_teenth[0] if len(fd_teenth) > 0 else 0


def get_date_last(mds, fd):
    """
    used by meetup_day to get the last day
    takes 2 arguements:
    mds - monthday list of weeks
    fd - day to find
    """
    return [week[fd] for week in mds[::-1] if week[fd] != 0][0]
