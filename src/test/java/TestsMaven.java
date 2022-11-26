import org.example.Fraction;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class TestsMaven {


    @Test
    public void testPrivateConstructors() {
        final Constructor<?>[] constructors = Fraction.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }
    }


    @Test
    public void getFractionForTestOfHalf() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            Object fraction = Fraction.class.getDeclaredConstructor().newInstance();
            Method of = fraction.getClass().getDeclaredMethod("of", new Class<?>[0]);
            of.invoke(fraction);
            Fraction val = Fraction.of(1, 2);
            assertEquals(0.5, val);
        } catch (ReflectiveOperationException ignored) {
        }
    }

    @Test
    public void getFull() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            Object fraction = Fraction.class.getDeclaredConstructor().newInstance();
            Method FULL = fraction.getClass().getDeclaredMethod("FULL", new Class<?>[0]);
            FULL.invoke(fraction);
            assertEquals(1, FULL);
        } catch (ReflectiveOperationException ignored) {
        }
    }
}
