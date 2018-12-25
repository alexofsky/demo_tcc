package com.blbuyer.erp.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blbuyer.core.response.DataResponse;
import com.blbuyer.erp.BasicServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BasicServiceApplication.class)
public class SampleOrderServiceTest {

	@Autowired
	SampleOrderService sampleOrderService;

	@Test
	public void add() {}


}
