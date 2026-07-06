# EF Core 8.0 Retail Store Lab

This console app covers the core implementation for Lab 1 through Lab 5.

## Lab 1

Setup items included in this project:

- EF Core SQL Server package reference
- EF Core Design package reference
- EF Core Tools package reference
- Console app target framework set to .NET 8.0

## Lab 2

Implemented in `Data/AppDbContext.cs` and the model classes under `Models/`.

## Lab 3

Use these commands after the .NET SDK is installed:

```bash
dotnet tool install --global dotnet-ef
dotnet ef migrations add InitialCreate
dotnet ef database update
```

## Lab 4

Initial data seeding is handled in `Program.cs` with `AddRangeAsync` and `SaveChangesAsync`.

## Lab 5

Retrieval examples are handled in `Program.cs` using:

- `ToListAsync`
- `FindAsync`
- `FirstOrDefaultAsync`

## Notes

- Update the connection string in `Data/AppDbContext.cs` before running against SQL Server.
- If you want to switch to `appsettings.json`, wire configuration into `AppDbContext` or a host builder first.