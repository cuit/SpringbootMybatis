package com.example.SpringBootMybatis.mapper;

import com.example.SpringBootMybatis.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {

    Student findById(Integer id);
    int insert(Student student);
    List<Student> findAll();
    Student update(Student student);
}
