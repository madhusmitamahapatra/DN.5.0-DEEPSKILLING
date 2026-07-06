using Microsoft.AspNetCore.Mvc.Filters;

namespace AspNetCoreWebApi.Filters;

public class CustomExceptionFilter : Attribute, IExceptionFilter
{
    public void OnException(ExceptionContext context)
    {
        var logDirectory = Path.Combine(AppContext.BaseDirectory, "Logs");
        Directory.CreateDirectory(logDirectory);

        var logFilePath = Path.Combine(logDirectory, "exception-log.txt");
        var logMessage = $"{DateTime.Now:O} | {context.Exception.GetType().Name} | {context.Exception.Message}{Environment.NewLine}{context.Exception.StackTrace}{Environment.NewLine}";
        File.AppendAllText(logFilePath, logMessage);

        context.Result = new ExceptionResult("Internal server error");
        context.ExceptionHandled = true;
    }
}