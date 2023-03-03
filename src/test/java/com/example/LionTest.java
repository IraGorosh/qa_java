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
    public void getKittensReturnCorrectValueForMale() throws Exception {
        getKittensForTest("Самец");
    }

    @Test
    public void getKittensReturnCorrectValueForFemale() throws Exception {
        getKittensForTest("Самка");
    }

    @Test
    public void getFoodReturnCorrectValueForMale() throws Exception {
        getFoodForTest("Самец");
    }

    @Test
    public void getFoodReturnCorrectValueForFemale() throws Exception {
        getFoodForTest("Самка");
    }

    @Test
    public void lionSexReturnException() {
        var exception = assertThrows(Exception.class, () -> new Lion(feline, "Хищник"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    private void getKittensForTest(String sex) throws Exception {
        Lion lion = new Lion(feline, sex);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedGetKittens = 1;
        int actualGetKittens = lion.getKittens();
        assertEquals(expectedGetKittens, actualGetKittens);
    }

    private void getFoodForTest(String sex) throws Exception {
        Lion lion = new Lion(feline, sex);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedGetFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualGetFood = lion.getFood();
        assertEquals(expectedGetFood, actualGetFood);
    }
}