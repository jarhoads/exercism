using System.Collections.Generic;
using System.Linq;

namespace Exercism
{
    public class Anagram
    {
        private string check;

        /// <summary>
        /// Anagram constructor
        /// </summary>
        /// <param name="s">a string representing a word to check for anagrams</param>
        public Anagram(string s)
        {
            s = s.ToLower();
            this.check = s;
        }

        /// <summary>
        /// public Match
        /// method of Anagram class that returns a list
        /// of anagrams for the word added in the constructor
        /// </summary>
        /// <param name="words">a list of words to check for anagrams</param>
        /// <returns>an array of strings representing anagrams</returns>
        public string[] Match(string[] words)
        {
            var anagrams = new List<string>();
            foreach(string word in words)
            {
                string w = word.ToLower();

                if (IsAnagram(w)) { anagrams.Add(word); }
            }

            return anagrams.ToArray();
        }

        /// <summary>
        /// private IsAnagram
        /// </summary>
        /// <param name="s">a string to determine if it is an anagram</param>
        /// <returns>true if the word is an anagram of check, false otherwise</returns>
        private bool IsAnagram(string s)
        {
            if(s.Length != check.Length) { return false; }
            if(s == check) { return false; }

            foreach (char letter in s)
            {
                // same number of letters in check and s
                // this feels clunky and there is probably a 
                // better way to do it
                int checkCount = check.Count(c => c == letter);
                int sCount = s.Count(c => c == letter);
                if (check.IndexOf(letter) < 0 || (checkCount != sCount)) { return false; }
            }

            return true;

        }
    }
}
