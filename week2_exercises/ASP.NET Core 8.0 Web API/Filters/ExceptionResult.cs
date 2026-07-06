using Microsoft.AspNetCore.Mvc;

namespace AspNetCoreWebApi.Filters;

public class ExceptionResult : ObjectResult
{
    public ExceptionResult(string message) : base(message)
    {
        StatusCode = StatusCodes.Status500InternalServerError;
    }
}