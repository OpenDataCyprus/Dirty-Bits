namespace SpottedAdminConsole.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class Report : ModelBase
    {
        public float Latitude { get; set; }

        public float Longitude { get; set; }

        [MaxLength(2048)]
        public string Description { get; set; }

        public DateTime DateOfReport { get; set; }

        public string Photo { get; set; }     
    }
}
