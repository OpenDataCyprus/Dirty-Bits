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
            return _context.StolenPlateReport.Where(x => x.Id.ToUpper().Equals(id.ToUpper()));
        }

        [Route("api/[controller]/Search/{id}")]
        public IEnumerable<StolenPlates> Search(string id)
        {
            return _context.StolenPlates.Where(x => x.Id.ToUpper().Contains(id.ToUpper()) || x.PlateNumber.ToString().ToUpper().Contains(id.ToUpper()) || x.Brand.ToUpper().Contains(x.Id.ToUpper()) || x.Color.ToUpper().Contains(x.Id.ToUpper()) || x.ChassisNumber.ToUpper().Contains(x.Id.ToUpper()) || x.EngineNumber.ToUpper().Contains(x.Id.ToUpper()) || x.County.ToUpper().Contains(x.Id.ToUpper()) || x.DateStolen.ToString().ToUpper().Contains(x.Id.ToUpper()));
        }
    }
}
