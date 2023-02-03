package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.Login.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Insert("INSERT INTO Book(book_name, publisher) VALUES(#{book_name}, #{publisher})")
    void insertBookInfo(Book book);

    @Select("SELECT * FROM Book")
    List<Book> selectBookInfo();
}
