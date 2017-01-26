""" clock module """

# -----------------------------------
# functions used by the Clock class
# -----------------------------------


def hours_minutes(mins):
    """ return hours and minutes given the minutes """
    return ((mins // 60) % 24, (mins % 60) % 60)


def to_minutes(hrs, mns):
    """ convert hours and minutes to total minutes """
    return (hrs * 60) + mns


class Clock:
    """ a simple clock class """

    # -----------------------------------
    # standard Python class methods
    # -----------------------------------

    def __init__(self, hour, minute):
        """ initialize hour and minute """
        (self.hour, self.minute) = hours_minutes(to_minutes(hour, minute))

    def __str__(self):
        return "{0:02d}:{1:02d}".format(self.hour, self.minute)

    def __eq__(self, other):
        """Override the default Equals behavior"""
        if isinstance(other, self.__class__):
            return self.__dict__ == other.__dict__
        return NotImplemented

    def __ne__(self, other):
        """Define a non-equality test"""
        if isinstance(other, self.__class__):
            return not self.__eq__(other)
        return NotImplemented

    def __hash__(self):
        """ Override the default hash behavior
            (that returns the id of the object)"""
        return hash(tuple(sorted(self.__dict__.items())))

    # -----------------------------------
    # Clock specific methods
    # -----------------------------------

    def add(self, added):
        """ return new time after adding it to hours and minutes """

        # convert current time to minutes
        total_minutes = to_minutes(self.hour, self.minute) + added

        # convert total minutes to hours and seconds
        (hrs, mins) = hours_minutes(total_minutes)

        return Clock(hrs, mins)
