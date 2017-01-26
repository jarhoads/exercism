using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace Exercism
{
    public class TwelveDaysSong
    {
        public struct TwelveDays
        {
            public readonly string Occurance;
            public readonly string Gift; 

            public TwelveDays(string occurance, string gift)
            {
                Occurance = occurance;
                Gift = gift;
            }
        }

        private readonly IList<TwelveDays> verses;

        public TwelveDaysSong()
        {
            verses = new ReadOnlyCollection<TwelveDays>(
                        new[] {
                            new TwelveDays ("first", "a Partridge in a Pear Tree"),
                            new TwelveDays ("second", "two Turtle Doves"),
                            new TwelveDays ("third", "three French Hens"),
                            new TwelveDays ("fourth", "four Calling Birds"),
                            new TwelveDays ("fifth", "five Gold Rings"),
                            new TwelveDays ("sixth", "six Geese-a-Laying"),
                            new TwelveDays ("seventh", "seven Swans-a-Swimming"),
                            new TwelveDays ("eighth", "eight Maids-a-Milking"),
                            new TwelveDays ("ninth", "nine Ladies Dancing"),
                            new TwelveDays ("tenth", "ten Lords-a-Leaping"),
                            new TwelveDays ("eleventh", "eleven Pipers Piping"),
                            new TwelveDays ("twelfth", "twelve Drummers Drumming")
                        });

        }

        public string Verse(int verse)
        {
            StringBuilder twelveDaysVerses = new StringBuilder(Begin(verse));

            if (verse > 1)
            {
                for (int i = verse; verse > 0; verse--)
                {
                    // this feels clunky and I feel like I'll probably change it
                    if(verse == 1)
                    {
                        twelveDaysVerses.Append($"and {verses[0].Gift}.\n");
                    }
                    else
                    {
                        twelveDaysVerses.Append($"{verses[verse - 1].Gift}, ");
                    }

                }
            }
            else
            {
                twelveDaysVerses.Append($"{verses[0].Gift}.\n");
            }

            return twelveDaysVerses.ToString();
        }

        public string Verses(int begin, int end)
        {
            StringBuilder song = new StringBuilder();
            for(int i = begin; i <= end; i++)
            {
                song.Append(Verse(i) + "\n");
            }

            return song.ToString();
        }

        public string Sing()
        {
            return Verses(1,12);
        }

        private string Begin(int verse)
        {
            return $"On the {verses[verse - 1].Occurance} day of Christmas my true love gave to me, ";
        }
    }
}
