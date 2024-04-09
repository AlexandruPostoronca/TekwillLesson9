import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void test1() {
        simpleTest("John", 1, "Maria", 3);
    }

    @Test
    public void test2() {
        simpleTest("Alex", 20, "John", 30);
    }

    private void simpleTest(String name1, int age1, String name2, int age2) {
        Person p1 = new Person(name1, age1);
        Person p2 = new Person(name2, age2);
        MakingChanges.changeIdentities(p1, p2);

        assertEquals(name1, p2.name);
        assertEquals(age1, p2.age);
        assertEquals(name2, p1.name);
        assertEquals(age2, p1.age);
    }
}