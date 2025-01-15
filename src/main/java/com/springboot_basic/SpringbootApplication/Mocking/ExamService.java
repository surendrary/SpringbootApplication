package com.springboot_basic.SpringbootApplication.Mocking;

import org.springframework.beans.factory.annotation.Autowired;
import com.springboot_basic.SpringbootApplication.Mocking.ExamRepository;
import org.springframework.stereotype.Service;

@Service
public class ExamService {


    ExamRepository examRepository;

    ExamService(ExamRepository examRepository) {
        super();
        this.examRepository = examRepository;
    }

    public  int getTotal(){
        int[] array = examRepository.getMarks();
        int sum = 0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        return sum;
    }


}
