using Microsoft.EntityFrameworkCore;
using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Infrastructure
{
    public class Project1Context : DbContext
    {
        private DbContextOptions<Project1Context> _optionsBuilder;

        public DbSet<UserItem> Users { get; set; }

        public Project1Context(DbContextOptions<Project1Context> options)
            : base(options)
        {
            _optionsBuilder = options;
        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            //optionsBuilder.UseSqlServer(@"Server=.\;Database=Project1Demo;Trusted_Connection=True;MultipleActiveResultSets=true");
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<UserItem>(entity =>
            {
                entity.ToTable("User");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Name).HasMaxLength(50);
                entity.Property(e => e.Surname).HasMaxLength(50);
                entity.Property(e => e.Login).HasMaxLength(50).IsRequired();
                entity.Property(e => e.Password).HasMaxLength(50).IsRequired();
                entity.Property(e => e.Age);
                entity.Property(e => e.Email).HasMaxLength(50);
                entity.Property(e => e.Address).HasMaxLength(200);
                entity.Property(e => e.IsAdmin).HasDefaultValue(false);
                entity.HasMany(c => c.Products).WithOne(e => e.Owner).HasForeignKey(e => e.OwnerId).OnDelete(DeleteBehavior.SetNull);
             });

            modelBuilder.Entity<ProductItem>(entity =>
            {
                entity.ToTable("Product");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Name).HasMaxLength(200);
                entity.Property(e => e.Price);
                entity.Property(e => e.OwnerId);
            });
        }
    }
}
