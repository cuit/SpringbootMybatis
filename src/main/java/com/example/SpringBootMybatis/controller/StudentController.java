package com.example.SpringBootMybatis.controller;

import com.example.SpringBootMybatis.model.Student;
import com.example.SpringBootMybatis.service.StudentService;
import com.example.SpringBootMybatis.util.Result;
import com.example.SpringBootMybatis.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/api")
    public Result<List<Student>> findAll(){
        List<Student> students = studentService.findAll();
        logger.info("打印出：{}", students);
        if (CollectionUtils.isEmpty(students)){
            return ResultUtil.fail(400, "没有记录", null);
        }
        return ResultUtil.success(200, "操作成功！", students);
    }

    @GetMapping(value = "/api/{id}")
    public Result<Student> findOne(@PathVariable(value = "id") Integer id){
        Student student = studentService.findById(id);
        logger.info("通过id取得student：{}", student);
        if (null != student) {
            return ResultUtil.success(200, "操作成功！", student);
        }
        return ResultUtil.fail("传值有误");
    }

    @PostMapping(value = "/api/add")
    public Result<Integer> insert(Student student){
        int result = studentService.insert(student);
        if (result > 0) {
            return ResultUtil.success(200, "操作成功！", studentService.insert(student));
        }
        return ResultUtil.fail("新增失败");
    }

    @RequestMapping(value = "/api/update", method = RequestMethod.POST)
    public Result<Student> update(Student student){
        Student result = studentService.update(student);
        logger.info("更新数据库：", result);
        if (null != result){
            return ResultUtil.success(200, "修改成功");
        }
        return ResultUtil.fail("修改失败");
    }
}
