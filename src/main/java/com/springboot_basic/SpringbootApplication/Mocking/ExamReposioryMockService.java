package com.springboot_basic.SpringbootApplication.Mocking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ExamReposioryMockService {


    @Test
    public void testgetTotal() {

        ExamRepository examRepoMock = mock(ExamRepository.class);
        when(examRepoMock.getMarks()).thenReturn(new int []{4,5,6});

        ExamService service = new ExamService(examRepoMock);
        int total = service.getTotal();
        System.out.println(total);
        assertEquals(15, total);



    }

}
