using EFCoreRetailStore.Data;
using EFCoreRetailStore.Models;
using Microsoft.EntityFrameworkCore;

await using var context = new AppDbContext();

await EnsureSeedDataAsync(context);
await ShowAllProductsAsync(context);
await ShowProductByIdAsync(context, 1);
await ShowExpensiveProductAsync(context);

static async Task EnsureSeedDataAsync(AppDbContext context)
{
    if (await context.Categories.AnyAsync())
    {
        return;
    }

    var electronics = new Category { Name = "Electronics" };
    var groceries = new Category { Name = "Groceries" };

    await context.Categories.AddRangeAsync(electronics, groceries);
    await context.SaveChangesAsync();

    var product1 = new Product
    {
        Name = "Laptop",
        Price = 75000,
        CategoryId = electronics.Id
    };

    var product2 = new Product
    {
        Name = "Rice Bag",
        Price = 1200,
        CategoryId = groceries.Id
    };

    await context.Products.AddRangeAsync(product1, product2);
    await context.SaveChangesAsync();
}

static async Task ShowAllProductsAsync(AppDbContext context)
{
    var products = await context.Products
        .Include(product => product.Category)
        .ToListAsync();

    Console.WriteLine("All Products:");

    foreach (var product in products)
    {
        Console.WriteLine($"{product.Name} - {product.Price} ({product.Category.Name})");
    }
}

static async Task ShowProductByIdAsync(AppDbContext context, int productId)
{
    var product = await context.Products.FindAsync(productId);

    Console.WriteLine(product is null
        ? $"Product {productId} not found"
        : $"Found: {product.Name}");
}

static async Task ShowExpensiveProductAsync(AppDbContext context)
{
    var expensiveProduct = await context.Products
        .FirstOrDefaultAsync(product => product.Price > 5000);

    Console.WriteLine(expensiveProduct is null
        ? "No expensive product found"
        : $"Expensive: {expensiveProduct.Name}");
}