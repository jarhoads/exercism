def square_of_sum(num):
    """ square of the sum """
    return sum(range(1, (num + 1))) ** 2


def sum_of_squares(num):
    """ sum of squares """
    return sum(n ** 2 for n in range(1, (num + 1)))


def difference(num):
    """ difference """
    return square_of_sum(num) - sum_of_squares(num)
