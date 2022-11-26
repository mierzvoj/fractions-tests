import org.example.Fraction;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestsAssertJ {
    @Test
    public void getFractionForTestOfHalf() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            Object fraction = Fraction.class.getDeclaredConstructor().newInstance();
            Method of = fraction.getClass().getDeclaredMethod("of", new Class<?>[0]);
            of.invoke(fraction);
            Fraction val = Fraction.of(1, 2);
            assertThat(val).isEqualTo(0.5);
        } catch (ReflectiveOperationException ignored) {
        }
    }

    @Test
    public void getFull() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            Object fraction = Fraction.class.getDeclaredConstructor().newInstance();
            Method FULL = fraction.getClass().getDeclaredMethod("FULL", new Class<?>[0]);
            FULL.invoke(fraction);
            assertThat(FULL).isEqualTo(1);
        } catch (ReflectiveOperationException ignored) {
        }
    }

}
