package features;

import com.github.dudiao.app.admin.AppAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(AppAdmin.class)
public class HelloTest extends HttpTester {
    @Test
    public void hello() {

    }
}