# Bookstore REST API

A comprehensive RESTful API for managing books and authors built with Spring Boot, featuring full CRUD operations, advanced filtering, pagination, and Swagger documentation.

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Postman (for API testing)

### Installation & Running

1. **Clone and build the project:**
```bash
git clone <repository-url>
cd bookstore-api
mvn clean install
```

2. **Run the application:**
```bash
mvn spring-boot:run
```

3. **Access the application:**
   - **API Base URL**: http://localhost:8282
   - **Swagger UI**: http://localhost:8282/swagger-ui.html
   - **H2 Database Console**: http://localhost:8282/h2-console
   - **API Documentation**: http://localhost:8282/api-docs

### H2 Database Console Credentials
- **JDBC URL**: `jdbc:h2:mem:bookstoredb`
- **Username**: `sa`
- **Password**: (leave empty)

## 📚 API Endpoints

### Authors Management

#### Get All Authors (Paginated)
- **GET** `http://localhost:8282/api/authors`
- **Query Parameters**: 
  - `page` (default: 0) - Page number
  - `size` (default: 10) - Page size
  - `sortBy` (default: name) - Field to sort by
  - `sortDir` (default: asc) - Sort direction (asc/desc)

#### Get Author by ID
- **GET** `http://localhost:8282/api/authors/{id}`

#### Create Author
- **POST** `http://localhost:8282/api/authors`
- **Body** (JSON):
```json
{
  "name": "Author Name",
  "email": "author@email.com",
  "bio": "Author biography",
  "nationality": "Country"
}
```

#### Update Author
- **PUT** `http://localhost:8282/api/authors/{id}`
- **Body**: Same as create

#### Delete Author
- **DELETE** `http://localhost:8282/api/authors/{id}`

#### Search Authors
- **GET** `http://localhost:8282/api/authors/search?name={name}`

#### Get Authors by Nationality
- **GET** `http://localhost:8282/api/authors/nationality/{nationality}`

### Books Management

#### Get All Books (with Filtering)
- **GET** `http://localhost:8282/api/books`
- **Query Parameters**:
  - `page`, `size`, `sortBy`, `sortDir` - Pagination and sorting
  - `title` - Filter by title (partial match)
  - `genre` - Filter by genre
  - `minPrice`, `maxPrice` - Price range filter

#### Get Book by ID
- **GET** `http://localhost:8282/api/books/{id}`

#### Create Book
- **POST** `http://localhost:8282/api/books?authorId={authorId}`
- **Body** (JSON):
```json
{
  "title": "Book Title",
  "isbn": "978-1234567890",
  "description": "Book description",
  "publicationYear": 2024,
  "price": 29.99,
  "genre": "Fiction",
  "pageCount": 300,
  "publisher": "Publisher Name"
}
```

#### Update Book
- **PUT** `http://localhost:8282/api/books/{id}`
- **Body**: Same as create

#### Delete Book
- **DELETE** `http://localhost:8282/api/books/{id}`

#### Get Books by Author
- **GET** `http://localhost:8282/api/books/author/{authorId}`

#### Search Books by Title
- **GET** `http://localhost:8282/api/books/search?title={title}`

#### Get Books by Genre
- **GET** `http://localhost:8282/api/books/genre/{genre}`

#### Get Books by Price Range
- **GET** `http://localhost:8282/api/books/price-range?minPrice={min}&maxPrice={max}`

## 🎯 Sample Data

The application comes pre-loaded with sample data:

### Sample Authors
- J.K. Rowling (British)
- George R.R. Martin (American)
- J.R.R. Tolkien (British)
- Agatha Christie (British)

### Sample Books
- Harry Potter and the Philosopher's Stone
- A Game of Thrones
- The Hobbit
- Murder on the Orient Express
- Harry Potter and the Chamber of Secrets
- A Clash of Kings

## 🔧 Testing with Postman

### Import Postman Collection
1. Open Postman
2. Click "Import"
3. Use the following collection structure:

### Postman Collection JSON
```json
{
  "info": {
    "name": "Bookstore API",
    "description": "REST API for managing books and authors",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Authors",
      "item": [
        {
          "name": "Get All Authors",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8282/api/authors?page=0&size=10&sortBy=name&sortDir=asc",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8282",
              "path": ["api", "authors"],
              "query": [
                {"key": "page", "value": "0"},
                {"key": "size", "value": "10"},
                {"key": "sortBy", "value": "name"},
                {"key": "sortDir", "value": "asc"}
              ]
            }
          }
        },
        {
          "name": "Get Author by ID",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8282/api/authors/1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8282",
              "path": ["api", "authors", "1"]
            }
          }
        },
        {
          "name": "Create Author",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"name\": \"Stephen King\",\n  \"email\": \"stephen.king@email.com\",\n  \"bio\": \"American author of horror novels\",\n  \"nationality\": \"American\"\n}"
            },
            "url": {
              "raw": "http://localhost:8282/api/authors",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8282",
              "path": ["api", "authors"]
            }
          }
        }
      ]
    },
    {
      "name": "Books",
      "item": [
        {
          "name": "Get All Books",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8282/api/books?page=0&size=10&sortBy=title&sortDir=asc",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8282",
              "path": ["api", "books"],
              "query": [
                {"key": "page", "value": "0"},
                {"key": "size", "value": "10"},
                {"key": "sortBy", "value": "title"},
                {"key": "sortDir", "value": "asc"}
              ]
            }
          }
        },
        {
          "name": "Create Book",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"title\": \"The Shining\",\n  \"isbn\": \"9780385121675\",\n  \"description\": \"A horror novel by Stephen King\",\n  \"publicationYear\": 1977,\n  \"price\": 18.99,\n  \"genre\": \"Horror\",\n  \"pageCount\": 447,\n  \"publisher\": \"Doubleday\"\n}"
            },
            "url": {
              "raw": "http://localhost:8282/api/books?authorId=1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8282",
              "path": ["api", "books"],
              "query": [
                {"key": "authorId", "value": "1"}
              ]
            }
          }
        }
      ]
    }
  ]
}
```

### Test Scenarios

1. **Basic CRUD Operations**:
   - Create a new author
   - Retrieve the author
   - Update author information
   - Delete the author

2. **Book Management**:
   - Create books for different authors
   - Filter books by genre, price, and title
   - Update book details
   - Search functionality

3. **Advanced Features**:
   - Pagination testing
   - Sorting by different fields
   - Combined filtering
   - Error handling scenarios

## 🛠️ Technical Features

### Backend Stack
- **Framework**: Spring Boot 3.1.0
- **Database**: H2 (in-memory)
- **ORM**: Spring Data JPA (Hibernate)
- **Validation**: Bean Validation 3.0
- **Documentation**: SpringDoc OpenAPI 3.0

### Key Features
- ✅ RESTful API design
- ✅ Full CRUD operations for books and authors
- ✅ Pagination and sorting
- ✅ Advanced filtering and search
- ✅ Input validation and error handling
- ✅ Swagger/OpenAPI documentation
- ✅ H2 in-memory database with console
- ✅ DTO pattern for data transfer
- ✅ Service layer abstraction
- ✅ Comprehensive testing examples

### Data Validation
- Required field validation
- Email format validation
- Price range validation
- ISBN uniqueness
- Publication year constraints
- String length limits

## 📊 Response Examples

### Success Responses
- **200 OK**: Successful retrieval
- **201 Created**: Resource created successfully
- **204 No Content**: Resource deleted successfully

### Error Responses
- **400 Bad Request**: Validation errors
- **404 Not Found**: Resource not found
- **409 Conflict**: Duplicate data (email, ISBN)
- **500 Internal Server Error**: Server errors

## 🔍 API Documentation

### Swagger UI
Access comprehensive API documentation at: 
**http://localhost:8282/swagger-ui.html**

The Swagger UI provides:
- Interactive API testing
- Request/response schemas
- Model definitions
- Try-it-out functionality
- Authentication details (if applicable)

### OpenAPI Specification
Raw OpenAPI specification available at:
**http://localhost:8282/api-docs**

## 🚦 Development

### Project Structure
```
src/main/java/com/bookstore/
├── BookstoreApiApplication.java
├── controller/
│   ├── AuthorController.java
│   └── BookController.java
├── model/
│   ├── Author.java
│   └── Book.java
├── repository/
│   ├── AuthorRepository.java
│   └── BookRepository.java
├── service/
│   ├── AuthorService.java
│   └── BookService.java
└── dto/
    ├── AuthorDTO.java
    └── BookDTO.java
```

### Building from Source
```bash
# Compile and package
mvn clean package

# Run tests
mvn test

# Run with specific profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🆘 Support

For support and questions:
- Check the API documentation at http://localhost:8282/swagger-ui.html
- Review the sample requests in this README
- Test endpoints using Postman collection
- Check application logs for detailed error information

---

**Happy Coding!** 🚀 Built with Spring Boot and ❤️
