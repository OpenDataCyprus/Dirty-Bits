namespace SpottedAdminConsole.Models
{
    using Microsoft.EntityFrameworkCore;

    public class ApplicationDataContext : DbContext
    {
        public ApplicationDataContext(DbContextOptions<ApplicationDataContext> options)
            : base(options)
        { }

        public DbSet<MissingPerson> MissingPersons { get; set; }

        public DbSet<WantedPerson> WantedPersons { get; set; }

        public DbSet<StolenCar> StolenCars { get; set; }

        public DbSet<StolenPlates> StolenPlates { get; set; }
    }

}
