using System.Collections.Generic;

namespace Exercism
{
    public class ETL
    {
        /// <summary>
        /// static Transform
        /// Exercism attempt for ETL
        /// I've been reading more about Linq and I plan on refactoring 
        /// this to use System.Linq 
        /// </summary>
        /// <param name="old">a dictionary representing the old point structure</param>
        /// <returns>a dictionary containing the new point structure</returns>
        public static Dictionary<string, int> Transform(Dictionary<int, IList<string>> old)
        {
            var letterPoints = new Dictionary<string, int>();
            
            foreach(var pair in old)
            {
                int point = pair.Key;
                foreach(string letter in pair.Value)
                {
                    letterPoints.Add(letter.ToLower(), point);
                }
            }
             
            return letterPoints;
        }
    }
}
