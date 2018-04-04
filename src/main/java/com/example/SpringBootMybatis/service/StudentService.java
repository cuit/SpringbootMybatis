package com.example.SpringBootMybatis.service;

import com.example.SpringBootMybatis.mapper.StudentMapper;
import com.example.SpringBootMybatis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public int insert(Student student){
        return studentMapper.insert(student);
    }

    public List<Student> findAll(){
        List<Student> students = studentMapper.findAll();
        return students;
    }

    public Student findById(Integer id){
        return studentMapper.findById(id);
    }

    public Student update(Student student){
        return studentMapper.update(student);
    }
}
