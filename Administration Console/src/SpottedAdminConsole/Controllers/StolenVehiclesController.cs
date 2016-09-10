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

        [Route("api/[controller]/Search/{id}")]
        public IEnumerable<StolenCar> Search(string id)
        {
            return _context.StolenCars.Where(x => x.Id.ToUpper().Contains(id.ToUpper()) || x.PlateNumber.ToString().ToUpper().Contains(id.ToUpper()) || x.Brand.ToUpper().Contains(id.ToUpper()) || x.Color.ToUpper().Contains(x.Id.ToUpper()) || x.ChassisNumber.ToUpper().Contains(x.Id.ToUpper()) || x.EngineNumber.ToUpper().Contains(x.Id) || x.MinDate.ToString().ToUpper().Contains(x.Id.ToUpper()) || x.MaxDate.ToString().ToUpper().Contains(x.Id.ToUpper()));
        }
    }
}
