package org.lab_manager.utils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiaofeige on 16/5/26.
 */
public class CookieUtil {

    public static String getCookieValue(Cookie[] cookies, String name) {
        if (cookies == null) {
            return null;
        }
        for (Cookie c : cookies) {
            if (name.equals(c.getName())) {
                return c.getValue();
            }
        }
        return null;
    }

    /**
     * 在取cookie值，如果获取失败，将用空字符串代替null。
     * 同时把代码中多处重复代码都替换成这个
     */
    public static String getCookieValueWithEmptyStrReplaceNull(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        String defaultVal = "";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (name.equals(c.getName())) {
                    defaultVal = c.getValue();
                    break;
                }
            }
        }
        return defaultVal;
    }

    /**
     * 记录当前的所有cookie
     */
    public static String getAllCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        StringBuffer cookieSb = new StringBuffer();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                cookieSb.append(ck.getName());
                cookieSb.append(",");
                cookieSb.append(ck.getValue());
                cookieSb.append(";");
            }
        }
        return cookieSb.toString();
    }

    public static String getRfcCookies(HttpServletRequest request, String domain) {
        Cookie[] cookies = request.getCookies();
        StringBuffer cookieSb = new StringBuffer();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                cookieSb.append(ck.getName());
                cookieSb.append("=");
                cookieSb.append(ck.getValue());
                cookieSb.append(";");
            }
        }
        if (!StringUtil.isEmpty(domain)) {
            cookieSb.append("domain=").append(domain).append(";");
        }
        return cookieSb.toString();
    }

    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        Cookie cookie = null;
        for (Cookie ck : cookies) {
            String ckName = ck.getName();
            if (cookieName.equals(ckName)) {
                cookie = ck;
                break;
            }
        }
        return cookie;
    }

    public static void writeTouchCookie(HttpServletResponse response, HttpServletRequest request, int maxAge, String cName, String cValue, String domain) {
        Cookie cookie = CookieUtil.getCookie(request, cName);
        if (cookie == null) {
            cookie = new Cookie(cName, cValue);
        } else {
            cookie.setValue(cValue);
        }
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void writeTouchCookie(HttpServletResponse response, HttpServletRequest request, String cName, String cValue, String domain, int hour) {
        writeTouchCookie(response, request, hour * 3600, cName, cValue, domain);
    }

    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value == null ? "" : value);
        cookie.setMaxAge(maxAge);
        cookie.setPath(getPath(request));
        response.addCookie(cookie);
    }

    private static String getPath(HttpServletRequest request) {
        String path = request.getContextPath();
        return (path == null || path.length() == 0) ? "/" : path;
    }

}
