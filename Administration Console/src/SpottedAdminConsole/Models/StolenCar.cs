namespace SpottedAdminConsole.Models
{
    using System;

    public class StolenCar : ModelBase
    {
        public string PlateNumber { get; set; }

        public string Brand { get; set; }

        public string Color { get; set; }

        public string ChassisNumber { get; set; }

        public string EngineNumber { get; set; }

        public DateTime? MinDate { get; set; }

        public DateTime? MaxDate { get; set; }
    }
}
