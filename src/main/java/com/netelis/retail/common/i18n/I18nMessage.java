package com.netelis.retail.common.i18n;

/**
 * @author Alan Chen
 * @description I18nMessage
 * @date 2019/4/1
 */
public interface I18nMessage {

    String getMessageCode();

    String getI18nKey();

    String getI18nResourcePath();

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
