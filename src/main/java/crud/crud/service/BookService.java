package crud.crud.service;


import crud.crud.dto.BookDTO;
import crud.crud.entity.Books;
import crud.crud.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;

    public List<Books> getAll() {
        return bookRepository.findAll();
    }

    public Books getOne(String id){
        Optional<Books> book = bookRepository.findById(id);
        return book.get();
    }

    public Books saveBook(BookDTO book){
        ModelMapper bookMapper = new ModelMapper();
        Books save = bookMapper.map(book, Books.class);
        return bookRepository.save(save);
    }

    public Books updateBook(BookDTO book){
        ModelMapper update = new ModelMapper();
        Books updateData = update.map(book, Books.class);
        return bookRepository.save(updateData);
    }

    public String deleteBook(String id) {
        bookRepository.deleteById(id);
        return id;
    }
}
