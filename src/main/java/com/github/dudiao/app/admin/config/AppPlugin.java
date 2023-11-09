package com.github.dudiao.app.admin.config;

import com.github.dudiao.app.admin.entity.App;
import org.noear.solon.annotation.Component;
import site.sorghum.anno.plugin.AnPluginMenu;
import site.sorghum.anno.plugin.AnnoPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songyinyin
 * @since 2023/11/8 19:28
 */
@Component
public class AppPlugin extends AnnoPlugin {

    public AppPlugin() {
        super("App", "app runner admin");
    }

    @Override
    public List<AnPluginMenu> initEntityMenus() {
        List<AnPluginMenu> list = new ArrayList<>();
        list.add(createRootMenu("app_manager", "AppRunner", "layui-icon layui-icon-diamond", 100));
        list.add(createEntityMenu(App.class, list.get(0).getId(), "layui-icon layui-icon-cart", 110));
        return list;
    }
}
