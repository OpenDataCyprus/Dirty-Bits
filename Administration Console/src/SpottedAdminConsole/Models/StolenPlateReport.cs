namespace SpottedAdminConsole.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class StolenPlateReport : Report
    {
        public StolenPlates StolenPlate { get; set; }
    }
}
