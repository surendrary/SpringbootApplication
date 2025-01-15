package com.springboot_basic.SpringbootApplication.Mocking;

import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamReposioryAnnotationMockService {
    @Mock
    public ExamRepository examRepoMock;

    @InjectMocks
    public ExamService examService;

    @Test
    public void testfindTotal() {
        when(examRepoMock.getMarks()).thenReturn(new int[] {15, 20, 5});
        Assert.assertEquals(40, examService.getTotal());
    }



}
