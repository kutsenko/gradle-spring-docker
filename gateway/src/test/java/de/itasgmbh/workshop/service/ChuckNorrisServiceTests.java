/*
 * Copyright (C) 2017 ITAS GmbH. All rights reserved.
 */
package de.itasgmbh.workshop.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnit44Runner;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author vkutsenko
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ChuckNorrisServiceTests {

	@Mock
	RestTemplate mockRestTemplate;
	ChuckNorrisService chuckNorrisService;
	static final String HEROE = "heroe";

	@Before
	public void setup() {
		chuckNorrisService = new ChuckNorrisService();
		chuckNorrisService.restTemplate = mockRestTemplate;
		when(mockRestTemplate.getForObject(anyString(), any())).thenReturn("Chuck Norris");
	}

	@Test
	public void testReplaceHeroeString() throws Exception {

		String heroe = chuckNorrisService.replaceHeroe(HEROE);
		assertEquals(HEROE, heroe);
	}

}
