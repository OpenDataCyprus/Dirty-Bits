namespace SpottedAdminConsole.Controllers
{
    using Microsoft.AspNetCore.Mvc;
    using Models;
    using System;
    using System.Collections.Generic;
    using System.Linq;

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
            return _context.MissingPersonReport.Where(x => x.MissingPerson.Id.ToUpper().Equals(id.ToUpper()));
        }

        [Route("api/[controller]/Search/{id}")]
        public IEnumerable<MissingPerson> Search(string id)
        {
            return _context.MissingPersons.Where(x => x.Id.ToUpper().Contains(id.ToUpper()) || x.Date.ToString().ToUpper().Contains(id.ToUpper()) || x.Description.ToUpper().Contains(x.Id.ToUpper()) || x.Name.ToUpper().Contains(x.Id.ToUpper()));   
        }
    }
}
