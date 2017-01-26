using System;
using System.Collections.Generic;

namespace Exercism
{
    public class School
    {
        private Dictionary<int, List<String>> roster;
        public Dictionary<int, List<String>> Roster
        {
            // set not needed for roster
            // return a copy so the client doesn't have access to the internal roster
            get { return new Dictionary<int, List<String>>(roster); }
        }

        public School()
        {
            this.roster = new Dictionary<int, List<String>>();
        }

        /// <summary>
        /// public void Add
        /// Add a student to a grade
        /// </summary>
        /// <param name="student">student to add as a string</param>
        /// <param name="grade">grade to add the student to</param>
        public void Add(string student, int grade)
        {
            if (roster.ContainsKey(grade))
            {
                // add student to the grade list
                roster[grade].Add(student);

                // sort the roster, for some reason i couldn't get the method calls to chain
                roster[grade].Sort();
            }
            else
            {
                // add the grade and the student
                roster.Add(grade, new List<string> { student });
            }
        }

        /// <summary>
        /// public List Grade
        /// Get a list of the students in a given grade
        /// </summary>
        /// <param name="grade">the grade to get the list of students for</param>
        /// <returns>a list of student names as strings</returns>
        public List<String> Grade(int grade)
        {
            // return a copy so the client doesn't have access to the internal list
            return roster.ContainsKey(grade) ? new List<String>(this.Roster[grade]) : new List<string>(); 

        }


    }
}
