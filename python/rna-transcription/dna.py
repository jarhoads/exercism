def to_rna(dnas):
    """
    converts dna to rna
    """

    rna = {'G': 'C', 'C': 'G', 'T': 'A', 'A': 'U'}

    return ''.join(rna[d] for d in dnas)
