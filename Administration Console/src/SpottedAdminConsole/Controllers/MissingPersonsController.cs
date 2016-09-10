using Microsoft.AspNetCore.Mvc;
using SpottedAdminConsole.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SpottedAdminConsole.Controllers
{
    public class MissingPersonsController : Controller
    {
        private ApplicationDataContext _context;

        public MissingPersonsController(ApplicationDataContext context)
        {
            _context = context;
        }

        public IActionResult Index()
        {
            return View(_context.MissingPersons.ToList());
        }

        public IActionResult Create()
        {
            return View();
        }

        [HttpGet]
        public IEnumerable<MissingPerson> List()
        {
            return _context.MissingPersons;
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Create(MissingPerson missingPerson)
        {
            if (ModelState.IsValid)
            {
                missingPerson.Id = Guid.NewGuid().ToString();
                _context.MissingPersons.Add(missingPerson);
                _context.SaveChanges();

                return RedirectToAction("Index");
            }

            return View(missingPerson);
        }

        [Route("api/[controller]/ReportList/{id}")]
        public IEnumerable<MissingPersonReport> ReportList(string id)
        {
            return _context.MissingPersonReport.Where(x => x.Id.ToUpper().Equals(id.ToUpper()));
        }
    }
}
