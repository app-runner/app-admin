package features;

import com.github.dudiao.app.admin.AppAdmin;
import org.junit.runner.RunWith;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

/**
 * @author songyinyin
 * @since 2023/11/13 17:35
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(value = AppAdmin.class, env = "dev")
public class BaseAppTest {

}
