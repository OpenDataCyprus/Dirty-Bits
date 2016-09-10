using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore.Migrations;

namespace SpottedAdminConsole.Migrations
{
    public partial class DB2 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<DateTime>(
                name: "DateStolen",
                table: "StolenPlates",
                nullable: true);

            migrationBuilder.AlterColumn<DateTime>(
                name: "MinDate",
                table: "StolenCars",
                nullable: true);

            migrationBuilder.AlterColumn<DateTime>(
                name: "MaxDate",
                table: "StolenCars",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<DateTime>(
                name: "DateStolen",
                table: "StolenPlates",
                nullable: false);

            migrationBuilder.AlterColumn<DateTime>(
                name: "MinDate",
                table: "StolenCars",
                nullable: false);

            migrationBuilder.AlterColumn<DateTime>(
                name: "MaxDate",
                table: "StolenCars",
                nullable: false);
        }
    }
}
