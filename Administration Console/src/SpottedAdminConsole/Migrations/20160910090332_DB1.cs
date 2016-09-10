using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore.Migrations;

namespace SpottedAdminConsole.Migrations
{
    public partial class DB1 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "MissingPersons",
                columns: table => new
                {
                    Id = table.Column<string>(nullable: false),
                    Date = table.Column<DateTime>(nullable: false),
                    Description = table.Column<string>(maxLength: 2048, nullable: true),
                    Name = table.Column<string>(maxLength: 256, nullable: false),
                    Picture = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_MissingPersons", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "StolenCars",
                columns: table => new
                {
                    Id = table.Column<string>(nullable: false),
                    Brand = table.Column<string>(nullable: true),
                    ChassisNumber = table.Column<string>(nullable: true),
                    Color = table.Column<string>(nullable: true),
                    EngineNumber = table.Column<string>(nullable: true),
                    MaxDate = table.Column<DateTime>(nullable: false),
                    MinDate = table.Column<DateTime>(nullable: false),
                    PlateNumber = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_StolenCars", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "StolenPlates",
                columns: table => new
                {
                    Id = table.Column<string>(nullable: false),
                    Brand = table.Column<string>(nullable: true),
                    ChassisNumber = table.Column<string>(nullable: true),
                    Color = table.Column<string>(nullable: true),
                    Country = table.Column<string>(nullable: true),
                    DateStolen = table.Column<DateTime>(nullable: false),
                    EngineNumber = table.Column<string>(nullable: true),
                    PlateNumber = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_StolenPlates", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "WantedPersons",
                columns: table => new
                {
                    Id = table.Column<string>(nullable: false),
                    Date = table.Column<DateTime>(nullable: false),
                    Description = table.Column<string>(maxLength: 2048, nullable: true),
                    Name = table.Column<string>(maxLength: 256, nullable: false),
                    Picture = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_WantedPersons", x => x.Id);
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "MissingPersons");

            migrationBuilder.DropTable(
                name: "StolenCars");

            migrationBuilder.DropTable(
                name: "StolenPlates");

            migrationBuilder.DropTable(
                name: "WantedPersons");
        }
    }
}
