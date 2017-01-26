def anagram(s1, s2):
    (w1, w2) = (s1.lower(), s2.lower())
    return (w1 != w2) and (sorted(w1) == sorted(w2))


def detect_anagrams(word, words):
    return [w for w in words if anagram(word, w)]
