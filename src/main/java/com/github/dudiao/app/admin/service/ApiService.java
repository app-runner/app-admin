package com.github.dudiao.app.admin.service;

import cn.hutool.core.util.StrUtil;
import com.github.dudiao.app.admin.entity.App;
import com.github.dudiao.app.admin.mapper.AppMapper;
import org.noear.solon.annotation.Component;
import org.noear.wood.MapperWhereQ;
import org.noear.wood.annotation.Db;
import org.noear.wood.ext.Act1;

import java.util.List;

/**
 * @author songyinyin
 * @since 2023/11/10 16:34
 */
@Component
public class ApiService {

    @Db
    AppMapper appMapper;

    /**
     * 获取app列表
     *
     * @param name app名称
     */
    public List<App> appList(String name) {
        Act1<MapperWhereQ> condition = m -> {
            if (StrUtil.isNotBlank(name)) {
                m.whereLk(App::getName, String.format("%%%s%%", name));
            }
            m.orderByDesc(App::getWeight).orderByAsc(App::getCreateTime);
        };
        return appMapper.selectList(condition);
    }
}
