<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

# Test Automation <img src="https://github.com/ADA-GWU/2024-a1-db-migration-FaridM5/assets/67589966/8509678a-db28-4984-938e-8aad64d00953" width="45">

<i class="fa fa-bookmark" style="font-size:13px"></i> This repository contains programs written in:

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

<h4><i class="fa fa-bookmark" style="font-size:13px"></i> What applications required from the system:</h3>
<ul>
<li>Latest version Java (21)</i></li>
<li>PostgreSql <i>(recommended to have latest)</i></li>
</ul>

</ul>

![Static Badge](https://img.shields.io/badge/build-Java-orange?style=flat&logo=Gradle&label=gradle)

<h3><i class="fa fa-bookmark" style="font-size:13px"></i> Tests:</h3>

**Test files Nemes:** <i>AddBookTest</i> and <i>BookServiceTest</i>

<i class="fa fa-book" style="font-size:13px"></i>
What <i>AddBookTest</i> does?:
- **Description:** The test class `AddBookTest` in the package `az.edu.ada.librarySystem.selenium` is designed to automate a series of web interactions on a library management system using Selenium WebDriver. The class is annotated with `@TestMethodOrder(MethodOrderer.OrderAnnotation.class)`, which indicates that the test methods within the class will be executed in the order specified by the `@Order` annotation on each test method. Before any tests are run, the `setUp` method initializes the Selenium `WebDriver` and `WebDriverWait` instances. This setup method is marked with `@BeforeAll`, indicating it runs once before all the test methods in the class. In the provided setup, ChromeDriver is initialized directly with a system property specifying the path to the `chromedriver.exe`, suggesting the tests are intended to be run in a local development environment rather than a headless CI/CD environment. This could be modified to run in a headless mode for CI/CD integration by uncommenting the commented-out headless configuration and ensuring compatibility with the execution environment. The class contains three test methods, each performing different actions: `testAddBook`: This test navigates to the "add book" page of the application, fills out a form with the details for a new book ("for_testing_purposes", "POM", location "L"), and submits it. It uses `WebDriverWait` to wait for elements to become clickable and uses `Thread.sleep` to wait for page loads and redirects, although it's noted that using `WebDriverWait` would be a better practice for such waits. `testVerifyBookAdded`: After adding a new book, this test navigates to the "books" page to verify that the newly added book is listed. It checks the page source for the presence of the book's name as confirmation that the book has been successfully added. `testDeleteBook`: This test also navigates to the "books" page, finds the table row (`<tr>`) containing the added book by its name, and clicks the delete icon (`<a>` element with id `deleteicon`) associated with that book. After deletion, it refreshes the page and verifies that the book's name no longer appears in the page source, confirming the book has been successfully deleted. Finally, the `tearDown` method marked with `@AfterAll` ensures that the WebDriver instance is properly closed after all tests have run, cleaning up the test environment.

<br>

<i class="fa fa-book" style="font-size:13px"></i>
What <i>BookServiceTest</i> does?:
- **Description:** The test class `BookServiceTest` within the package `az.edu.ada.librarySystem.service` is a suite designed to test the functionality of the `BookService` class, focusing on the operations of creating/updating and retrieving a book. It employs Mockito to mock the `BookRepository` dependency, allowing for isolation of the service layer from the actual data layer, thus facilitating unit testing without the need for an actual database connection. The class is annotated with `@ExtendWith(MockitoExtension.class)`, which integrates Mockito into the JUnit 5 testing lifecycle, enabling annotations like `@Mock`, `@InjectMocks`, and `@Captor` to be processed. This setup prepares the test environment for dependency injection and capturing arguments passed to mocked methods. In the `setUp` method, annotated with `@BeforeEach`, an instance of `Book` (named `exampleBook`) is instantiated and populated with sample data. This method runs before each test, ensuring that a fresh instance of the `Book` object is available for every test case to eliminate side effects between tests. The first test, `testSaveBook`, verifies the `save` operation of the `BookService`. It uses the `@Captor` to capture the `Book` object passed to the `bookRepository.save` method. The test asserts that the `save` method is indeed called with a `Book` object matching the expected values, effectively ensuring that the `BookService` is correctly delegating the save operation to the repository along with the correct book data. The second test, `testGetBookById`, focuses on the retrieval functionality. It stubs the `bookRepository.findById` method to return an `Optional` of `exampleBook` when queried with a specific ID. This arrangement simulates the behavior of the repository layer, allowing the test to verify whether the `BookService` can successfully retrieve a book by its ID and whether the retrieved book matches the expected data. Overall, `BookServiceTest` provides a concise demonstration of how to test service-layer logic in isolation using Mockito for mocking dependencies and capturing arguments. It ensures that the `BookService` behaves as expected for the critical operations of saving and retrieving books, contributing to the robustness and reliability of the application's service layer.

