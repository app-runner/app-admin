package com.github.dudiao.app.admin;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;
import site.sorghum.anno.anno.annotation.global.AnnoScan;

@SolonMain
@AnnoScan(scanPackage = {"site.sorghum.anno", "com.github.dudiao.app.admin"})
public class AppAdmin {
    public static void main(String[] args) {
        Solon.start(AppAdmin.class, args);
    }
}