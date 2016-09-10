using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore.Migrations;

namespace SpottedAdminConsole.Migrations
{
    public partial class DB4 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "MissingPersonReport",
                columns: table => new
                {
                    Id = table.Column<string>(nullable: false),
                    DateOfReport = table.Column<DateTime>(nullable: false),
                    Description = table.Column<string>(maxLength: 2048, nullable: true),
                    Latitude = table.Column<float>(nullable: false),
                    Longitude = table.Column<float>(nullable: false),
                    MissingPersonId = table.Column<string>(nullable: true),
                    Photo = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_MissingPersonReport", x => x.Id);
                    table.ForeignKey(
                        name: "FK_MissingPersonReport_MissingPersons_MissingPersonId",
                        column: x => x.MissingPersonId,
                        principalTable: "MissingPersons",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "StolenPlateReport",
                columns: table => new
                {
                    Id = table.Column<string>(nullable: false),
                    DateOfReport = table.Column<DateTime>(nullable: false),
                    Description = table.Column<string>(maxLength: 2048, nullable: true),
                    Latitude = table.Column<float>(nullable: false),
                    Longitude = table.Column<float>(nullable: false),
                    Photo = table.Column<string>(nullable: true),
                    StolenPlateId = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_StolenPlateReport", x => x.Id);
                    table.ForeignKey(
                        name: "FK_StolenPlateReport_StolenPlates_StolenPlateId",
                        column: x => x.StolenPlateId,
                        principalTable: "StolenPlates",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "StolenVehicleReport",
                columns: table => new
                {
                    Id = table.Column<string>(nullable: false),
                    DateOfReport = table.Column<DateTime>(nullable: false),
                    Description = table.Column<string>(maxLength: 2048, nullable: true),
                    Latitude = table.Column<float>(nullable: false),
                    Longitude = table.Column<float>(nullable: false),
                    Photo = table.Column<string>(nullable: true),
                    StolenCarId = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_StolenVehicleReport", x => x.Id);
                    table.ForeignKey(
                        name: "FK_StolenVehicleReport_StolenCars_StolenCarId",
                        column: x => x.StolenCarId,
                        principalTable: "StolenCars",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "WantedPersonReport",
                columns: table => new
                {
                    Id = table.Column<string>(nullable: false),
                    DateOfReport = table.Column<DateTime>(nullable: false),
                    Description = table.Column<string>(maxLength: 2048, nullable: true),
                    Latitude = table.Column<float>(nullable: false),
                    Longitude = table.Column<float>(nullable: false),
                    Photo = table.Column<string>(nullable: true),
                    WantedPersonId = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_WantedPersonReport", x => x.Id);
                    table.ForeignKey(
                        name: "FK_WantedPersonReport_WantedPersons_WantedPersonId",
                        column: x => x.WantedPersonId,
                        principalTable: "WantedPersons",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateIndex(
                name: "IX_MissingPersonReport_MissingPersonId",
                table: "MissingPersonReport",
                column: "MissingPersonId");

            migrationBuilder.CreateIndex(
                name: "IX_StolenPlateReport_StolenPlateId",
                table: "StolenPlateReport",
                column: "StolenPlateId");

            migrationBuilder.CreateIndex(
                name: "IX_StolenVehicleReport_StolenCarId",
                table: "StolenVehicleReport",
                column: "StolenCarId");

            migrationBuilder.CreateIndex(
                name: "IX_WantedPersonReport_WantedPersonId",
                table: "WantedPersonReport",
                column: "WantedPersonId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "MissingPersonReport");

            migrationBuilder.DropTable(
                name: "StolenPlateReport");

            migrationBuilder.DropTable(
                name: "StolenVehicleReport");

            migrationBuilder.DropTable(
                name: "WantedPersonReport");
        }
    }
}
