package crud.crud.controller;


import crud.crud.dto.BookDTO;
import crud.crud.entity.Books;
import crud.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/books/")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Books>> getBooks(){
        List<Books> listBook = bookService.getAll();
        return ResponseEntity.ok(listBook);
    }

    @GetMapping("{id}")
    public ResponseEntity<Books> getBookById(@PathVariable("id") String id){
        System.out.println("id del books aqui => " + id);
        return  ResponseEntity.ok(bookService.getOne(id));
    }

    @PostMapping("")
    public ResponseEntity<Books> createBook(@RequestBody BookDTO book){
        System.out.println(book.toString());
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @PutMapping("{id}")
    public ResponseEntity<Books> updateBook(@RequestBody BookDTO book, @PathVariable("id") String id){
        System.out.println("Update book");
        System.out.println(book.toString());
        System.out.println(id);
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") String id) {
        System.out.println("Delete book for id");
        System.out.println(id);
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}
