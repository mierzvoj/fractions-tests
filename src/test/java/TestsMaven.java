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
    public void getFractionForTestOfFull() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            Object fraction = Fraction.class.getDeclaredConstructor().newInstance();
            Method of = fraction.getClass().getDeclaredMethod("of", new Class<?>[0]);
            of.invoke(fraction);
            Fraction val = Fraction.of(1, 1);
            assertEquals(1, val);
        } catch (ReflectiveOperationException ignored) {
        }
    }

    @Test
    public void getFractionForTestOfOneThird() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            Object fraction = Fraction.class.getDeclaredConstructor().newInstance();
            Method of = fraction.getClass().getDeclaredMethod("of", new Class<?>[0]);
            of.invoke(fraction);
            Fraction val = Fraction.of(1, 3);
            assertEquals(0.3333333333, val);
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

    @Test
    public void getHalf() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            Object fraction = Fraction.class.getDeclaredConstructor().newInstance();
            Method HALF = fraction.getClass().getDeclaredMethod("FULL", new Class<?>[0]);
            HALF.invoke(fraction);
            assertEquals(0.5, HALF);
        } catch (ReflectiveOperationException ignored) {
        }
    }

    @Test
    public void getOneThird() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            Object fraction = Fraction.class.getDeclaredConstructor().newInstance();
            Method ONE_THIRD  = fraction.getClass().getDeclaredMethod("FULL", new Class<?>[0]);
            ONE_THIRD .invoke(fraction);
            assertEquals(0.3333333333, ONE_THIRD );
        } catch (ReflectiveOperationException ignored) {
        }
    }
}
