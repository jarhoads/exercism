using System;
using System.Linq;

namespace Exercism
{
    public class Bob
    {
        /// <summary>
        /// static string Hey
        /// My Exercism attempt for Bob
        /// Revision 1: I realized I don't need the private method
        ///             to check for upper case letters
        /// Revision 2: Moved phrase type checks to different methods
        /// Revision 3: Read about using linq with strings here: 
        ///             https://msdn.microsoft.com/en-us/library/bb397915.aspx
        ///             updated my code to use that instead of a regex
        /// </summary>
        /// <param name="phrase">A string representing a phrase said to Bob</param>
        /// <returns>
        /// a string representing Bob's response:
        /// If someone says nothing to him he says "Fine. Be that way!"
        /// If it's a question he says "Sure."
        /// If someone is yelling he says "Whoa, chill out!"
        /// Otherwise he says "Whatever."
        /// </returns>
        public static string Hey(string phrase)
        {
            string nothing = "Fine. Be that way!";
            string question = "Sure.";
            string yelling = "Whoa, chill out!";
            string other = "Whatever.";

            phrase = phrase.Trim();

            if (Nothing(phrase)) { return nothing; }

            if (Yelling(phrase)) { return yelling; }

            if (Question(phrase)) { return question; }

            return other;
        }

        private static bool Nothing(string s)
        {
            return s.Length == 0;
        }

        private static bool Yelling(string s)
        {
            bool hasLetters = s.Any(char.IsLetter);
            return (s.ToUpper() == s && hasLetters);
        }

        private static bool Question(string s)
        {
            int length = s.Length;
            char last = s[length - 1];

            return last == '?';
        }

    }
}
