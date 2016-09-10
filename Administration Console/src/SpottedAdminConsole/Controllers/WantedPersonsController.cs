namespace SpottedAdminConsole.Controllers
{
    using Microsoft.AspNetCore.Mvc;
    using Models;
    using System.Collections.Generic;
    using System.Linq;

    public class WantedPersonsController : Controller
    {
        private ApplicationDataContext _context;

        public WantedPersonsController(ApplicationDataContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IEnumerable<WantedPerson> List()
        {
            return _context.WantedPersons;
        }

        [Route("api/[controller]/ReportList/{id}")]
        public IEnumerable<WantedPersonReport> ReportList(string id)
        {
            return _context.WantedPersonReport.Where(x => x.Id.ToUpper().Equals(id.ToUpper()));
        }

        [Route("api/[controller]/Search/{id}")]
        public IEnumerable<WantedPerson> Search(string id)
        {
            return _context.WantedPersons.Where(x => x.Id.ToUpper().Contains(id.ToUpper()) || x.Date.ToString().ToUpper().Contains(id.ToUpper()) || x.Description.ToUpper().Contains(x.Id.ToUpper()) || x.Name.ToUpper().Contains(x.Id.ToUpper()));
        }
    }
}
