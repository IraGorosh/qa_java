package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittensReturnCorrectValue() {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedGetKittens = 1;
        int actualGetKittens = lion.getKittens();
        assertEquals(expectedGetKittens, actualGetKittens);
    }

    @Test
    public void getFoodReturnCorrectValue() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedGetFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualGetFood = lion.getFood();
        assertEquals(expectedGetFood, actualGetFood);
    }

    @Test
    public void lionSexReturnException() {
        var exception = assertThrows(Exception.class, () -> new Lion("Хищник"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}