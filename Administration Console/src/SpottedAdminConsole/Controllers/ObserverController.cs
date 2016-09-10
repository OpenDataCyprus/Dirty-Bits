namespace SpottedAdminConsole.Controllers
{
    using Microsoft.AspNetCore.Mvc;

    public class ObserverController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
