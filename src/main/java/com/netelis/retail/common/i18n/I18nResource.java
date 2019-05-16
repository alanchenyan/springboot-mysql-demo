package com.netelis.retail.common.i18n;

import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @author Alan Chen
 * @description
 * @date 2019/4/1
 */
public class I18nResource {

    protected ResourceBundleMessageSource resourceBundleMessageSource;
    private Object objs[] = { "language" };

    protected I18nResource(String path) {
        resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename(path);
    }


    public String getValue(String key) {
        String value = "";
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();

            Locale customerLocale = (Locale) session
                    .getAttribute("WW_TRANS_I18N_LOCALE");
            if (customerLocale == null) {
                customerLocale = request.getLocale();
                session.setAttribute("WW_TRANS_I18N_LOCALE", customerLocale);
            }
            value = getValue(key, customerLocale);
        } catch (Exception e) {
            value = getValue(key, Locale.TRADITIONAL_CHINESE);
        }
        return value;
    }



    public String getValue(String keyValue,Object[] parameters) {
        String value = "";
        try {

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();

            Locale customerLocale = (Locale) session
                    .getAttribute("WW_TRANS_I18N_LOCALE");
            if (customerLocale == null) {
                customerLocale = request.getLocale();
                session.setAttribute("WW_TRANS_I18N_LOCALE", customerLocale);
            }

            value = getValue(keyValue, customerLocale,parameters);
        } catch (Exception e) {
            value = getValue(keyValue, Locale.TRADITIONAL_CHINESE,parameters);
        }
        return value;
    }

    public String getValue(String keyValue, Locale locale) {
        if (resourceBundleMessageSource != null){
            return resourceBundleMessageSource.getMessage(keyValue, objs,
                    locale);
        }
        return null;
    }

    public String getValue(String keyValue, Locale locale,Object[] parameters) {
        try {
            if (resourceBundleMessageSource != null){
                Object[] params = parameters==null?objs:parameters;
                return resourceBundleMessageSource.getMessage(keyValue, params,
                        locale);
            }
            return "";
        } catch (NoSuchMessageException e) {

            return "";
        }
    }


}
