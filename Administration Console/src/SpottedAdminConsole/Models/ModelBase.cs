namespace SpottedAdminConsole.Models
{
    using System.ComponentModel.DataAnnotations;

    public class ModelBase
    {
        [Key]
        public string Id { get; set; }
    }
}
