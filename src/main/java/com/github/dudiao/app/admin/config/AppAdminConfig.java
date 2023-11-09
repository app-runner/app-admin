package com.github.dudiao.app.admin.config;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import site.sorghum.anno._common.AnnoConstants;

import javax.sql.DataSource;

/**
 * @author songyinyin
 * @since 2023/11/8 17:30
 */
@Configuration
public class AppAdminConfig {

  @Bean(name = AnnoConstants.DEFAULT_DATASOURCE_NAME, typed = true)
  public DataSource dataSource(@Inject("${db.main}") HikariDataSource ds) {
    return ds;
  }

}
