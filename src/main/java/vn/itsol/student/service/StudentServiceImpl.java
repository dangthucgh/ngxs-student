package vn.itsol.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import vn.itsol.student.entities.Student;
import vn.itsol.student.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Page<Student> findAll(int pageNo) {
        return studentRepository.findAll(PageRequest.of(pageNo, 5));
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);

    }

    @Override
    public Optional<Student> findOne(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Page<Student> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.studentRepository.findAll(pageable);
    }
}
