﻿namespace SpottedAdminConsole.Controllers
{
    using Microsoft.AspNetCore.Mvc;
    using Models;
    using System;
    using System.Collections.Generic;
    using System.Linq;

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


        [HttpGet]
        public IEnumerable<WantedPerson> List()
        {
            return _context.WantedPersons;
        }

        [Route("api/[controller]/ReportList/{id}")]
        public IEnumerable<WantedPersonReport> ReportList(string id)
        {
            return _context.WantedPersonReport.Where(x => x.WantedPerson.Id.ToUpper().Equals(id.ToUpper()));
        }

        [Route("api/[controller]/Search/{text}")]
        public IEnumerable<WantedPerson> Search(string text)
        {
            return _context.WantedPersons.Where(x => (x.Description != null && x.Description.ToUpperInvariant().Contains(text.ToUpperInvariant())) || x.Name.ToUpperInvariant().Contains(text.ToUpperInvariant()));
        }
    }
}
