package features;

import com.github.dudiao.app.admin.ddd.UpdateAppLatestVersionProcessor;
import com.github.dudiao.app.admin.entity.AppVersion;
import jakarta.inject.Inject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.noear.solon.core.util.ResourceUtil;
import org.noear.solon.data.annotation.Tran;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;
import site.sorghum.anno._common.util.ScriptUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

public class AppVersionTest extends BaseAppTest {

    @Db
    DbContext dbContext;
    @Inject
    UpdateAppLatestVersionProcessor updateAppLatestVersionProcessor;

    String appId = "test001";

    @Before
    public void before() throws IOException, SQLException {
        dbContext.table("ar_app").whereLk("id", "test%").delete();
        dbContext.table("ar_app_version").whereLk("id", "test%").delete();
        URL resource = ResourceUtil.getResource("sql/AppInit.sql");
        List<String> statements = ScriptUtils.getStatements(new InputStreamReader(resource.openStream(), StandardCharsets.UTF_8));
        for (String statement : statements) {
            dbContext.sql(statement).execute();
        }
    }

    @After
    public void after() throws SQLException {
        dbContext.table("ar_app").whereLk("id", "test%").delete();
        dbContext.table("ar_app_version").whereLk("id", "test%").delete();
    }

    @Test
    @Tran
    public void testAppLatestVersion() throws SQLException {

        AppVersion appVersion = new AppVersion();
        appVersion.setAppId(appId);

        updateAppLatestVersionProcessor.afterAdd(appVersion);

        List<String> list = dbContext.table("ar_app").whereEq("id", appId).selectArray("latest_version");
        assert list.size() == 1;
        assert list.get(0).equals("v0.0.3");
    }
}