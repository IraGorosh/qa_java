package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void eatMeatReturnCorrectValue() throws Exception {
        Feline feline = new Feline();
        List<String> expectedMeatReturn = List.of("Животные", "Птицы", "Рыба");
        List<String> actualMeatReturn = feline.eatMeat();
        assertEquals(expectedMeatReturn, actualMeatReturn);
    }

    @Test
    public void getFamilyReturnCorrectValue() {
        Feline feline = new Feline();
        String expectedGetFamily = "Кошачьи";
        String actualGetFamily = feline.getFamily();
        assertEquals(expectedGetFamily, actualGetFamily);
    }

    @Spy
    private Feline feline = new Feline();

    @Test
    public void getKittensReturnCorrectValue() {
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        int expectedGetKittens = 1;
        int actualGetKittens = feline.getKittens();
        assertEquals(expectedGetKittens, actualGetKittens);
    }

    @Test
    public void getKittensReturnCorrectKittensCountValue() {
        Feline feline = new Feline();
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens(expectedKittensCount);
        assertEquals(expectedKittensCount, actualKittensCount);
    }
}
