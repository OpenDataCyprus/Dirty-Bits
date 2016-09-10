namespace SpottedAdminConsole.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class MissingPersonReport : Report
    {
        public MissingPerson MissingPerson { get; set; }
    }
}
