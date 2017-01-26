using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercism
{
    public class Robot
    {
        
        private static Random _random = new Random();

        private string name;
        public string Name
        {
            get { return name; }
            private set { name = value; }
        }

        public Robot()
        {
            SetName();
        }

        public void Reset()
        {
            SetName();
        }

        private void SetName()
        {
            
            Name = RandomLetter() + RandomLetter() + 
                   RandomNumber() + RandomNumber() + RandomNumber();
        }

        private string RandomLetter()
        {
            int position = _random.Next(0, 26);
            return ((char)('A' + position)).ToString();
        }

        private string RandomNumber()
        {
            int number = _random.Next(0, 9);
            return number.ToString();
        }
    }
}
