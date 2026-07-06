# ASP.NET Core 8.0 Web API

This folder contains the starter Web API for the first task.

## What is included

- Controller-based ASP.NET Core 8 Web API project file
- `ValuesController` with `HttpGet`, `HttpPost`, `HttpPut`, and `HttpDelete`
- Swagger enabled for development
- Standard launch settings
- Custom employee model/controller with action filters
- Custom authorization filter that checks the `Authorization` header for `Bearer`
- Custom exception filter that logs exceptions to a file and returns a 500 result
- Employee CRUD actions with hardcoded in-memory data and `FromBody` input for create/update

## Main endpoint

- `GET /api/values`
- `GET /api/employee`
- `GET /api/employee/error`
- `POST /api/employee`
- `PUT /api/employee/{id}`
- `DELETE /api/employee/{id}`

## Notes

- The machine used for this task does not have the .NET SDK installed, so I could not run the project here.
- Once you open this folder in Visual Studio or VS Code with .NET 8 installed, run the project and verify the GET action returns the sample values.
- Send an `Authorization` header with `Bearer <token>` when calling the Employee controller, otherwise the custom auth filter returns a bad request.