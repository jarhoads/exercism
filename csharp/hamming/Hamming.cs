using System.Linq;

namespace Exercism
{
    public class Hamming
    {
        /// <summary>
        /// static int Compute
        /// computes the hamming distance between two strings
        /// .Sum() could be added to the end of the first line and returned
        /// making this a one line method
        /// I split them up to make it easier to read
        /// </summary>
        /// <param name="a">first string for hamming distance</param>
        /// <param name="b">second string for hamming distance</param>
        /// <returns>an integer representing the hamming distance</returns>
        public static int Compute(string a, string b)
        {
            var zipped = a.Zip(b, (x, y) => (x == y) ? 0 : 1);
            return zipped.Sum();
        }
    }
}
