package az.edu.ada.librarySystem.service;

import az.edu.ada.librarySystem.entity.Book;
import az.edu.ada.librarySystem.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Captor
    private ArgumentCaptor<Book> bookCaptor;

    private Book exampleBook;

    @BeforeEach
    void setUp() {
        exampleBook = new Book();
        exampleBook.setId(1);
        exampleBook.setName("for_testing_purposes");
        exampleBook.setAuthor("POM");
        exampleBook.setLocation("L");
    }

    @Test
    @DisplayName("Create or Update a Book successfully")
    void testSaveBook() {
        // Act - Call the save method with the exampleBook
        bookService.save(exampleBook);

        // Assert - Verify that save was called on the repository with the correct book
        verify(bookRepository).save(bookCaptor.capture());
        Book capturedBook = bookCaptor.getValue();

        assertEquals("for_testing_purposes", capturedBook.getName());
        assertEquals("POM", capturedBook.getAuthor());
        assertEquals("L", capturedBook.getLocation());
    }

    @Test
    @DisplayName("Retrieve a Book by ID")
    void testGetBookById() {
        // Arrange - Stub the findById method to return our exampleBook
        when(bookRepository.findById(exampleBook.getId())).thenReturn(Optional.of(exampleBook));

        // Act - Attempt to retrieve the book by ID
        Book retrievedBook = bookService.getBookById(exampleBook.getId());

        // Assert - Verify the book was retrieved successfully and matches the exampleBook
        assertNotNull(retrievedBook);
        assertEquals(exampleBook.getId(), retrievedBook.getId());
        assertEquals(exampleBook.getName(), retrievedBook.getName());
    }
}
