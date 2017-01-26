def slices(s, n):
    if(n == 0 or n > len(s)):
        raise ValueError

    vals = [s[i:(i+n)] for i in range(len(s)) if len(s[i:(i+n)]) == n]
    return [[int(j) for j in i] for i in vals]
