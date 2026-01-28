package kr.java.beanstalk.repository;

import kr.java.beanstalk.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
