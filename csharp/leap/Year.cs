namespace Exercism
{
    public class Year
    {
        /// <summary>
        /// static bool IsLeap
        /// My first attempt at an exercism solution
        /// Revision 1: removed usings at the top that wren't used 
        /// </summary>
        /// <param name="year">an integer representing a year to check for a leap year</param>
        /// <returns>true if the year is a leap year, false otherewise</returns>
        public static bool IsLeap(int year)
        {
            return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
        }
    }
}
