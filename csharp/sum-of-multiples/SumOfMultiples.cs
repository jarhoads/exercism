using System.Collections.Generic;
using System.Linq;

namespace Exercism
{
    public class SumOfMultiples
    {
        public static int To(int[] numbers, int bound)
        {
            
            IList<int> multiples = new List<int>();

            foreach(int n in numbers)
            {
                for(int i = 0; (i * n) < bound; i++)
                {
                    int m = i * n;
                    if(m < bound && !multiples.Contains(m)) { multiples.Add(m); }
                }
            }

            // adding a check just in case there aren't any multiples
            // I'm not sure if that would happen
            return multiples.Count > 0 ? multiples.Sum() : 0;
        }
    }
}
