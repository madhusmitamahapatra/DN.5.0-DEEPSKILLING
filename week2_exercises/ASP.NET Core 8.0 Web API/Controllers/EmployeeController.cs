using AspNetCoreWebApi.Filters;
using AspNetCoreWebApi.Models;
using Microsoft.AspNetCore.Mvc;

namespace AspNetCoreWebApi.Controllers;

[ApiController]
[Route("api/[controller]")]
[CustomAuthFilter]
[CustomExceptionFilter]
public class EmployeeController : ControllerBase
{
    private static readonly List<Employee> Employees = new()
    {
        new()
        {
            Id = 1,
            Name = "John",
            Salary = 50000,
            Permanent = true,
            Department = new Department { Id = 1, Name = "IT" },
            Skills = new List<Skill>
            {
                new() { Id = 1, Name = "C#" },
                new() { Id = 2, Name = "SQL" }
            },
            DateOfBirth = new DateTime(1995, 5, 10)
        },
        new()
        {
            Id = 2,
            Name = "Mary",
            Salary = 60000,
            Permanent = false,
            Department = new Department { Id = 2, Name = "HR" },
            Skills = new List<Skill>
            {
                new() { Id = 3, Name = "Communication" },
                new() { Id = 4, Name = "Recruitment" }
            },
            DateOfBirth = new DateTime(1993, 8, 22)
        },
        new()
        {
            Id = 3,
            Name = "David",
            Salary = 70000,
            Permanent = true,
            Department = new Department { Id = 3, Name = "Finance" },
            Skills = new List<Skill>
            {
                new() { Id = 5, Name = "Accounting" },
                new() { Id = 6, Name = "Excel" }
            },
            DateOfBirth = new DateTime(1990, 12, 1)
        }
    };

    [HttpGet]
    [ProducesResponseType(StatusCodes.Status200OK)]
    [ProducesResponseType(StatusCodes.Status500InternalServerError)]
    public ActionResult<List<Employee>> Get()
    {
        return Ok(GetStandardEmployeeList());
    }

    [HttpGet("standard")]
    [ProducesResponseType(StatusCodes.Status200OK)]
    public ActionResult<Employee> GetStandard()
    {
        return Ok(GetStandardEmployeeList().First());
    }

    [HttpGet("error")]
    [ProducesResponseType(StatusCodes.Status500InternalServerError)]
    public IActionResult GetError()
    {
        throw new InvalidOperationException("Employee GET exception demo");
    }

    [HttpPost]
    [ProducesResponseType(StatusCodes.Status200OK)]
    public ActionResult<Employee> Post([FromBody] Employee employee)
    {
        var nextId = Employees.Count == 0 ? 1 : Employees.Max(item => item.Id) + 1;
        employee.Id = nextId;
        Employees.Add(employee);
        return Ok(employee);
    }

    [HttpPut("{id}")]
    [ProducesResponseType(StatusCodes.Status200OK)]
    [ProducesResponseType(StatusCodes.Status400BadRequest)]
    public ActionResult<Employee> Put(int id, [FromBody] Employee employee)
    {
        if (id <= 0)
        {
            return BadRequest("Invalid employee id");
        }

        var existingEmployee = Employees.FirstOrDefault(item => item.Id == id);
        if (existingEmployee is null)
        {
            return BadRequest("Invalid employee id");
        }

        employee.Id = id;
        existingEmployee.Name = employee.Name;
        existingEmployee.Salary = employee.Salary;
        existingEmployee.Permanent = employee.Permanent;
        existingEmployee.Department = employee.Department;
        existingEmployee.Skills = employee.Skills;
        existingEmployee.DateOfBirth = employee.DateOfBirth;

        return Ok(existingEmployee);
    }

    [HttpDelete("{id}")]
    [ProducesResponseType(StatusCodes.Status200OK)]
    [ProducesResponseType(StatusCodes.Status400BadRequest)]
    public ActionResult<Employee> Delete(int id)
    {
        if (id <= 0)
        {
            return BadRequest("Invalid employee id");
        }

        var existingEmployee = Employees.FirstOrDefault(item => item.Id == id);
        if (existingEmployee is null)
        {
            return BadRequest("Invalid employee id");
        }

        Employees.Remove(existingEmployee);
        return Ok(existingEmployee);
    }

    private List<Employee> GetStandardEmployeeList()
    {
        return Employees;
    }
}