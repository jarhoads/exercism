using System;
using System.Collections.Generic;
using System.Linq;

namespace Exercism
{
    public class DNA
    {
        private readonly Dictionary<char, int> nucleotideCounts;
        public Dictionary<char, int> NucleotideCounts
        {
            get{ return nucleotideCounts; }
        }

        public DNA(string dna)
        {

            // using a readonly dictionary makes creating the counts in the 
            // constructor a little difficult
            // I feel like there is probably a better way to do this and I'm missing it
            this.nucleotideCounts = new Dictionary<char, int> { { 'A', 0 }, { 'T', 0 }, { 'C', 0 }, { 'G', 0 } };

            if (dna.Length > 0)
            {
                nucleotideCounts = nucleotideCounts.Keys.ToDictionary(n => n, n => dna.Count(c => c.Equals(n)));
            }

        }

        public int Count(char nucleotide)
        {
            if (!nucleotideCounts.ContainsKey(nucleotide)) 
            { 
                throw new InvalidNucleotideException("Nucleotide must be 'A', 'C', 'G', or 'T'"); 
            }

            return NucleotideCounts[nucleotide];
        }

    }

    /// <summary>
    /// InvalidNucleotideException
    /// Exception for DNA class. 
    /// I'm including this in the same file because it's the only place it's used
    /// </summary>
    [Serializable]
    public class InvalidNucleotideException : ApplicationException
    {
        public InvalidNucleotideException() { }
        public InvalidNucleotideException(string message) : base(message) { }
        public InvalidNucleotideException(string message, Exception inner) : base(message, inner) { }
        protected InvalidNucleotideException(
          System.Runtime.Serialization.SerializationInfo info,
          System.Runtime.Serialization.StreamingContext context) : base(info, context) { }
    }
}
