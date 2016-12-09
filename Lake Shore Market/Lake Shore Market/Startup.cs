using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Lake_Shore_Market.Startup))]
namespace Lake_Shore_Market
{
    public partial class Startup {
        public void Configuration(IAppBuilder app) {
            ConfigureAuth(app);
        }
    }
}
