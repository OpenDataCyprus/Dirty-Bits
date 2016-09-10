namespace SpottedAdminConsole.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class WantedPersonReport : Report
    {
        public WantedPerson WantedPerson { get; set; }
    }
}
