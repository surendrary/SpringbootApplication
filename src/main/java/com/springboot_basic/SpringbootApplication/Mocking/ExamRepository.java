package com.springboot_basic.SpringbootApplication.Mocking;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {

    //...

    int[] getMarks() {
        //fetch and return data
        return new int[]{};
    }
}
