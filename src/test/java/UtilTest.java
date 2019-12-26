import org.junit.Test;
import ru.text.main.Util;

public class UtilTest {

    @Test
    public void test() {
       assert Util.isMorze("·−−· ·−· −−− ·−− · ·−· −·− ·− ");
        assert !Util.isMorze("проверка");

    }

    @Test(expected = AssertionError.class)
    public void test2() {
        assert !Util.isMorze("·−−· ·−· −−− ·−− · ·−· −·− ·− ");

    }

    @Test(expected = AssertionError.class)
    public void test3() {
        assert Util.isMorze("проверка");

    }

}
