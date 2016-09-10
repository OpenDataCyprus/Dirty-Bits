using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using SpottedAdminConsole.Models;

namespace SpottedAdminConsole.Migrations
{
    [DbContext(typeof(ApplicationDataContext))]
    partial class ApplicationDataContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
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

            modelBuilder.Entity("SpottedAdminConsole.Models.MissingPersonReport", b =>
                {
                    b.Property<string>("Id");

                    b.Property<DateTime>("DateOfReport");

                    b.Property<string>("Description")
                        .HasAnnotation("MaxLength", 2048);

                    b.Property<float>("Latitude");

                    b.Property<float>("Longitude");

                    b.Property<string>("MissingPersonId");

                    b.Property<string>("Photo");

                    b.HasKey("Id");

                    b.HasIndex("MissingPersonId");

                    b.ToTable("MissingPersonReport");
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

            modelBuilder.Entity("SpottedAdminConsole.Models.StolenPlateReport", b =>
                {
                    b.Property<string>("Id");

                    b.Property<DateTime>("DateOfReport");

                    b.Property<string>("Description")
                        .HasAnnotation("MaxLength", 2048);

                    b.Property<float>("Latitude");

                    b.Property<float>("Longitude");

                    b.Property<string>("Photo");

                    b.Property<string>("StolenPlateId");

                    b.HasKey("Id");

                    b.HasIndex("StolenPlateId");

                    b.ToTable("StolenPlateReport");
                });

            modelBuilder.Entity("SpottedAdminConsole.Models.StolenPlates", b =>
                {
                    b.Property<string>("Id");

                    b.Property<string>("Brand");

                    b.Property<string>("ChassisNumber");

                    b.Property<string>("Color");

                    b.Property<string>("County");

                    b.Property<DateTime?>("DateStolen");

                    b.Property<string>("EngineNumber");

                    b.Property<string>("PlateNumber");

                    b.HasKey("Id");

                    b.ToTable("StolenPlates");
                });

            modelBuilder.Entity("SpottedAdminConsole.Models.StolenVehicleReport", b =>
                {
                    b.Property<string>("Id");

                    b.Property<DateTime>("DateOfReport");

                    b.Property<string>("Description")
                        .HasAnnotation("MaxLength", 2048);

                    b.Property<float>("Latitude");

                    b.Property<float>("Longitude");

                    b.Property<string>("Photo");

                    b.Property<string>("StolenCarId");

                    b.HasKey("Id");

                    b.HasIndex("StolenCarId");

                    b.ToTable("StolenVehicleReport");
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

            modelBuilder.Entity("SpottedAdminConsole.Models.WantedPersonReport", b =>
                {
                    b.Property<string>("Id");

                    b.Property<DateTime>("DateOfReport");

                    b.Property<string>("Description")
                        .HasAnnotation("MaxLength", 2048);

                    b.Property<float>("Latitude");

                    b.Property<float>("Longitude");

                    b.Property<string>("Photo");

                    b.Property<string>("WantedPersonId");

                    b.HasKey("Id");

                    b.HasIndex("WantedPersonId");

                    b.ToTable("WantedPersonReport");
                });

            modelBuilder.Entity("SpottedAdminConsole.Models.MissingPersonReport", b =>
                {
                    b.HasOne("SpottedAdminConsole.Models.MissingPerson", "MissingPerson")
                        .WithMany()
                        .HasForeignKey("MissingPersonId");
                });

            modelBuilder.Entity("SpottedAdminConsole.Models.StolenPlateReport", b =>
                {
                    b.HasOne("SpottedAdminConsole.Models.StolenPlates", "StolenPlate")
                        .WithMany()
                        .HasForeignKey("StolenPlateId");
                });

            modelBuilder.Entity("SpottedAdminConsole.Models.StolenVehicleReport", b =>
                {
                    b.HasOne("SpottedAdminConsole.Models.StolenCar", "StolenCar")
                        .WithMany()
                        .HasForeignKey("StolenCarId");
                });

            modelBuilder.Entity("SpottedAdminConsole.Models.WantedPersonReport", b =>
                {
                    b.HasOne("SpottedAdminConsole.Models.WantedPerson", "WantedPerson")
                        .WithMany()
                        .HasForeignKey("WantedPersonId");
                });
        }
    }
}
