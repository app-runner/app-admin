package com.github.dudiao.app.admin.api;

import cn.dev33.satoken.annotation.SaIgnore;
import com.github.dudiao.app.admin.service.ApiService;
import com.github.dudiao.app.admin.vo.Result;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.MethodType;

/**
 * @author songyinyin
 * @since 2023/11/10 18:34
 */
@SaIgnore
@Controller()
@Mapping("/apprunner-api/v1")
public class ApiController {

    @Inject
    ApiService apiService;

    /**
     * 查看所有应用
     */
    @Mapping(value = "/list", method = MethodType.GET)
    public Result list(String name) {

        return Result.ok(apiService.appList(name));
    }
}
