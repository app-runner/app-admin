package com.github.dudiao.app.admin.ddd;

import cn.hutool.core.util.StrUtil;
import com.github.dudiao.app.admin.entity.AppVersion;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.SneakyThrows;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;
import site.sorghum.anno.anno.proxy.AnnoBaseProxy;
import site.sorghum.anno.db.param.DbCondition;
import site.sorghum.anno.db.service.impl.DbServiceWood;

import java.util.List;

/**
 * @author songyinyin
 * @since 2023/11/11 17:14
 */
@Named
public class UpdateAppLatestVersionProcessor implements AnnoBaseProxy<AppVersion> {

    @Inject
    DbServiceWood dbServiceWood;

    @Db
    DbContext dbContext;

    @Override
    public String[] supportEntities() {
        return new String[]{
            AnnoBaseProxy.clazzToDamiEntityName(AppVersion.class)
        };
    }

    @Override
    public void afterAdd(AppVersion data) {
        updateLatestVersion(data.getAppId());
    }

    @Override
    public void afterUpdate(AppVersion data) {
        updateLatestVersion(data.getAppId());
    }

    @SneakyThrows
    @Override
    public void afterDelete(Class<AppVersion> appVersionClass, List<DbCondition> dbConditions) {
        List<String> appIds = dbServiceWood.toTbQuery(appVersionClass, dbConditions).selectList("app_id", String.class);
        appIds.forEach(this::updateLatestVersion);
    }

    @SneakyThrows
    private void updateLatestVersion(String appId) {
        if (StrUtil.isBlank(appId)) {
            return;
        }
        dbContext.sql("UPDATE ar_app SET latest_version = (select version  from ar_app_version aav where app_id = ? order by version_num desc limit 1) WHERE id = ?", appId, appId).execute();
    }
}
