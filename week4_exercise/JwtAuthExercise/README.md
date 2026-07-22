JWT Authentication example in ASP.NET Core (for faculty submission)

Project: JwtAuthExercise

Files created:
- JwtAuthExercise.csproj
- Program.cs
- appsettings.json
- Controllers/AuthController.cs
- Models/LoginModel.cs

Notes:
- Authentication is configured with JWT Bearer in `Program.cs`.
- Use POST `api/auth/login` with JSON { "username":"testuser","password":"P@ssw0rd" } to receive a token.
- This project is a code sample and uses hard-coded user validation for demonstration only.
