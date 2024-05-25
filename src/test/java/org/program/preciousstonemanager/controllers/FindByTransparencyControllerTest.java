package org.program.preciousstonemanager.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.program.preciousstonemanager.models.PreciousStone;
import org.program.preciousstonemanager.models.SemiPreciousStone;
import org.program.preciousstonemanager.models.Stone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class FindByTransparencyControllerTest {
    private FindByTransparencyController controller;
    private List<Stone> storage;

    @BeforeEach
    void setUp() {
        controller = new FindByTransparencyController();
        storage = new ArrayList<>();
        storage.add(new PreciousStone("Ruby", "Red", 10, 1000, 80, true));
        storage.add(new SemiPreciousStone("Amethyst", "Purple", 15, 500, 60, false));
        storage.add(new PreciousStone("Diamond", "Clear", 5, 2000, 100, true));
        storage.add(new SemiPreciousStone("Emerald", "Green", 20, 1500, 70, false));
        storage.add(new PreciousStone("Sapphire", "Blue", 8, 1200, 90, true));
    }

    @Test
    void testFindStonesWithinRange() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Stone> result = (List<Stone>) getFindStones().invoke(controller, storage, 60, 90);
        assertEquals(4, result.size());
        assertEquals("Ruby", result.get(0).getName());
        assertEquals("Amethyst", result.get(1).getName());
        assertEquals("Emerald", result.get(2).getName());
        assertEquals("Sapphire", result.get(3).getName());
    }

    @Test
    void testFindStonesOutsideRange() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Stone> result = (List<Stone>) getFindStones().invoke(controller, storage, 30, 50);
        assertEquals(0, result.size());
    }

    @Test
    void testFindStonesEmptyStorage() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Stone> result = (List<Stone>) getFindStones().invoke(controller, new ArrayList<>(), 60, 90);
        assertEquals(0, result.size());
    }

    @Test
    void testFindStonesNoMatches() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Stone> result = (List<Stone>) getFindStones().invoke(controller, storage, 101, 200);
        assertEquals(0, result.size());
    }

    @Test
    void testFindStonesAllMatches() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Stone> result = (List<Stone>) getFindStones().invoke(controller, storage, 0, 100);
        assertEquals(5, result.size());
    }

    private Method getFindStones() throws NoSuchMethodException {
        Method method = FindByTransparencyController.class.getDeclaredMethod("findStones",
                List.class, int.class, int.class);
        method.setAccessible(true);
        return method;
    }
}