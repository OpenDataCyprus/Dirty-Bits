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

        public DbSet<MissingPersonReport> MissingPersonReport { get; set; }

        public DbSet<WantedPersonReport> WantedPersonReport { get; set; }

        public DbSet<StolenVehicleReport> StolenVehicleReport { get; set; }

        public DbSet<StolenPlateReport> StolenPlateReport { get; set; }
    }

}
