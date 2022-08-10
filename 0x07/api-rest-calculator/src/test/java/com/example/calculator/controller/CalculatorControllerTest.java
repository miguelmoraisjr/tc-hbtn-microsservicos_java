package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Calculator calculator;

    public void setUp(){
        standaloneSetup(this.mvc);
    }

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {

        Mockito.when(this.calculator.sum(30.0, 25.0)).thenReturn(55.0);
        RequestBuilder request = get("/calculator/addNumbers").param("number1", "30.0").param("number2", "25.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("55.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {

        Mockito.when(this.calculator.sub(30.0, 25.0)).thenReturn(5.0);
        RequestBuilder request = get("/calculator/subNumbers").param("number1", "30.0").param("number2", "25.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("5.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {

        Mockito.when(this.calculator.divide(10.0, 2.0)).thenReturn(5.0);
        RequestBuilder request = get("/calculator/divideNumbers").param("number1", "10.0").param("number2", "2.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("5.0", result.getResponse().getContentAsString());
    }

    @Test
    void factiorial() throws Exception {

        Mockito.when(this.calculator.factorial(3)).thenReturn(6);
        RequestBuilder request = get("/calculator/factorial").param("factorial", "3");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("6", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 25);
        Mockito.when(this.calculator.calculeDayBetweenDate(date1, date2)).thenReturn(-10);
        RequestBuilder request = get("/calculator/calculeDayBetweenDate").param("localDate1", "2020-03-15").param("localDate2", "2020-03-25");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("-10", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {

        Mockito.when(this.calculator.integerToBinary(3)).thenReturn(11);
        RequestBuilder request = get("/calculator/integerToBinary").param("number1", "3");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("11", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {

        Mockito.when(this.calculator.integerToHexadecimal(13)).thenReturn("d");
        RequestBuilder request = get("/calculator/integerToHexadecimal").param("number1", "13");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("d", result.getResponse().getContentAsString());
    }
}