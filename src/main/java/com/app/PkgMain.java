package com.app;

import java.lang.annotation.Annotation;

/**
 * Created by lucky on 2017/12/20.
 */
public class PkgMain {
    public static void main(String[] args) {
        String pkgName = "com.app";
        Package pkg = Package.getPackage(pkgName);
        Annotation[] annotations = pkg.getAnnotations();
        for (Annotation an : annotations) {
            if (an instanceof PkgAnnotation) {
                System.out.println("Hi,I'm the PkgAnnotation");

            }
        }

        System.out.println(com.app.PkgConst.PACAKGE_CONST);
    }
}
