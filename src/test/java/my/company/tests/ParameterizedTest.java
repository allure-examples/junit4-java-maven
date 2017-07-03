package my.company.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * eroshenkoam
 * 01.05.17
 */
@RunWith(Parameterized.class)
public class ParameterizedTest {

    @Parameterized.Parameter
    public int first;

    @Parameterized.Parameter(1)
    public int second;

    @Parameterized.Parameter(2)
    public long result;

    @Parameterized.Parameters
    public static List<Object[]> getData() {
        return Arrays.asList(new Object[]{1, 2, 2}, new Object[]{2, 4, 8});
    }

    @Test
    public void testMultiplication() {
        assertThat((long) first * second, equalTo(result));
    }

}
