namespace SpottedAdminConsole.Controllers
{
    using Microsoft.AspNetCore.Mvc;
    using Models;
    using System.Collections.Generic;
    using System.Linq;

    public class StolenVehicles : Controller
    {
        private ApplicationDataContext _context;

        public StolenVehicles(ApplicationDataContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IEnumerable<StolenCar> List()
        {
            return _context.StolenCars;
        }

        [Route("api/[controller]/ReportList/{id}")]
        public IEnumerable<StolenVehicleReport> ReportList(string id)
        {
            return _context.StolenVehicleReport.Where(x => x.StolenCar.Id.ToUpper().Equals(id.ToUpper()));
        }

        [Route("api/[controller]/Search/{text}")]
        public IEnumerable<StolenCar> Search(string text)
        {
            return _context.StolenCars.Where(x => (x.Brand != null && x.Brand.ToUpperInvariant().Contains(text.ToUpperInvariant())) || x.PlateNumber.ToUpperInvariant().Contains(text.ToUpperInvariant()));
        }
    }
}
