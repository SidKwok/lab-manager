package org.lab_manager.utils;

import com.google.common.base.Strings;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xiaofeige on 16/5/26.
 */

public class DateTimeUtil {

    private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String ALL_PATTERN = "yyyyMMddHHmmss";

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern(DATE_PATTERN);
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormat.forPattern(DATETIME_PATTERN);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern(TIME_PATTERN);
    public static final DateTimeFormatter ALL_FORMATTER = DateTimeFormat.forPattern(ALL_PATTERN);

    /**
     * 提供string->DateTime的转换，只支持以下的格式：
     * <ol>
     * <li>yyyy-MM-dd HH:mm:ss</li>
     * <li>yyyy-MM-dd</li>
     * </ol>
     * </p>
     * <p/>
     * 无需进行指定，工具能够自动识别具体的格式
     *
     * @param date 只支持两种
     * @return
     */
    public static DateTime jodaOf(String date) {
        checkArgument(!Strings.isNullOrEmpty(date));//fast fail
        DateTime d;
        if (date.contains(":")) {//弱判断
            d = DateTime.parse(date, DATETIME_FORMATTER);
        } else {
            d = DateTime.parse(date, DATE_FORMATTER);
        }
        return d;
    }

    /**
     * 根据不同的pattern进行构造DateTime对象
     *
     * @param date
     * @param pattern
     * @return
     */
    public static DateTime jodaOf(String date, String pattern) {
        checkArgument(!Strings.isNullOrEmpty(date));//fast fail
        return DateTime.parse(date, DateTimeFormat.forPattern(pattern));
    }

    /**
     * 解析时间字符串
     *
     * @param date
     * @return
     */
    public static Date dateOf(String date) {
        return toDate(jodaOf(date));
    }

    /**
     * 解析时间字符串
     *
     * @param date
     * @return
     */
    public static Time timeOf(String date) {
        return toTime(jodaOf(date));
    }

    /**
     * 解析时间字符串
     *
     * @param date
     * @return
     */
    public static Timestamp timestampOf(String date) {
        return toTimestamp(jodaOf(date));
    }

    /**
     * 解析时间字符串
     *
     * @param date
     * @return
     */
    public static java.sql.Date sqlDateOf(String date) {
        return toSqlDate(jodaOf(date));
    }

    /**
     * 简化创建joda 的 DateTime方式
     * 等价于：new DateTime(unixStamp);
     *
     * @param unixStamp
     * @return
     */
    public static <T extends Date> DateTime jodaOf(T unixStamp) {
        checkNotNull(unixStamp);
        return new DateTime(unixStamp);
    }

    /**
     * joda 转换为 Date的便捷方法
     *
     * @param dateTime
     * @return
     */
    public static Date toDate(DateTime dateTime) {
        checkNotNull(dateTime);
        return dateTime.toDate();
    }

    /**
     * joda 转换为 Date的便捷方法
     *
     * @param dateTime
     * @return
     */
    public static java.sql.Date toSqlDate(DateTime dateTime) {
        checkNotNull(dateTime);
        return new java.sql.Date(dateTime.getMillis());
    }

    /**
     * joda 转换为 Time的便捷方法
     *
     * @param dateTime
     * @return
     */
    public static Time toTime(DateTime dateTime) {
        checkNotNull(dateTime);
        return new Time(dateTime.getMillis());
    }

    /**
     * joda 转换为 Timestamp的便捷方法
     *
     * @param dateTime
     * @return
     */
    public static Timestamp toTimestamp(DateTime dateTime) {
        checkNotNull(dateTime);
        return new Timestamp(dateTime.getMillis());
    }

    /**
     * 提供DateTime->String的转换
     * <pre>
     *        System.out.println(dateFrom(new DateTime(2014,9,2,3,0,0)));
     *        --> 2014-09-02
     * </pre>
     *
     * @param date
     * @return
     */
    public static String dateFrom(DateTime date) {
        checkNotNull(date);
        return date.toString(DATE_PATTERN);
    }

    /**
     * --> 2014-09-02
     *
     * @param date
     * @return
     */
    public static <T extends Date> String dateFrom(T date) {
        checkNotNull(date);
        return dateFrom(new DateTime(date));
    }

    /**
     * 提供DateTime->String的转换
     * <pre>
     *        System.out.println(dateTimeFrom(new DateTime(2014,9,2,3,0,0)));
     *        -->2014-9-2 03:00:00
     * </pre>
     *
     * @param dateTime
     * @return
     */
    public static String dateTimeFrom(DateTime dateTime) {
        checkNotNull(dateTime);
        return dateTime.toString(DATETIME_PATTERN);
    }

    /**
     * -->2014-9-2 03:00:00
     *
     * @param dateTime
     * @return
     */
    public static <T extends Date> String dateTimeFrom(T dateTime) {
        checkNotNull(dateTime);
        return dateTimeFrom(new DateTime(dateTime));
    }

    /**
     * 提供DateTime->String的转换
     * <pre>
     *        System.out.println(timeFrom(new DateTime(2014,9,2,3,0,0)));
     *        -->03:00:00
     * </pre>
     *
     * @param time
     * @return
     */
    public static String timeFrom(DateTime time) {
        checkNotNull(time);
        return time.toString(TIME_FORMATTER);
    }

    public static String allFrom(DateTime time) {
        checkNotNull(time);
        return time.toString(ALL_FORMATTER);
    }

    /**
     * -->03:00:00
     *
     * @param time
     * @return
     */
    public static <T extends Date> String timeFrom(T time) {
        checkNotNull(time);
        return timeFrom(new DateTime(time));
    }

    /**
     * 进行日期的格式化
     *
     * @param input   日期
     * @param pattern 模式，参考joda日期格式
     * @param <T>     从date继承的日期对象
     * @return
     */
    public static <T extends Date> String formatTime(T input, String pattern) {
        return jodaOf(input).toString(DateTimeFormat.forPattern(pattern));
    }

    /**
     * 进行日期的格式化
     *
     * @param input   从1970-01-01 00:00:00的毫秒时间
     * @param pattern 模式，参考joda日期格式
     * @return
     */
    public static String formatTime(long input, String pattern) {
        return jodaOf(new Date(input)).toString(DateTimeFormat.forPattern(pattern));
    }

    /**
     * 创建对象并增加n天
     *
     * @param ts
     * @param amount
     * @param <T>
     * @return
     */
    public static <T extends Date> T addDays(T ts, int amount) {
        checkArgument(amount >= 0, "days必须 >= 0 ");
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).plusDays(amount).getMillis());
        return cloned;
    }

    /**
     * 创建对象，并增加n分钟
     *
     * @param ts
     * @param amount
     * @param <T>
     * @return
     */
    public static <T extends Date> T addMinutes(T ts, int amount) {
        checkArgument(amount >= 0, "minutes必须 >= 0 ");
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).plusMinutes(amount).getMillis());
        return cloned;
    }

    /**
     * 创建对象，并增加n小时
     *
     * @param ts
     * @param amount
     * @param <T>
     * @return
     */
    public static <T extends Date> T addHours(T ts, int amount) {
        checkArgument(amount >= 0, "hours必须 >= 0 ");
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).plusHours(amount).getMillis());
        return cloned;
    }

    /**
     * 创建对象，并增加n秒钟
     *
     * @param ts
     * @param amount
     * @param <T>
     * @return
     */
    public static <T extends Date> T addSeconds(T ts, int amount) {
        checkArgument(amount >= 0, "seconds必须 >= 0 ");
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).plusSeconds(amount).getMillis());
        return cloned;
    }

    /**
     * 创建对象，并增加n个月
     *
     * @param ts
     * @param amount
     * @param <T>
     * @return
     */
    public static <T extends Date> T addMonth(T ts, int amount) {
        checkArgument(amount >= 0, "month必须 >= 0 ");
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).plusMonths(amount).getMillis());
        return cloned;
    }

    /**
     * 创建对象并减少n天
     *
     * @param ts
     * @param amount
     * @param <T>
     * @return
     */
    public static <T extends Date> T minusDays(T ts, int amount) {
        checkArgument(amount >= 0, "days必须 >= 0 ");
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).minusDays(amount).getMillis());
        return cloned;
    }

    /**
     * 创建对象，并减少分钟
     *
     * @param ts
     * @param amount
     * @param <T>
     * @return
     */
    public static <T extends Date> T minusMinutes(T ts, int amount) {
        checkArgument(amount >= 0, "minutes必须 >= 0 ");
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).minusMinutes(amount).getMillis());
        return cloned;
    }

    /**
     * 创建对象，并减少n小时
     *
     * @param ts
     * @param amount
     * @param <T>
     * @return
     */
    public static <T extends Date> T minusHours(T ts, int amount) {
        checkArgument(amount >= 0, "hours必须 >= 0 ");
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).minusHours(amount).getMillis());
        return cloned;
    }

    /**
     * 创建对象，并减少n秒钟
     *
     * @param ts
     * @param amount
     * @param <T>
     * @return
     */
    public static <T extends Date> T minusSeconds(T ts, int amount) {
        checkArgument(amount >= 0, "seconds必须 >= 0 ");
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).minusSeconds(amount).getMillis());
        return cloned;
    }

    /**
     * 创建对象，并减少n个月
     *
     * @param ts
     * @param amount
     * @param <T>
     * @return
     */
    public static <T extends Date> T minusMonth(T ts, int amount) {
        checkArgument(amount >= 0, "month必须 >= 0 ");
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).minusMonths(amount).getMillis());
        return cloned;
    }

    /**
     * 几号？[1-31]
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> int dayOfMonth(T ts) {
        checkNotNull(ts);
        return new DateTime(ts.getTime()).getDayOfMonth();
    }

    /**
     * 周几？[1-7]
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> int dayOfWeek(T ts) {
        checkNotNull(ts);
        return new DateTime(ts.getTime()).getDayOfWeek();
    }

    /**
     * 年内第多少天？[1-365]
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> int dayOfYear(T ts) {
        checkNotNull(ts);
        return new DateTime(ts.getTime()).getDayOfYear();
    }

    /**
     * 几点？24小时制
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> int hourOfDay(T ts) {
        checkNotNull(ts);
        return new DateTime(ts.getTime()).getHourOfDay();
    }

    /**
     * 几分？[1-60]
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> int minuteOfHour(T ts) {
        checkNotNull(ts);
        return new DateTime(ts.getTime()).getMinuteOfHour();
    }

    /**
     * 几秒？[1-60]
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> int secondOfMinute(T ts) {
        checkNotNull(ts);
        return new DateTime(ts.getTime()).getSecondOfMinute();
    }

    /**
     * 2014-03-02 23:00:23 -> 2014-03-02 00:00:00
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> T firstOfDay(T ts) {
        checkNotNull(ts);
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).withTime(0, 0, 0, 0).getMillis());
        return cloned;
    }

    /**
     * 2014-03-02 23:00:23 -> 2014-03-02 23:59:59
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> T lastOfDay(T ts) {
        checkNotNull(ts);
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).withTime(0, 0, 0, 0).plusDays(1).minusSeconds(1).getMillis());
        return cloned;
    }

    /**
     * 2014-03-02 23:00:23 -> 2014-03-01 00:00:00
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> T firstOfMonth(T ts) {
        checkNotNull(ts);
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).withTime(0, 0, 0, 0).withDayOfMonth(1).getMillis());
        return cloned;
    }

    /**
     * 2014-03-02 23:00:23 -> 2014-03-31 23:59:59
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> T lastOfMonth(T ts) {
        checkNotNull(ts);
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).withTime(0, 0, 0, 0).withDayOfMonth(1).plusMonths(1).minusSeconds(1).getMillis());
        return cloned;
    }

    /**
     * 2014-03-02 23:00:23 -> 2014-12-31 23:59:59
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> T lastOfYear(T ts) {
        checkNotNull(ts);
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).withTime(0, 0, 0, 0).withDayOfYear(1).minusSeconds(1).plusYears(1).getMillis());
        return cloned;
    }

    /**
     * 2014-03-02 23:00:23 -> 2014-01-01 00:00:00
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Date> T firstOfYear(T ts) {
        checkNotNull(ts);
        T cloned = (T) ts.clone();
        cloned.setTime(new DateTime(ts.getTime()).withTime(0, 0, 0, 0).withDayOfMonth(1).withDayOfYear(1).getMillis());
        return cloned;
    }

    /**
     * 当前时间的timestamp
     *
     * @return
     */
    public static Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 当前毫秒时间
     *
     * @return
     */
    public static long currentMillis() {
        return System.currentTimeMillis();
    }

}
