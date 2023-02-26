package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void getSoundReturnCorrectValue() {
        Cat cat = new Cat(feline);
        String expectedGetSound = "Мяу";
        String actualGetSound = cat.getSound();
        assertEquals(expectedGetSound, actualGetSound);
    }

    @Test
    public void getFoodReturnCorrectValue() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedGetFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualGetFood = cat.getFood();
        assertEquals(expectedGetFood, actualGetFood);
    }
}
