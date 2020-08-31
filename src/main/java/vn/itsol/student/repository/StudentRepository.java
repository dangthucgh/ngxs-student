package vn.itsol.student.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.itsol.student.entities.Student;

import java.awt.print.Pageable;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
