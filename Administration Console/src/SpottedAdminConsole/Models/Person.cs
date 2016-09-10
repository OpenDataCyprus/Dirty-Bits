namespace SpottedAdminConsole.Models
{
    using System.ComponentModel.DataAnnotations;

    public class Person : ModelBase
    {
        [Required]
        [MaxLength(256)]
        public string Name { get; set; }
    }
}
