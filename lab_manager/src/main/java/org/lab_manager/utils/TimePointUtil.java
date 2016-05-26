package org.lab_manager.utils;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * 时间点压缩，解压工具类，用于将时间点（小时，分钟）进行压缩，使其
 * 成为一个新的组合数字，减少存储和传输所占的空间
 * Created by jimin on 16/3/10
 */
public class TimePointUtil {

    private static final int HALF_SHIFT = 8;

    /**
     * 返回结果一定是2个item的数组：
     * <ol>
     * <li>ret[0]是hour</li>
     * <li>ret[1]是minute</li>
     * </ol>
     *
     * @return
     */
    public static short[] decode(short val) {
        return new short[] { (short) (val >> HALF_SHIFT), (short) (val & 0xFF) };
    }

    /**
     * hour: [0,23] , minute: [0,59]
     *
     * @param hour
     * @param minute
     * @return
     */
    public static short encode(short hour, short minute) {
        checkArgument(hour >= 0 && hour < 24, "小时应该：[0,23]");
        checkArgument(minute >= 0 && minute < 60, "分钟应该：[0,59]");
        return (short) (hour << HALF_SHIFT | (minute));
    }
}
