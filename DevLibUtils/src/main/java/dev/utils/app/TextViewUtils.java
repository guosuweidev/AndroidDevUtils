package dev.utils.app;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import dev.utils.LogPrintUtils;

/**
 * detail: TextView 工具类
 * @author Ttt
 * <pre>
 *      获取字体信息 Paint.FontMetrics
 *      @see <a href="https://blog.csdn.net/superbigcupid/article/details/47153139"/>
 *      将字画在矩形背景的正中位置
 *      @see <a href="https://blog.csdn.net/superbigcupid/article/details/47153139"/>
 *      控制文字水平间距:
 *      android:letterSpacing
 *      控制文字行间距:
 *      android:lineSpacingExtra
 * </pre>
 */
public final class TextViewUtils {

    private TextViewUtils() {
    }

    // 日志 TAG
    private static final String TAG = TextViewUtils.class.getSimpleName();

    /**
     * 获取 TextView
     * @param view {@link View}
     * @return {@link TextView}
     */
    public static TextView getTextView(final View view) {
        if (view != null) {
            try {
                return (TextView) view;
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "getTextView");
            }
        }
        return null;
    }

    /**
     * 获取 TextView
     * @param view {@link View}
     * @param id   R.id.viewId
     * @return {@link TextView}
     */
    public static TextView getTextView(final View view, @IdRes final int id) {
        if (view != null) {
            try {
                return view.findViewById(id);
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "getTextView");
            }
        }
        return null;
    }

    /**
     * 获取 TextView
     * @param activity {@link Activity}
     * @param id       R.id.viewId
     * @return {@link TextView}
     */
    public static TextView getTextView(final Activity activity, @IdRes final int id) {
        if (activity != null) {
            try {
                return activity.findViewById(id);
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "getTextView");
            }
        }
        return null;
    }

    /**
     * 获取 TextView
     * @param window {@link Window}
     * @param id     R.id.viewId
     * @return {@link TextView}
     */
    public static TextView getTextView(final Window window, @IdRes final int id) {
        if (window != null) {
            try {
                return window.findViewById(id);
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "getTextView");
            }
        }
        return null;
    }

    // =

    /**
     * 获取文本
     * @param textView {@link TextView}
     * @return {@link TextView#getText()}
     */
    public static String getText(final TextView textView) {
        if (textView != null) {
            return textView.getText().toString();
        }
        return null;
    }

    /**
     * 获取文本
     * @param view {@link TextView}
     * @return {@link TextView#getText()}
     */
    public static String getText(final View view) {
        if (view != null) {
            try {
                return ((TextView) view).getText().toString();
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "getText");
            }
        }
        return null;
    }

    /**
     * 获取文本
     * @param view {@link View}
     * @param id   R.id.viewId
     * @return {@link TextView#getText()}
     */
    public static String getText(final View view, @IdRes final int id) {
        if (view != null) {
            try {
                return ((TextView) view.findViewById(id)).getText().toString();
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "getText");
            }
        }
        return null;
    }

    /**
     * 获取文本
     * @param activity {@link Activity}
     * @param id       R.id.viewId
     * @return {@link TextView#getText()}
     */
    public static String getText(final Activity activity, @IdRes final int id) {
        if (activity != null) {
            try {
                return ((TextView) activity.findViewById(id)).getText().toString();
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "getText");
            }
        }
        return null;
    }

    /**
     * 获取文本
     * @param window {@link Window}
     * @param id     R.id.viewId
     * @return {@link TextView#getText()}
     */
    public static String getText(final Window window, @IdRes final int id) {
        if (window != null) {
            try {
                return ((TextView) window.findViewById(id)).getText().toString();
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "getText");
            }
        }
        return null;
    }

    // =

    /**
     * 设置是否加粗
     * @param view   {@link TextView}
     * @param isBold {@code true} yes, {@code false} no
     */
    public static void setBold(final View view, final boolean isBold) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(Typeface.defaultFromStyle(isBold ? Typeface.BOLD : Typeface.NORMAL));
            }
        }
    }

    /**
     * 设置是否加粗
     * @param view     {@link TextView}
     * @param typeface {@link Typeface} 字体样式
     * @param isBold   {@code true} yes, {@code false} no
     */
    public static void setBold(final View view, final Typeface typeface, final boolean isBold) {
        if (view != null && typeface != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(typeface, isBold ? Typeface.BOLD : Typeface.NORMAL);
            }
        }
    }

    /**
     * 设置字体颜色
     * @param view  {@link TextView}
     * @param color R.color.id
     */
    public static void setTextColor(final View view, @ColorInt final int color) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(color);
            }
        }
    }

    /**
     * 设置字体颜色
     * @param textView {@link TextView}
     * @param color    R.color.id
     */
    public static void setTextColor(final TextView textView, @ColorInt final int color) {
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    /**
     * 设置字体颜色
     * @param view  {@link View}
     * @param id    R.id.viewId
     * @param color R.color.id
     */
    public static void setTextColor(final View view, @IdRes final int id, @ColorInt final int color) {
        if (view != null) {
            try {
                ((TextView) view.findViewById(id)).setTextColor(color);
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "setTextColor");
            }
        }
    }

    /**
     * 设置字体颜色
     * @param activity {@link Activity}
     * @param id       R.id.viewId
     * @param color    R.color.id
     */
    public static void setTextColor(final Activity activity, @IdRes final int id, @ColorInt final int color) {
        if (activity != null) {
            try {
                ((TextView) activity.findViewById(id)).setTextColor(color);
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "setTextColor");
            }
        }
    }

    /**
     * 设置字体颜色
     * @param window {@link Window}
     * @param id     R.id.viewId
     * @param color  R.color.id
     */
    public static void setTextColor(final Window window, @IdRes final int id, @ColorInt final int color) {
        if (window != null) {
            try {
                ((TextView) window.findViewById(id)).setTextColor(color);
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "setTextColor");
            }
        }
    }

    /**
     * 设置字体
     * @param textView {@link TextView}
     * @param typeface {@link Typeface} 字体样式
     */
    public static void setTypeface(final TextView textView, final Typeface typeface) {
        if (textView != null && typeface != null) {
            textView.setTypeface(typeface);
        }
    }

    /**
     * 设置字体
     * @param textView {@link TextView}
     * @param typeface {@link Typeface} 字体样式
     * @param style    样式
     */
    public static void setTypeface(final TextView textView, final Typeface typeface, final int style) {
        if (textView != null && typeface != null) {
            textView.setTypeface(typeface, style);
        }
    }

    /**
     * 设置字体
     * @param view     {@link TextView}
     * @param typeface {@link Typeface} 字体样式
     */
    public static void setTypeface(final View view, final Typeface typeface) {
        if (view != null && typeface != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(typeface);
            }
        }
    }

    /**
     * 设置字体
     * @param view     {@link TextView}
     * @param typeface {@link Typeface} 字体样式
     * @param style    样式
     */
    public static void setTypeface(final View view, final Typeface typeface, final int style) {
        if (view != null && typeface != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(typeface, style);
            }
        }
    }

    // =

    /**
     * 清空 flags
     * @param textView {@link TextView}
     */
    public static void clearFlags(final TextView textView) {
        if (textView != null) {
            textView.setPaintFlags(0);
        }
    }

    /**
     * 清空 flags
     * @param view {@link TextView}
     */
    public static void clearFlags(final View view) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setPaintFlags(0);
            }
        }
    }

    // =

    /**
     * 设置下划线
     * @param textView {@link TextView}
     */
    public static void setUnderlineText(final TextView textView) {
        setUnderlineText(textView, true);
    }

    /**
     * 设置下划线并加清晰
     * @param textView    {@link TextView}
     * @param isAntiAlias 是否消除锯齿
     */
    public static void setUnderlineText(final TextView textView, final boolean isAntiAlias) {
        if (textView != null) {
            textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            if (isAntiAlias) {
                textView.setPaintFlags(textView.getPaintFlags() | Paint.ANTI_ALIAS_FLAG);
            }
        }
    }

    /**
     * 设置下划线
     * @param view {@link TextView}
     */
    public static void setUnderlineText(final View view) {
        setUnderlineText(view, true);
    }

    /**
     * 设置下划线并加清晰
     * @param view        {@link TextView}
     * @param isAntiAlias 是否消除锯齿
     */
    public static void setUnderlineText(final View view, final boolean isAntiAlias) {
        if (view != null && view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            if (isAntiAlias) {
                textView.setPaintFlags(textView.getPaintFlags() | Paint.ANTI_ALIAS_FLAG);
            }
        }
    }

    // =

    /**
     * 设置中划线
     * @param textView {@link TextView}
     */
    public static void setStrikeThruText(final TextView textView) {
        setStrikeThruText(textView, true);
    }

    /**
     * 设置中划线并加清晰
     * @param textView    {@link TextView}
     * @param isAntiAlias 是否消除锯齿
     */
    public static void setStrikeThruText(final TextView textView, final boolean isAntiAlias) {
        if (textView != null) {
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            if (isAntiAlias) {
                textView.setPaintFlags(textView.getPaintFlags() | Paint.ANTI_ALIAS_FLAG);
            }
        }
    }

    /**
     * 设置中划线
     * @param view {@link TextView}
     */
    public static void setStrikeThruText(final View view) {
        setStrikeThruText(view, true);
    }

    /**
     * 设置中划线并加清晰
     * @param view        {@link TextView}
     * @param isAntiAlias 是否消除锯齿
     */
    public static void setStrikeThruText(final View view, final boolean isAntiAlias) {
        if (view != null && view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            if (isAntiAlias) {
                textView.setPaintFlags(textView.getPaintFlags() | Paint.ANTI_ALIAS_FLAG);
            }
        }
    }

    // =

    /**
     * 设置文本
     * @param textView {@link TextView}
     * @param text     TextView text
     */
    public static void setText(final TextView textView, final String text) {
        if (textView != null) {
            textView.setText(text);
        }
    }

    /**
     * 设置文本
     * @param view {@link TextView}
     * @param text TextView text
     */
    public static void setText(final View view, final String text) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            }
        }
    }

    /**
     * 设置文本
     * @param view {@link View}
     * @param id   R.id.viewId
     * @param text TextView text
     */
    public static void setText(final View view, @IdRes final int id, final String text) {
        if (view != null) {
            try {
                ((TextView) view.findViewById(id)).setText(text);
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "setText");
            }
        }
    }

    /**
     * 设置文本
     * @param activity {@link Activity}
     * @param id       R.id.viewId
     * @param text     TextView text
     */
    public static void setText(final Activity activity, @IdRes final int id, final String text) {
        if (activity != null) {
            try {
                ((TextView) activity.findViewById(id)).setText(text);
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "setText");
            }
        }
    }

    /**
     * 设置文本
     * @param window {@link Window}
     * @param id     R.id.viewId
     * @param text   TextView text
     */
    public static void setText(final Window window, @IdRes final int id, final String text) {
        if (window != null) {
            try {
                ((TextView) window.findViewById(id)).setText(text);
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "setText");
            }
        }
    }

    /**
     * 设置多个 TextView 文本
     * @param text  TextView text
     * @param views View(TextView)[]
     */
    public static void setTexts(final String text, final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                setText(view, text);
            }
        }
    }

    /**
     * 设置多个 TextView 文本
     * @param text  TextView text
     * @param views TextView[]
     */
    public static void setTexts(final String text, final TextView... views) {
        if (views != null && views.length > 0) {
            for (TextView view : views) {
                setText(view, text);
            }
        }
    }

    // =

    /**
     * 设置 Html 内容
     * @param textView {@link TextView}
     * @param content  Html content
     */
    public static void setHtmlText(final TextView textView, final String content) {
        if (textView != null && content != null) {
            textView.setText(Html.fromHtml(content));
        }
    }

    /**
     * 设置 Html 内容
     * @param view    {@link TextView}
     * @param content Html content
     */
    public static void setHtmlText(final View view, final String content) {
        if (view != null && content != null) {
            if (view instanceof TextView) {
                ((TextView) view).setText(Html.fromHtml(content));
            }
        }
    }

    /**
     * 设置 Html 内容
     * @param view    {@link View}
     * @param id      R.id.viewId
     * @param content Html content
     */
    public static void setHtmlText(final View view, @IdRes final int id, final String content) {
        if (view != null && content != null) {
            try {
                ((TextView) view.findViewById(id)).setText(Html.fromHtml(content));
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "setHtmlText");
            }
        }
    }

    /**
     * 设置 Html 内容
     * @param activity {@link Activity}
     * @param id       R.id.viewId
     * @param content  Html content
     */
    public static void setHtmlText(final Activity activity, @IdRes final int id, final String content) {
        if (activity != null && content != null) {
            try {
                ((TextView) activity.findViewById(id)).setText(Html.fromHtml(content));
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "setHtmlText");
            }
        }
    }

    /**
     * 设置 Html 内容
     * @param window  {@link Window}
     * @param id      R.id.viewId
     * @param content Html content
     */
    public static void setHtmlText(final Window window, @IdRes final int id, final String content) {
        if (window != null && content != null) {
            try {
                ((TextView) window.findViewById(id)).setText(Html.fromHtml(content));
            } catch (Exception e) {
                LogPrintUtils.eTag(TAG, e, "setHtmlText");
            }
        }
    }

    // =

    /**
     * 设置多个 TextView Html 内容
     * @param content Html content
     * @param views   View(TextView)[]
     */
    public static void setHtmlTexts(final String content, final View... views) {
        if (content != null && views != null && views.length > 0) {
            for (View view : views) {
                setHtmlText(view, content);
            }
        }
    }

    /**
     * 设置多个 TextView Html 内容
     * @param content Html content
     * @param views   TextView[]
     */
    public static void setHtmlTexts(final String content, final TextView... views) {
        if (content != null && views != null && views.length > 0) {
            for (TextView view : views) {
                setHtmlText(view, content);
            }
        }
    }

    // =

    /**
     * 获取字体高度
     * @param textView {@link TextView}
     * @return 字体高度
     */
    public static int getTextHeight(final TextView textView) {
        if (textView != null) {
            return getTextHeight(textView.getPaint());
        }
        return 0;
    }

    /**
     * 获取字体高度
     * @param paint {@link TextView#getPaint()}
     * @return 字体高度
     */
    public static int getTextHeight(final Paint paint) {
        // 获取字体高度
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        // 计算内容高度
        int tHeight = (int) Math.ceil((fontMetrics.descent - fontMetrics.ascent));
        // 返回字体高度
        return tHeight;
    }

    /**
     * 获取字体顶部偏移高度
     * @param textView {@link TextView}
     * @return 字体顶部偏移高度
     */
    public static int getTextTopOffsetHeight(final TextView textView) {
        if (textView != null) {
            return getTextTopOffsetHeight(textView.getPaint());
        }
        return 0;
    }

    /**
     * 获取字体顶部偏移高度
     * @param paint {@link TextView#getPaint()}
     * @return 字体顶部偏移高度
     */
    public static int getTextTopOffsetHeight(final Paint paint) {
        // 获取字体高度
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        // 计算字体偏差(顶部偏差)
        int baseLine = (int) Math.ceil(Math.abs(fontMetrics.top) - Math.abs(fontMetrics.ascent));
        // 返回顶部偏差
        return baseLine;
    }

    /**
     * 计算字体宽度
     * @param textView {@link TextView}
     * @return 字体宽度
     */
    public static float getTextWidth(final TextView textView) {
        return getTextWidth(textView.getPaint(), textView.getText().toString());
    }

    /**
     * 计算字体宽度
     * @param paint {@link TextView#getPaint()}
     * @param text  待计算的文本
     * @return 字体宽度
     */
    public static float getTextWidth(final Paint paint, final String text) {
        return paint.measureText(text);
    }

    /**
     * 获取画布中间居中位置
     * @param targetRect {@link Rect} 目标坐标
     * @param paint      {@link TextView#getPaint()}
     * @return 画布 Y 轴居中位置
     */
    public static int getCenterRectY(final Rect targetRect, final Paint paint) {
        // 获取字体高度
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        // 获取底部 Y 轴居中位置
        return targetRect.top + (targetRect.bottom - targetRect.top) / 2 - (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.top;
        // canvas.drawText(testString, targetRect.centerX(), baseline, paint);
    }

    /**
     * 通过需要的高度, 计算字体大小
     * @param textHeight 需要的字体高度
     * @return 字体大小
     */
    public static float reckonTextSize(final int textHeight) {
        // 创建画笔
        Paint paint = new Paint();
        // 默认字体大小
        float textSize = 90.0f;
        // 计算内容高度
        int calcTextHeight = -1;
        // 循环计算
        while (true) {
            // 设置画笔大小
            paint.setTextSize(textSize);
            // 获取字体高度
            Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
            // 计算内容高度
            calcTextHeight = (int) Math.ceil((fontMetrics.descent - fontMetrics.ascent));
            // 符合条件则直接返回
            if (calcTextHeight == textHeight) {
                return textSize;
            } else if (calcTextHeight > textHeight) { // 如果计算的字体高度大于
                textSize -= 0.5f;
            } else {
                textSize += 0.5f;
            }
        }
    }

    /**
     * 计算第几位超过宽度
     * @param textView {@link TextView}
     * @param width    指定的宽度
     * @return -1 表示没超过, 其他值表示对应的索引位置
     */
    public static int calcTextWidth(final TextView textView, final float width) {
        if (textView != null) {
            return calcTextWidth(textView.getPaint(), textView.getText().toString(), width);
        }
        return -1;
    }

    /**
     * 计算第几位超过宽度
     * @param paint {@link TextView#getPaint()}
     * @param text  文本内容
     * @param width 指定的宽度
     * @return -1 表示没超过, 其他值表示对应的索引位置
     */
    public static int calcTextWidth(final Paint paint, final String text, final float width) {
        // 先获取宽度
        float textWidth = getTextWidth(paint, text);
        // 判断是否超过
        if (textWidth <= width) {
            return -1; // 表示没超过
        }
        // 获取数据长度
        int length = text.length();
        // 循环除 2
        while (true) {
            // 数据至少为 2 位以上
            if (length < 2) {
                return 0; // 表示第一位已经超过
            }
            // 从中间取值
            length = length / 2;
            // 计算宽度
            textWidth = getTextWidth(paint, text.substring(0, length));
            // 判断是否小于宽度 - 进行返回长度
            if (textWidth <= width) {
                break;
            }
        }
        // 遍历计算
        for (int i = length, len = text.length(); i < len; i++) {
            // 获取字体内容宽度
            float tWidth = paint.measureText(text.substring(0, i));
            // 判断是否大于指定宽度
            if (tWidth > width) {
                return i - 1; // 返回超过前的长度
            } else if (tWidth == width) {
                return i; // 返回超过前的长度
            }
        }
        return -1;
    }
}
