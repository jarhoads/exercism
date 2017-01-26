using System;
using System.Linq;

namespace Exercism
{
    public class PhoneNumber
    {
        private readonly string _number;
        public string Number { get { return _number; } }

        private readonly string areaCode;
        public string AreaCode {

            // return the area code
            get { return areaCode; }

        }

        private readonly string localCode;
        private readonly string localNumber;

        public const int VALID_PHONE_NUMBER_LENGTH = 10;

        public PhoneNumber(string number)
        {
            _number = ParseNumber(number);
            if (!ValidNumber(_number)) { _number = "0000000000"; }

            // set values so Substring isn't called in every method
            // for such short strings I'm not sure how much of an overhead it would add
            // but it still seems like a good idea
            areaCode = Number.Substring(0, 3);
            localCode = Number.Substring(3, 3);
            localNumber = Number.Substring(6, 4);
        }

        public override string ToString()
        {
            return $"({AreaCode}) {localCode}-{localNumber}";     
        }

        private bool ValidNumber(string number)
        {
            return number.Length == VALID_PHONE_NUMBER_LENGTH;
        }

        private string ParseNumber(string number)
        {

            char[] exclude = { '.', '(', ')', ' ', '-' };
            var parsedNumber = from numberChar in number
                               where !(Array.Exists(exclude, excluded => excluded == numberChar))
                               select numberChar;

            number = string.Join("", parsedNumber);

            // country code number
            if ((number.Length > VALID_PHONE_NUMBER_LENGTH) && (number.Substring(0, 1) == "1"))
            {
                // remove the country code
                number = number.Substring(1);
            }
            
            return number; 
        }
    }
}
