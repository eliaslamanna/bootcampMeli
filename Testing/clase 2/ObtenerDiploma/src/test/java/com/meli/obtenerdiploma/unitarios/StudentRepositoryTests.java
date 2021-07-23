package com.meli.obtenerdiploma.unitarios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

@SpringBootTest
public class StudentRepositoryTests {

    private static IStudentRepository studentRepository;

    private static IStudentDAO studentDAO;

    private static Set<StudentDTO> backUp;

    @BeforeAll
    static void initLoad()
    {
        studentDAO = new StudentDAO();
        studentRepository = new StudentRepository();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/main/resources/users.json");
            backUp = objectMapper.readValue(file, new TypeReference<>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }
    }

    @AfterAll
    static void clear()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/main/resources/users.json");
            objectMapper.writeValue(file, backUp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }


        studentDAO = null;
        studentRepository = null;
        backUp = null;

    }

    @Test
    public void findAllStudents() {
        //Assert
        Assertions.assertDoesNotThrow(()->studentRepository.findAll());
    }
}
