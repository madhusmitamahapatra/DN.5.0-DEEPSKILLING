using Microsoft.AspNetCore.Mvc;

namespace AspNetCoreWebApi.Controllers;

[ApiController]
[Route("api/[controller]")]
public class ValuesController : ControllerBase
{
    [HttpGet]
    [ProducesResponseType(StatusCodes.Status200OK)]
    public ActionResult<IEnumerable<string>> Get()
    {
        return Ok(new[] { "value1", "value2" });
    }

    [HttpGet("{id}")]
    [ProducesResponseType(StatusCodes.Status200OK)]
    public ActionResult<string> Get(int id)
    {
        return Ok($"value{id}");
    }

    [HttpPost]
    [ProducesResponseType(StatusCodes.Status200OK)]
    public ActionResult<string> Post([FromBody] string value)
    {
        return Ok($"Created: {value}");
    }

    [HttpPut("{id}")]
    [ProducesResponseType(StatusCodes.Status200OK)]
    public ActionResult<string> Put(int id, [FromBody] string value)
    {
        return Ok($"Updated {id}: {value}");
    }

    [HttpDelete("{id}")]
    [ProducesResponseType(StatusCodes.Status200OK)]
    public IActionResult Delete(int id)
    {
        return Ok($"Deleted {id}");
    }
}