package com.springboot.mysql.common.i18n;

/**
 * @author Alan Chen
 * @description I18nMessage
 * @date 2019/4/1
 */
public interface I18nMessage {

    /**
     * 描述信息
     * @return
     */
    String getMessageCode();

    /**
     * 国际化key
     * @return
     */
    String getI18nKey();

    /**
     * 国际化文件路径
     * @return
     */
    String getI18nResourcePath();

    /**
     * 获取描述信息
     * @return
     */
    default String getMessage(){
        String messageI18n = "";
        try {
            messageI18n = I18nResourceHandleMapping.getInstance(getI18nResourcePath()).getValue(getI18nKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messageI18n;
    }
}
