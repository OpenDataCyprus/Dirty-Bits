namespace SpottedAdminConsole.Models
{
    using System;

    public class StolenPlates : ModelBase
    {
        public string PlateNumber { get; set; }

        public string Brand { get; set; }

        public string Color { get; set; }

        public string ChassisNumber { get; set; }

        public string EngineNumber { get; set; }

        public string County { get; set; }

        public DateTime? DateStolen { get; set; }
    }
}
