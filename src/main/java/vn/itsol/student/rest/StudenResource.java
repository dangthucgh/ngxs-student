package vn.itsol.student.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.itsol.student.entities.Student;
import vn.itsol.student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudenResource {
    @Autowired
    private StudentService studentService;

    @GetMapping("/pages/{pageNo}")
    public Page<Student> findAll(@PathVariable int pageNo) {
        return studentService.findAll(pageNo);
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody Student student) {
        studentService.update(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findOne(@PathVariable int id) {
        return studentService.findOne(id).map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page< Student > page = studentService.findPaginated(pageNo, pageSize);
        List < Student > listStudents = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listStudents", listStudents);
        return "index";
    }
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, model);
    }
}
