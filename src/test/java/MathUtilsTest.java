import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import com.bijay.junittest.MathUtils;
import com.bijay.junittest.SpringConfig;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;

@RunWith(Enclosed.class)
public class MathUtilsTest {

    @RunWith(Parameterized.class)
    @ContextConfiguration(classes=SpringConfig.class)
    public static class AddTest{

        @Autowired
        MathUtils mathUtils;

        @Parameter
        public int numberA;
        @Parameter(value = 1)
        public int numberB;
        @Parameter(value = 2)
        public int expected;

        private TestContextManager testContextManager;

        @BeforeClass
        public static void beforeClass(){

        }

        @Before
        public void setUp() throws Exception {
            this.testContextManager = new TestContextManager(getClass());
            this.testContextManager.prepareTestInstance(this);
        }

        @Parameters(name = "{index}: add({0}+{1})={2}")
        public static Iterable<Object[]> data1() {
            return Arrays.asList(new Object[][] {
                    { 1, 1, 2 },
                    { 2, 2, 4 },
                    { 8, 2, 10 },
                    { 4, 5, 9 }
            });
        }


        @Test
        public void test_add() {
            MathUtils utils = new MathUtils();
            assertEquals(expected,mathUtils.add(numberA, numberB));
        }

    }

    @RunWith(Parameterized.class)
    public static class SubstractTest{

        @Parameter
        public int numberA;
        @Parameter(value = 1)
        public int numberB;
        @Parameter(value = 2)
        public int expected;

        @Parameters(name = "{index}: substract({0}-{1})={2}")
        public static List<Integer[]> data1() {
            return Arrays.asList(new Integer[][] {
                    { 2, 1, 1 },
                    { 2, 2, 0 },
                    { 8, 2, 6 },
                    { 4, 5, -1 }
            });
        }


        @Test
        public void test_substract() {
            MathUtils utils = new MathUtils();
            assertEquals(expected,utils.substact(numberA, numberB));
        }

    }

    public static class PlainTest{



        @Test
        public void test_substract() {
            MathUtils utils = new MathUtils();
            assertEquals(5, utils.substact(10, 5));
        }
    }




}