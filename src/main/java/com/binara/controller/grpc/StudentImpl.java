package com.binara.controller.grpc;

import com.binara.model.Student;
import com.binara.service.UserService;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by binara on 7/2/17.
 */
public class StudentImpl extends StudentGrpc.StudentImplBase {

    @Autowired
    UserService userService;

    private final ArrayList<Student> students = new ArrayList<Student>(){
        {
            add(new Student(1, "Vindana", 36));
            add(new Student(2, "Sithum", 33));
            add(new Student(3, "Binara", 27));
        }
    };

    @Override
    public void getStudent(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        Student student = students.get(request.getId());
        StudentResponse response = StudentResponse.newBuilder()
                .setId(student.getId())
                .setName("" + userService.findById(2))
                .setAge(student.getAge())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
