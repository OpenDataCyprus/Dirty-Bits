using Microsoft.AspNetCore.Mvc;
using SpottedAdminConsole.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpottedAdminConsole.Controllers
{
    public class WantedPersonsController : Controller
    {
        private ApplicationDataContext _context;

        public WantedPersonsController(ApplicationDataContext context)
        {
            _context = context;
        }

        public IActionResult Index()
        {
            return View(_context.WantedPersons.ToList());
        }

        public IActionResult Create()
        {
            return View();
        }

        [HttpGet]
        public IEnumerable<WantedPerson> List()
        {
            return _context.WantedPersons;
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Create(WantedPerson wantedPerson)
        {
            if (ModelState.IsValid)
            {
                wantedPerson.Id = Guid.NewGuid().ToString();
                _context.WantedPersons.Add(wantedPerson);
                _context.SaveChanges();

                return RedirectToAction("Index");
            }

            return View(wantedPerson);
        }

        [Route("api/[controller]/ReportList/{id}")]
        public IEnumerable<WantedPersonReport> ReportList(string id)
        {
            return _context.WantedPersonReport.Where(x => x.Id.ToUpper().Equals(id.ToUpper()));
        }
    }
}
