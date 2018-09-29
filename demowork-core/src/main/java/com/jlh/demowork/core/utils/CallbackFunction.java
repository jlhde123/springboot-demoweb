package com.jlh.demowork.core.utils;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao@yixin.im
 * Date: 2018-09-28 17:03
 * Description:
 */
@FunctionalInterface
public interface CallbackFunction<T> {
    T call();
}
