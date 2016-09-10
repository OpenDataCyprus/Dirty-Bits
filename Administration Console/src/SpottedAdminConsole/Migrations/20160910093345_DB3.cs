using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore.Migrations;

namespace SpottedAdminConsole.Migrations
{
    public partial class DB3 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Country",
                table: "StolenPlates");

            migrationBuilder.AddColumn<string>(
                name: "County",
                table: "StolenPlates",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "County",
                table: "StolenPlates");

            migrationBuilder.AddColumn<string>(
                name: "Country",
                table: "StolenPlates",
                nullable: true);
        }
    }
}
