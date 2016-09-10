namespace SpottedAdminConsole.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class StolenVehicleReport : Report
    {
        public StolenCar StolenCar { get; set; }
    }
}
