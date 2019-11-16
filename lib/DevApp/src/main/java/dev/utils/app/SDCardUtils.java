package dev.utils.app;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.format.Formatter;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.DevUtils;
import dev.utils.LogPrintUtils;

/**
 * detail: SDCard 工具类
 * @author Ttt
 */
public final class SDCardUtils {

    private SDCardUtils() {
    }

    // 日志 TAG
    private static final String TAG = SDCardUtils.class.getSimpleName();

    /**
     * 判断内置 SDCard 是否正常挂载
     * @return {@code true} yes, {@code false} no
     */
    public static boolean isSDCardEnable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取内置 SDCard File
     * @return {@link File}
     */
    public static File getSDCardFile() {
        return Environment.getExternalStorageDirectory();
    }

    /**
     * 获取内置 SDCard 绝对路径
     * <pre>
     *     结尾无添加 File.separator
     * </pre>
     * @return 内置 SDCard 绝对路径
     */
    public static String getSDCardPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /**
     * 获取内置 SDCard 绝对路径
     * <pre>
     *     结尾添加 File.separator
     * </pre>
     * @return 内置 SDCard 绝对路径
     */
    public static String getSDCardPathSeparator() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    }

    // =

    /**
     * 获取内置 SDCard 中指定文件路径
     * @param filePath 文件路径
     * @return 内置 SDCard 中指定文件路径
     */
    public static File getSDCardFile(final String filePath) {
        return getFile(getSDCardPath(), filePath);
    }

    /**
     * 获取内置 SDCard 中指定文件路径
     * @param filePath 文件路径
     * @return 内置 SDCard 中指定文件路径
     */
    public static String getSDCardPath(final String filePath) {
        return getAbsolutePath(getFile(getSDCardPath(), filePath));
    }

    // =

    /**
     * 判断 SDCard 是否可用
     * @return {@code true} yes, {@code false} no
     */
    public static boolean isSDCardEnablePath() {
        return !getSDCardPaths().isEmpty();
    }

    /**
     * 获取 SDCard 路径
     * @return SDCard 路径
     */
    @SuppressWarnings("TryWithIdenticalCatches")
    public static List<String> getSDCardPaths() {
        List<String> listPaths = new ArrayList<>();
        try {
            StorageManager storageManager = getStorageManager();
            Method getVolumePathsMethod = StorageManager.class.getMethod("getVolumePaths");
            getVolumePathsMethod.setAccessible(true);
            Object invoke = getVolumePathsMethod.invoke(storageManager);
            listPaths = Arrays.asList((String[]) invoke);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getSDCardPaths");
        }
        return listPaths;
    }

    /**
     * 获取 SDCard 路径
     * @param removable {@code true} 外置 SDCard, {@code false} 内置 SDCard
     * @return SDCard 路径
     */
    @SuppressWarnings("TryWithIdenticalCatches")
    public static List<String> getSDCardPaths(final boolean removable) {
        List<String> listPaths = new ArrayList<>();
        try {
            StorageManager storageManager = getStorageManager();
            Class<?> storageVolumeClazz = Class.forName("android.os.storage.StorageVolume");
            Method getVolumeList = StorageManager.class.getMethod("getVolumeList");
            Method getPath = storageVolumeClazz.getMethod("getPath");
            Method isRemovable = storageVolumeClazz.getMethod("isRemovable");
            Object result = getVolumeList.invoke(storageManager);
            final int length = Array.getLength(result);
            for (int i = 0; i < length; i++) {
                Object storageVolumeElement = Array.get(result, i);
                String path = (String) getPath.invoke(storageVolumeElement);
                boolean res = (Boolean) isRemovable.invoke(storageVolumeElement);
                if (removable == res) {
                    listPaths.add(path);
                }
            }
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getSDCardPaths");
        }
        return listPaths;
    }

    // ============
    // = 空间信息 =
    // ============

    /**
     * 获取内置 SDCard 空间总大小
     * @return 内置 SDCard 空间总大小
     */
    public static String getAllBlockSizeFormat() {
        try {
            long size = getAllBlockSize(Environment.getExternalStorageDirectory().getPath());
            // 格式化
            return Formatter.formatFileSize(DevUtils.getContext(), size);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAllBlockSizeFormat");
            return null;
        }
    }

    /**
     * 获取内置 SDCard 空闲空间大小
     * @return 内置 SDCard 空闲空间大小
     */
    public static String getAvailableBlocksFormat() {
        try {
            long size = getAvailableBlocks(Environment.getExternalStorageDirectory().getPath());
            // 格式化
            return Formatter.formatFileSize(DevUtils.getContext(), size);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAvailableBlocksFormat");
            return null;
        }
    }

    /**
     * 获取内置 SDCard 已使用空间大小
     * @return 内置 SDCard 已使用空间大小
     */
    public static String getUsedBlocksFormat() {
        try {
            long size = getUsedBlocks(Environment.getExternalStorageDirectory().getPath());
            // 格式化
            return Formatter.formatFileSize(DevUtils.getContext(), size);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getUsedBlocksFormat");
            return null;
        }
    }

    // =

    /**
     * 获取内置 SDCard 空间总大小
     * @return 内置 SDCard 空间总大小
     */
    public static long getAllBlockSize() {
        try {
            return getAllBlockSize(Environment.getExternalStorageDirectory().getPath());
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAllBlockSize");
            return 0L;
        }
    }

    /**
     * 获取内置 SDCard 空闲空间大小
     * @return 内置 SDCard 空闲空间大小
     */
    public static long getAvailableBlocks() {
        try {
            return getAvailableBlocks(Environment.getExternalStorageDirectory().getPath());
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAvailableBlocks");
            return 0L;
        }
    }

    /**
     * 获取内置 SDCard 已使用空间大小
     * @return 内置 SDCard 已使用空间大小
     */
    public static long getUsedBlocks() {
        try {
            return getUsedBlocks(Environment.getExternalStorageDirectory().getPath());
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getUsedBlocks");
            return 0L;
        }
    }

    /**
     * 返回内置 SDCard 空间大小信息
     * @return long[], 0 = 总空间大小, 1 = 空闲空间大小, 2 = 已使用空间大小
     */
    public static long[] getBlockSizeInfos() {
        try {
            return getBlockSizeInfos(Environment.getExternalStorageDirectory().getPath());
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getBlockSizeInfos");
            return null;
        }
    }

    // =

    /**
     * 获取对应路径的空间总大小
     * @param path 路径
     * @return 对应路径的空间总大小
     */
    public static long getAllBlockSize(final String path) {
        try {
            // 获取路径的存储空间信息
            StatFs statFs = new StatFs(path);
            // 单个数据块的大小、数据块数量
            long blockSize, blockCount;
            // 版本兼容
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            // 返回空间总大小
            return (blockCount * blockSize);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAllBlockSize");
        }
        return 0L;
    }

    /**
     * 获取对应路径的空闲空间大小
     * @param path 路径
     * @return 对应路径的空闲空间大小
     */
    public static long getAvailableBlocks(final String path) {
        try {
            // 获取路径的存储空间信息
            StatFs statFs = new StatFs(path);
            // 单个数据块的大小、空闲的数据块数量
            long blockSize, availableBlocks;
            // 版本兼容
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            // 返回空闲空间
            return (availableBlocks * blockSize);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getAvailableBlocks");
        }
        return 0L;
    }

    /**
     * 获取对应路径已使用空间大小
     * @param path 路径
     * @return 对应路径已使用空间大小
     */
    public static long getUsedBlocks(final String path) {
        try {
            // 获取路径的存储空间信息
            StatFs statFs = new StatFs(path);
            // 单个数据块的大小、数据块数量、空闲的数据块数量
            long blockSize, blockCount, availableBlocks;
            // 版本兼容
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
                availableBlocks = statFs.getAvailableBlocks();
            }
            // 返回已使用空间大小
            return ((blockCount - availableBlocks) * blockSize);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getUsedBlocks");
        }
        return 0L;
    }

    /**
     * 返回对应路径的空间大小信息
     * @param path 路径
     * @return long[], 0 = 总空间大小, 1 = 空闲空间大小, 2 = 已使用空间大小
     */
    public static long[] getBlockSizeInfos(final String path) {
        try {
            // 获取路径的存储空间信息
            StatFs statFs = new StatFs(path);
            // 单个数据块的大小、数据块数量、空闲的数据块数量
            long blockSize, blockCount, availableBlocks;
            // 版本兼容
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
                availableBlocks = statFs.getAvailableBlocks();
            }
            // 计算空间信息
            long[] blocks = new long[3];
            blocks[0] = blockSize * blockCount;
            blocks[1] = blockSize * availableBlocks;
            blocks[2] = ((blockCount - availableBlocks) * blockSize);
            // 返回空间信息
            return blocks;
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getBlockSizeInfos");
        }
        return null;
    }

    // ======================
    // = 其他工具类实现代码 =
    // ======================

    // =============
    // = FileUtils =
    // =============

    /**
     * 获取文件
     * @param filePath 文件路径
     * @param fileName 文件名
     * @return 文件 {@link File}
     */
    private static File getFile(final String filePath, final String fileName) {
        return (filePath != null && fileName != null) ? new File(filePath, fileName) : null;
    }

    /**
     * 获取文件绝对路径
     * @param file 文件
     * @return 文件绝对路径
     */
    private static String getAbsolutePath(final File file) {
        return file != null ? file.getAbsolutePath() : null;
    }

    // ============
    // = AppUtils =
    // ============

    /**
     * 获取 StorageManager
     * @return {@link StorageManager}
     */
    private static StorageManager getStorageManager() {
        return getSystemService(Context.STORAGE_SERVICE);
    }

    /**
     * 获取 SystemService
     * @param name 服务名
     * @param <T>  泛型
     * @return SystemService Object
     */
    private static <T> T getSystemService(final String name) {
        if (isSpace(name)) return null;
        try {
            return (T) DevUtils.getContext().getSystemService(name);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getSystemService");
        }
        return null;
    }

    // ===============
    // = StringUtils =
    // ===============

    /**
     * 判断字符串是否为 null 或全为空白字符
     * @param str 待校验字符串
     * @return {@code true} yes, {@code false} no
     */
    private static boolean isSpace(final String str) {
        if (str == null) return true;
        for (int i = 0, len = str.length(); i < len; ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}