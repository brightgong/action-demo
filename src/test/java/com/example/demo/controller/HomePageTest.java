package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Bright Gong
 */
@WebMvcTest(HomePage.class)
@AutoConfigureMockMvc
public class HomePageTest extends AbstractTestNGSpringContextTests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testHello() throws Exception {
    this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(equalTo("Hello, world!")));
  }

  @Test
  public void testHelloWithParam() throws Exception {
    this.mockMvc.perform(get("/Bright")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(equalTo("Hello, Bright")));
  }
}