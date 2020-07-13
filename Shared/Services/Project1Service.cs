using Newtonsoft.Json;
using Project2.IServices;
using Shared.Model;
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;

namespace Shared.Services
{
    public class Project1Service : IProject1Service
    {
        private readonly HttpClient _httpClient;
        public string TOKEN { get; private set; }
    
        public Project1Service(HttpClient httpClient)
        {
            _httpClient = httpClient;
        }

        public Project1Service(HttpClient httpClient, string token)
        {
            _httpClient = httpClient;
            TOKEN = token;
        }

        public async Task<UserItem> CreateUserAsync(UserItem user)
        {
            string url = "/api/v1/user/create";

            var dataAsString = JsonConvert.SerializeObject(user);
            var content = new StringContent(dataAsString);
            content.Headers.ContentType = new MediaTypeHeaderValue("application/json");

            var response = await _httpClient.PostAsync(url, content);
            response.EnsureSuccessStatusCode();
            var result = await response.Content.ReadAsStringAsync();

            var catalog = JsonConvert.DeserializeObject<UserItem>(result);
            return catalog;
        }

        public async Task<List<UserItem>> GetUsersAsync()
        {
            string url = "/api/v1/user/getusers";

            SetAuthHeader(_httpClient, TOKEN);
            var response = await _httpClient.GetAsync(url);
            response.EnsureSuccessStatusCode();
            var result = await response.Content.ReadAsStringAsync();

            var catalog = JsonConvert.DeserializeObject<List<UserItem>>(result);
            return catalog;
        }

        public async Task<int> GetCountUsersAsync()
        {
            string url = "/api/v1/user/getcountusers";

            var response = await _httpClient.GetAsync(url);
            response.EnsureSuccessStatusCode();
            var result = await response.Content.ReadAsStringAsync();

            var count = JsonConvert.DeserializeObject<int>(result);
            return count;
        }

        public async Task<List<UserItem>> CreateSeedUserAsync(int randomUser)
        {
            int count = await GetCountUsersAsync();
            if (count > 0)
                return new List<UserItem>();

            ConcurrentBag<UserItem> resultUsers = new ConcurrentBag<UserItem>();

            UserItem user = new UserItem()
            {
                Email = "email@email.it",
                IsAdmin = true,
                Login = "admin",
                Password = "password",
                Name = "Administrator",
                Surname = "Root"
            };
            var userResult = await CreateUserAsync(user);
            resultUsers.Add(userResult);

            List<Task<UserItem>> tasks = new List<Task<UserItem>>();
            for (int i = 0; i < randomUser; i++)
            {
                user = new UserItem()
                {
                    Address = "Address " + i,
                    Age = 20 + i,
                    Email = "email" + i + "@email.it",
                    IsAdmin = i == 0 ? true : false,
                    Login = "login" + i,
                    Password = "password" + i,
                    Name = "Name " + i,
                    Surname = "Surname " + i
                };

                tasks.Add(CreateUserAsync(user));
            }

            foreach (var task in tasks)
            {
                resultUsers.Add(await task);
            }

            return resultUsers.ToList();
        }

        public async Task<UserItem> GetUserByLogin(string login, string password)
        {
            string url = "/api/v1/user/getuserbylogin";

            dynamic loginData = new ExpandoObject();
            loginData.Login = login;
            loginData.Password = password;
            var dataAsString = JsonConvert.SerializeObject(loginData);
            var content = new StringContent(dataAsString, Encoding.UTF8, "application/json");
            content.Headers.ContentType = new MediaTypeHeaderValue("application/json");
          
            var response = await _httpClient.PostAsync(url, content);
            response.EnsureSuccessStatusCode();
            var result = await response.Content.ReadAsStringAsync();

            var catalog = JsonConvert.DeserializeObject<UserItem>(result);
            return catalog;
        }

        public async Task<(UserItem, string token)> GetUserAndTokenByLogin(string login, string password)
        {
            string token = string.Empty;
            string url = "/api/v1/user/getuserbylogin";

            token = await GetToken(login, password);

            dynamic loginData = new ExpandoObject();
            loginData.Login = login;
            loginData.Password = password;
            var dataAsString = JsonConvert.SerializeObject(loginData);
            var content = new StringContent(dataAsString, Encoding.UTF8, "application/json");
            content.Headers.ContentType = new MediaTypeHeaderValue("application/json");

            var response = await _httpClient.PostAsync(url, content);
            response.EnsureSuccessStatusCode();
            var result = await response.Content.ReadAsStringAsync();

            var user = JsonConvert.DeserializeObject<UserItem>(result);
            return (user, token);
        }

        private void SetAuthHeader(HttpClient client, string token)
        {
            var headers = client.DefaultRequestHeaders;
            if(!headers.Contains("Authorization"))
                headers.Add("Authorization", "Bearer " + token);
        }

        public async Task<List<UserItem>> SeedUsers(int randomUser)
        {
            string url = "/api/v1/seed/seed";

            dynamic data = new ExpandoObject();
            data.randomUser = randomUser;

            var dataAsString = JsonConvert.SerializeObject(data);
            var content = new StringContent(dataAsString);
            content.Headers.ContentType = new MediaTypeHeaderValue("application/json");

            var response = await _httpClient.PostAsync(url, content);
            response.EnsureSuccessStatusCode();
            var result = await response.Content.ReadAsStringAsync();

            var catalog = JsonConvert.DeserializeObject<List<UserItem>>(result);
            return catalog;
        }

        public async Task<string> GetToken(string login, string password)
        {
            string url = "/api/v1/token/";

            dynamic loginData = new ExpandoObject();
            loginData.Login = login;
            loginData.Password = password;
            var dataAsString = JsonConvert.SerializeObject(loginData);
            var content = new StringContent(dataAsString, Encoding.UTF8, "application/json");
            content.Headers.ContentType = new MediaTypeHeaderValue("application/json");

            var response = await _httpClient.PostAsync(url, content);
            if (response.StatusCode == System.Net.HttpStatusCode.BadRequest)
                throw new Exception("Credenzali non valide");
            response.EnsureSuccessStatusCode();
            var result = await response.Content.ReadAsStringAsync();
            
            return result;
        }
    }
}
