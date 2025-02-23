using System.Collections.Generic;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Newtonsoft.Json;

public class Team
{
    public string Id { get; set; }
    public string TeamName { get; set; }
    public string TeamCity { get; set; }
}

public class webserviceModel : PageModel
{
    private readonly HttpClient _httpClient;

    public webserviceModel(IHttpClientFactory httpClientFactory)
    {
        _httpClient = httpClientFactory.CreateClient();
    }

    public List<Team> Teams { get; set; }
    public async Task OnGetAsync()
    {
        Teams = await GetDataFromApiAsync();
    }

    private async Task<List<Team>> GetDataFromApiAsync()
    {

        var response = await _httpClient.GetAsync("http://localhost:8003/api/v1/teams");
        response.EnsureSuccessStatusCode();

        var responseContent = await response.Content.ReadAsStringAsync();

        return JsonConvert.DeserializeObject<List<Team>>(responseContent);
    }
}