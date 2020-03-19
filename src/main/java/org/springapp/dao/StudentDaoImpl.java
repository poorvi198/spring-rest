package org.springapp.dao;

import org.springapp.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImpl implements StudentDao {

    private Map<Integer,Student> studentMap;
    public StudentDaoImpl() {
        studentMap = new HashMap<>();
    }

    @Override
    public Student save(Student student) {
        studentMap.put(student.getId(),student);
        return student;
    }

    @Override
    public Student get(int id) {
        for (Map.Entry<Integer,Student> entry: studentMap.entrySet()) {
            if(entry.getKey()==id)
            {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        studentMap.remove(id);
    }

    @Override
    public Student updateName(Student student) {
        for (Map.Entry<Integer,Student> entry: studentMap.entrySet()) {
            if(entry.getKey()==student.getId())
            {
                studentMap.put(student.getId(),student);
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        for (Map.Entry<Integer,Student> entry: studentMap.entrySet()) {
            studentList.add(entry.getValue());
        }
        return studentList;
    }
}
