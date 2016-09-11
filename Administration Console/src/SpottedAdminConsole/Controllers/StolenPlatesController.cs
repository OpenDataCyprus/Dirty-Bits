namespace SpottedAdminConsole.Controllers
{
    using Microsoft.AspNetCore.Mvc;
    using Models;
    using System.Collections.Generic;
    using System.Linq;

    public class StolenPlatesController : Controller
    {
        private ApplicationDataContext _context;

        public StolenPlatesController(ApplicationDataContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IEnumerable<StolenPlates> List()
        {
            return _context.StolenPlates;
        }

        [Route("api/[controller]/ReportList/{id}")]
        public IEnumerable<StolenPlateReport> ReportList(string id)
        {
            return _context.StolenPlateReport.Where(x => x.StolenPlate.Id.ToUpper().Equals(id.ToUpper()));
        }

        [Route("api/[controller]/Search/{text}")]
        public IEnumerable<StolenPlates> Search(string text)
        {
            return _context.StolenPlates.Where(x => (x.Brand != null && x.Brand.ToUpperInvariant().Contains(text.ToUpperInvariant())) || x.PlateNumber.ToUpperInvariant().Contains(text.ToUpperInvariant()));
        }
    }
}
