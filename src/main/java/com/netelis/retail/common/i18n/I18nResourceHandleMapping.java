package com.netelis.retail.common.i18n;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Kim
 * @description 国际化文件对象缓存器
 * @date 2019/1/30
 */
public class I18nResourceHandleMapping {
    private static Map<String, I18nResource> map = new HashMap<>();
    private static ReadWriteLock rwl = new ReentrantReadWriteLock();

    public static I18nResource getInstance(String path){
        I18nResource obj = null;
        rwl.readLock().lock();
        try {
            obj = map.get(path);
            if (obj == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try {
                    if (obj == null) {
                        obj = new I18nResource(path);
                        map.put(path, obj);
                    }
                }finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }
        return obj;
    }
}
