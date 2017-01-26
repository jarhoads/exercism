namespace Exercism
{
    public class SpaceAge
    {
        public long Seconds { get; private set; }
        
        private const int EarthSecondsPerYear = 31557600;

        private const double EarthOrbit = 1.0;
        private const double MercuryOrbit = 0.2408467;
        private const double VenusOrbit = 0.61519726;
        private const double MarsOrbit = 1.8808158;
        private const double JupiterOrbit = 11.862615;
        private const double SaturnOrbit = 29.447498;
        private const double UranusOrbit = 84.016846;
        private const double NeptuneOrbit = 164.79132;

        private const double Earth = EarthOrbit * EarthSecondsPerYear;
        private const double Mercury = MercuryOrbit * EarthSecondsPerYear;
        private const double Venus = VenusOrbit * EarthSecondsPerYear;
        private const double Mars = MarsOrbit * EarthSecondsPerYear;
        private const double Jupiter = JupiterOrbit * EarthSecondsPerYear;
        private const double Saturn = SaturnOrbit * EarthSecondsPerYear;
        private const double Uranus = UranusOrbit * EarthSecondsPerYear;
        private const double Neptune = NeptuneOrbit * EarthSecondsPerYear;

        /// <summary>
        /// constructor for SpaceAge
        /// </summary>
        /// <param name="seconds">number of seconds to find years for different orbits</param>
        public SpaceAge(long seconds)
        {
            Seconds = seconds;
        }

        public double OnEarth() => Years(Earth);
        public double OnMercury() => Years(Mercury);
        public double OnVenus() => Years(Venus);
        public double OnMars() => Years(Mars);
        public double OnJupiter() => Years(Jupiter);
        public double OnSaturn() => Years(Saturn);
        public double OnUranus() => Years(Uranus);
        public double OnNeptune() => Years(Neptune);

        private double Years(double orbit)
        {
            return Seconds / orbit;
        }
    }
}
