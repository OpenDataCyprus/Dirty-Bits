namespace SpottedAdminConsole.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class WantedPerson : Person
    {
        [MaxLength(2048)]
        public string Description { get; set; }

        public DateTime Date { get; set; }

        public string Picture { get; set; }
    }
}
