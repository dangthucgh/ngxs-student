package vn.itsol.student.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @Column(name= "id")
    private int id;

    @Column(name = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Ho_Chi_Minh")
    private Date birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @Column(name = "clas")
    private String clas;
}
