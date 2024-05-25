package org.program.preciousstonemanager.controllers;

import javafx.util.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.program.preciousstonemanager.models.PreciousStone;
import org.program.preciousstonemanager.models.SemiPreciousStone;
import org.program.preciousstonemanager.models.Stone;
import org.program.preciousstonemanager.models.Storage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NecklaceControllerTest {
    NecklaceController controller;
    List<Stone> necklace;

    @BeforeEach
    void setUp() {
        controller = new NecklaceController();
        necklace = new ArrayList<>();
        necklace.add(new PreciousStone("Ruby", "Red", 10, 1000, 80, true));
        necklace.add(new SemiPreciousStone("Amethyst", "Purple", 15, 500, 60, false));
        necklace.add(new PreciousStone("Diamond", "Clear", 5, 2000, 100, true));
        necklace.add(new SemiPreciousStone("Emerald", "Green", 20, 1500, 70, false));
        necklace.add(new PreciousStone("Sapphire", "Blue", 8, 1200, 90, true));
        Storage.setNecklace(necklace);
    }

    @Test
    void getNecklaceValueAndWeightTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int expectedValue = 6200;
        int expectedWeight = 58;
        Pair<Integer, Integer> result = (Pair<Integer, Integer>)getNecklaceValueAndWeight().invoke(controller);
        assertEquals(expectedValue, result.getKey());
        assertEquals(expectedWeight, result.getValue());
    }

    private Method getNecklaceValueAndWeight() throws NoSuchMethodException {
        Method method = NecklaceController.class.getDeclaredMethod("getNecklaceValueAndWeight");
        method.setAccessible(true);
        return method;
    }
}