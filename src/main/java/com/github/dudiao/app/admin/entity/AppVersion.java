package com.github.dudiao.app.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.noear.wood.annotation.Table;
import site.sorghum.anno.anno.annotation.clazz.AnnoMain;
import site.sorghum.anno.anno.annotation.field.AnnoEdit;
import site.sorghum.anno.anno.annotation.field.AnnoField;
import site.sorghum.anno.anno.annotation.field.type.AnnoOptionType;
import site.sorghum.anno.suppose.model.BaseMetaModel;

/**
 * @author songyinyin
 * @since 2023/11/8 17:37
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("ar_app_version")
@AnnoMain(name = "应用版本")
public class AppVersion extends BaseMetaModel {

  @AnnoField(title = "版本号", edit = @AnnoEdit(notNull = true))
  private String version;

  @AnnoField(title = "版本号数字", edit = @AnnoEdit(placeHolder = "用来比较版本号的大小，数字越大，版本越高（越新）", notNull = true))
  private Long versionNum = 0L;

  @AnnoField(
      title = "状态", edit = @AnnoEdit, optionType = @AnnoOptionType({
      @AnnoOptionType.OptionData(label = "发布", value = "release"),
      @AnnoOptionType.OptionData(label = "预览", value = "preview"),
      @AnnoOptionType.OptionData(label = "测试", value = "test")}))
  private String status;

  @AnnoField(title = "描述", edit = @AnnoEdit(), show = false)
  private String description;

  @AnnoField(
      title = "App Github下载地址",
      edit = @AnnoEdit(
          placeHolder = "最好github和gitee的下载地址都配置上。例如：https://github.com/dudiao/solon-native-example/releases/download/v0.0.3/solon-native-example-macos-latest.zip"
      ), fieldSize = 512
  )
  private String githubDownloadUrl;

  @AnnoField(
      title = "App Gitee下载地址",
      edit = @AnnoEdit(
          placeHolder = "最好github和gitee的下载地址都配置上。例如：https://gitee.com/songyinyin/native-demo/releases/download/v0.0.1.9/native-demo-macos-latest.zip"
      ), fieldSize = 512
  )
  private String giteeDownloadUrl;
}
