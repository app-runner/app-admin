package com.github.dudiao.app.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.noear.wood.annotation.Table;
import site.sorghum.anno.anno.annotation.clazz.AnnoMain;
import site.sorghum.anno.anno.annotation.clazz.AnnoOrder;
import site.sorghum.anno.anno.annotation.clazz.AnnoPermission;
import site.sorghum.anno.anno.annotation.field.AnnoButton;
import site.sorghum.anno.anno.annotation.field.AnnoEdit;
import site.sorghum.anno.anno.annotation.field.AnnoField;
import site.sorghum.anno.anno.annotation.field.AnnoSearch;
import site.sorghum.anno.anno.annotation.field.type.AnnoOptionType;
import site.sorghum.anno.anno.enums.AnnoDataType;
import site.sorghum.anno.suppose.model.BaseMetaModel;

import java.util.List;

/**
 * @author songyinyin
 * @since 2023/11/8 17:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("ar_app")
@AnnoMain(name = "应用管理", annoOrder = @AnnoOrder(orderValue = "versionNum", orderType = "desc"),
    annoPermission = @AnnoPermission(enable = true, baseCode = "ar_app", baseCodeTranslate = "应用管理"))
public class App extends BaseMetaModel {

    @AnnoField(title = "应用名称", search = @AnnoSearch(), edit = @AnnoEdit(placeHolder = "一般是英文", notNull = true))
    private String name;

    @AnnoField(title = "作者", edit = @AnnoEdit(), show = false)
    private String author;

    @AnnoField(title = "类型", dataType = AnnoDataType.OPTIONS, optionType = @AnnoOptionType({@AnnoOptionType.OptionData(label = "Java", value = "java"),
        @AnnoOptionType.OptionData(label = "Shell", value = "shell"),
        @AnnoOptionType.OptionData(label = "Python", value = "python")}), search = @AnnoSearch(), edit = @AnnoEdit(notNull = true))
    private String appType;

    @AnnoField(title = "最新版本", edit = @AnnoEdit)
    private String latestVersion;

    @AnnoField(title = "应用运行时依赖的最低版本", edit = @AnnoEdit)
    private String requiredRuntimeVersion;

    @AnnoField(title = "状态", dataType = AnnoDataType.OPTIONS, edit = @AnnoEdit(addEnable = false, editEnable = false), optionType = @AnnoOptionType({
        @AnnoOptionType.OptionData(label = "未审核", value = "0"),
        @AnnoOptionType.OptionData(label = "审批通过", value = "1"),
        @AnnoOptionType.OptionData(label = "审批拒绝", value = "2")}))
    private Integer status;

    @AnnoField(title = "权重", edit = @AnnoEdit(placeHolder = "数值越大，权重越高", addEnable = false, editEnable = false), show = false, defaultValue = "0")
    private Long weight;

    @AnnoField(title = "描述", edit = @AnnoEdit(), show = false, dataType = AnnoDataType.RICH_TEXT)
    private String description;

    @AnnoButton(name = "应用版本", o2mJoinButton = @AnnoButton.O2MJoinButton(joinAnnoMainClazz = AppVersion.class, joinThisClazzField = "id", joinOtherClazzField = "appId"))
    private List<AppVersion> appVersions;

    private AppVersion appLatestVersion;
}
