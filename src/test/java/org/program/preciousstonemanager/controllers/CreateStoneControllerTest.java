package org.program.preciousstonemanager.controllers;

import org.junit.jupiter.api.Test;
import org.program.preciousstonemanager.models.PreciousStone;
import org.program.preciousstonemanager.models.SemiPreciousStone;
import org.program.preciousstonemanager.models.Stone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateStoneControllerTest {

    @Test
    void createStone() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CreateStoneController controller = new CreateStoneController();

        Method method = getCreateNewStoneMethod();
        method.setAccessible(true);

        Stone expectedPreciousStone = new PreciousStone("test", "test", 0, 0, 0, false);
        Stone actualPreciousStone = (Stone) method.invoke(controller, "test", "test", 0, 0, 0, false, true);
        assertTrue(equals(expectedPreciousStone, actualPreciousStone));

        Stone expectedSemiPreciousStone = new SemiPreciousStone("test", "test", 0, 0, 0, false);
        Stone actualSemiPreciousStone = (Stone) method.invoke(controller, "test", "test", 0, 0, 0, false, false);
        assertTrue(equals(expectedSemiPreciousStone, actualSemiPreciousStone));
    }

    private Method getCreateNewStoneMethod() throws NoSuchMethodException {
        return CreateStoneController.class.getDeclaredMethod("createNewStone",
                String.class, String.class, int.class, int.class, int.class, boolean.class, boolean.class);
    }

    public boolean equals(Stone left, Stone right) {
        return Objects.equals(left.getName(), right.getName()) &&
                Objects.equals(left.getColor(), right.getColor()) &&
                Objects.equals(left.getType(), right.getType()) &&
                left.getWeight() == right.getWeight() &&
                left.getValue() == right.getValue() &&
                left.getTransparency() == right.getTransparency() &&
                left.getIsInNecklace() == right.getIsInNecklace();
    }
}