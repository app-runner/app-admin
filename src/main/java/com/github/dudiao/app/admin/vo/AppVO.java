package com.github.dudiao.app.admin.vo;

import com.github.dudiao.app.admin.entity.AppVersion;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author songyinyin
 * @since 2023/11/10 18:43
 */
@Data
public class AppVO implements Serializable {

    private String name;

    private String author;

    private String appType;

    private String requiredRuntimeVersion;

    private Integer status;

    private String description;

    private String latestVersion;
}
