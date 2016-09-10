using Microsoft.AspNetCore.Mvc;
using SpottedAdminConsole.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpottedAdminConsole.Controllers
{
    public class StolenVehicles : Controller
    {
        private ApplicationDataContext _context;

        public StolenVehicles(ApplicationDataContext context)
        {
            _context = context;
        }

        public IActionResult Create()
        {
            return View();
        }

        [HttpGet]
        public IEnumerable<StolenCar> List()
        {
            return _context.StolenCars;
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Create(StolenCar stolenCar)
        {
            if (ModelState.IsValid)
            {
                stolenCar.Id = Guid.NewGuid().ToString();
                _context.StolenCars.Add(stolenCar);
                _context.SaveChanges();

                return RedirectToAction("Index");
            }

            return View(stolenCar);
        }

        [Route("api/[controller]/ReportList/{id}")]
        public IEnumerable<StolenVehicleReport> ReportList(string id)
        {
            return _context.StolenVehicleReport.Where(x => x.Id.ToUpper().Equals(id.ToUpper()));
        }
    }
}
