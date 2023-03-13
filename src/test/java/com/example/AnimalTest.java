package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    @Test
    public void getFoodReturnCorrectException() {
        Animal animal = new Animal();
        var exception = assertThrows(Exception.class, () -> animal.getFood("Насекомые"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void getFamilyReturnCorrectMessage() {
        Animal animal = new Animal();
        String expectedGetFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualGetFamily = animal.getFamily();
        assertEquals(expectedGetFamily, actualGetFamily);
    }
}
