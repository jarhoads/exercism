using System;

namespace Exercism
{
    /// <summary>
    /// enum used to choose which occurance of the day to find
    /// </summary>
    public enum Schedule
    {
        First,
        Second,
        Third,
        Fourth,
        Teenth,
        Last
    };

    public class Meetup
    {

        private int _month;
        private int _year;
        private DateTime firstOfMonth;

        public const int ONE_WEEK = 7;

        /// <summary>
        /// Constructor for Meetup 
        /// </summary>
        /// <param name="month">Month to look for an occurance of the day of the week</param>
        /// <param name="year">Year to use for checking the given month</param>
        public Meetup(int month, int year)
        {
            _month = month;
            _year = year;

        }

        /// <summary>
        /// DateTime Day 
        /// gives a date based on which occurance of the day of the week is given
        /// </summary>
        /// <param name="day">day of the week to find</param>
        /// <param name="sched">which occrance of the day within the month should be used</param>
        /// <returns>A DateTime representing the date</returns>
        public DateTime Day(DayOfWeek day, Schedule sched)
        {
            DateTime d = new DateTime();

            // I like using a switch for enum values
            switch (sched)
            {
                case Schedule.First:
                    d = GetSingle(1, day);
                    break;
                case Schedule.Second:
                    d = GetSingle(2, day);
                    break;
                case Schedule.Third:
                    d = GetSingle(3, day);
                    break;
                case Schedule.Fourth:
                    d = GetSingle(4, day);
                    break;
                case Schedule.Teenth:
                    d = GetTeenth(day);
                    break;
                case Schedule.Last:
                    d = GetLast(day);
                    break;
                default:
                    throw new Exception("Incorrect Schedule Option");
            }

            return d;
        }

        private DateTime GetSingle(int occurance, DayOfWeek d)
        {
            int days = FirstOfMonth(d);
            
            var day = (days + 1) + (ONE_WEEK * (occurance - 1));

            return new DateTime(_year, _month, day);
        }

        private DateTime GetTeenth(DayOfWeek day)
        {
            int days = FirstOfMonth(day);
            
            var weekDay = days + 1;

            // add a week and check to see if the date is a teenth
            DateTime nextWeek = new DateTime(_year, _month, weekDay).AddDays(ONE_WEEK);

            if (nextWeek.Day <= 12) { nextWeek = nextWeek.AddDays(ONE_WEEK); }

            return nextWeek;
        }

        private DateTime GetLast(DayOfWeek day)
        {
            // backup the month before changing it
            int m = _month;

            // look at the first week of next month and subtract 7 days (1 week) 
            if (_month == 12)
            {
                _month = 1;
                _year += 1;
            }
            else
            {
                _month += 1;
            }

            int days = FirstOfMonth(day);

            var weekDay = days + 1;

            DateTime lastDay = new DateTime(_year, _month, weekDay).AddDays(-ONE_WEEK);

            // put month back where it was
            _month = m;

            return lastDay;
        }

        private int FirstOfMonth(DayOfWeek day)
        {
            // find the first day of the month
            firstOfMonth = new DateTime(_year, _month, 1);

            // substract first day of the month with day of the week 
            var days = (int)day - (int)firstOfMonth.DayOfWeek;

            //if it is less than zero we need to get the next week day (add 7 days)
            if (days < 0) { days = days + ONE_WEEK; }

            return days;
        }

    }
}
