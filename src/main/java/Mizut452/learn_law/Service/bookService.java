package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.BookMapper;
import Mizut452.learn_law.Model.Entity.Login.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class bookService {
    @Autowired
    BookMapper bookMapper;

    public void insertBookService(Book book) {
        bookMapper.insertBookInfo(book);
    }

    public void selectBookService(Model model) {
        List<Book> bookList = bookMapper.selectBookInfo();
        model.addAttribute("BookList", bookList);

    }
}
