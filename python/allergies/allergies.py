""" allergies module """

# -------------------------------------
# functions and data used by the class
# -------------------------------------


class Allergies:
    """ allergies class """

    allergen = [
            "eggs", "peanuts", "shellfish",
            "strawberries", "tomatoes", "chocolate",
            "pollen", "cats"
            ]

    # -----------------------------------
    # standard Python class methods
    # -----------------------------------

    def __init__(self, score):
        """ initialize allergy score """
        self.score = score
        self.lst = [self.allergen[i] for i in range(8) if (self.score & (2**i))]

    def __str__(self):
        return "{0}:{1}".format(self.score, self.lst)

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
    # Allergies specific methods
    # -----------------------------------

    def is_allergic_to(self, allergy_in):
        return allergy_in in self.lst
