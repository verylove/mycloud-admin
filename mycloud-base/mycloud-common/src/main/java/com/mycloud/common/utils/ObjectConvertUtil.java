package com.mycloud.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangqi
 * @Package com.mycloud.admin.utils
 * @Description: 类转换
 * @date 2018/7/1 22:13
 */
public class ObjectConvertUtil {


    public static <T> T convert(Object src, Class<T> tar) {

        if (src != null) {
            try {
                T t = tar.newInstance();
                BeanUtils.copyProperties(src, t);
                return t;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T> T convert(Object src, Class<T> tar, String... ignores) {

        if (src != null) {
            try {
                T t = tar.newInstance();
                BeanUtils.copyProperties(src, t, ignores);
                return t;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T> List<T> convertList(List<?> src, Class<T> tar) {

        if (src != null) {
            List<T> tList = new ArrayList<>();
            src.forEach(s -> {
                try {
                    T t = tar.newInstance();
                    BeanUtils.copyProperties(s, t);
                    tList.add(t);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            });
            return tList;
        }
        return null;
    }

    public static <T> List<T> convertList(List<?> src, Class<T> tar, String... ignores) {

        if (src != null) {
            List<T> tList = new ArrayList<>();
            src.forEach(s -> {
                try {
                    T t = tar.newInstance();
                    BeanUtils.copyProperties(s, t, ignores);
                    tList.add(t);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            });
            return tList;
        }
        return null;
    }


}
