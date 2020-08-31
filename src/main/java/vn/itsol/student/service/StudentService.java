package vn.itsol.student.service;

import org.springframework.data.domain.Page;
import vn.itsol.student.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Page<Student> findAll(int pageNo);
    Student save(Student student);
    void update(Student student);
    void delete( int id);
    Optional<Student> findOne(int id);
    Page< Student > findPaginated(int pageNo, int pageSize);

}
