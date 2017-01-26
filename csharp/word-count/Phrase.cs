using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercism
{
    public class Phrase
    {
        /// <summary>
        /// public static WordCount
        /// some of this looks clunky, I plan on refactoring it in the future
        /// Revision 1: used method chaining for grouping words.
        ///             I'm not sure why I wasn't doing that to begin with.
        /// </summary>
        /// <param name="phrase">a string representing a phrase</param>
        /// <returns>a Dictionary containing words and the count for each one</returns>
        public static Dictionary<string, int> WordCount(string phrase)
        {
            phrase = phrase.ToLower();

            var groups = BuildPhrase(phrase)
                                .Trim()
                                .Split(new char[0], StringSplitOptions.RemoveEmptyEntries)
                                .GroupBy(i => i);

            var counts = new Dictionary<string, int>();
            foreach(var group in groups) { counts.Add(group.Key, group.Count()); }

            return counts;
        }

        /// <summary>
        /// private static string BuildPhrase
        /// I created this to help with WordCount
        /// I think using a StringBuilder is faster than using linq and 
        /// concatentating all of the strings with +
        /// </summary>
        /// <param name="phrase">a string representing a phrase</param>
        /// <returns>a string with everything but words converted to spaces</returns>
        private static string BuildPhrase(string phrase)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < phrase.Length; i++)
            {
                // i'm guessing this could be refactored into something better
                if (char.IsLetterOrDigit(phrase[i])) { sb.Append(phrase[i]); }
                else if (phrase[i].Equals('\'') && (i > 0) && (i < (phrase.Length - 2)))
                {
                    if (ApostropheInMiddle(phrase[i - 1],phrase[i + 1])) { sb.Append(phrase[i]); }
                    else { sb.Append(' '); }
                }
                else { sb.Append(' '); }

            }

            return sb.ToString();
        }

        /// <summary>
        /// ApostropheInMiddle
        /// checks to see if the apostrophe is in the middle of a word
        /// </summary>
        /// <param name="prev">previous character</param>
        /// <param name="next">next character</param>
        /// <returns>true if the apostrophe is in the middle of a word, false otherwise</returns>
        private static bool ApostropheInMiddle(char prev, char next)
        {
            return char.IsLetter(prev) && char.IsLetter(next);
        }
        
    }
}
