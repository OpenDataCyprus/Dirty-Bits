using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using SpottedAdminConsole.Models;

namespace SpottedAdminConsole.Migrations
{
    [DbContext(typeof(ApplicationDataContext))]
    [Migration("20160910093031_DB2")]
    partial class DB2
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
            modelBuilder
                .HasAnnotation("ProductVersion", "1.0.0-rtm-21431")
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("SpottedAdminConsole.Models.MissingPerson", b =>
                {
                    b.Property<string>("Id");

                    b.Property<DateTime>("Date");

                    b.Property<string>("Description")
                        .HasAnnotation("MaxLength", 2048);

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasAnnotation("MaxLength", 256);

                    b.Property<string>("Picture");

                    b.HasKey("Id");

                    b.ToTable("MissingPersons");
                });

            modelBuilder.Entity("SpottedAdminConsole.Models.StolenCar", b =>
                {
                    b.Property<string>("Id");

                    b.Property<string>("Brand");

                    b.Property<string>("ChassisNumber");

                    b.Property<string>("Color");

                    b.Property<string>("EngineNumber");

                    b.Property<DateTime?>("MaxDate");

                    b.Property<DateTime?>("MinDate");

                    b.Property<string>("PlateNumber");

                    b.HasKey("Id");

                    b.ToTable("StolenCars");
                });

            modelBuilder.Entity("SpottedAdminConsole.Models.StolenPlates", b =>
                {
                    b.Property<string>("Id");

                    b.Property<string>("Brand");

                    b.Property<string>("ChassisNumber");

                    b.Property<string>("Color");

                    b.Property<string>("Country");

                    b.Property<DateTime?>("DateStolen");

                    b.Property<string>("EngineNumber");

                    b.Property<string>("PlateNumber");

                    b.HasKey("Id");

                    b.ToTable("StolenPlates");
                });

            modelBuilder.Entity("SpottedAdminConsole.Models.WantedPerson", b =>
                {
                    b.Property<string>("Id");

                    b.Property<DateTime>("Date");

                    b.Property<string>("Description")
                        .HasAnnotation("MaxLength", 2048);

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasAnnotation("MaxLength", 256);

                    b.Property<string>("Picture");

                    b.HasKey("Id");

                    b.ToTable("WantedPersons");
                });
        }
    }
}
