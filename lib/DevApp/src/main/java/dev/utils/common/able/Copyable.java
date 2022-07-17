package dev.utils.common.able;

/**
 * detail: 通用 Copy 接口
 * @author Ttt
 * <pre>
 *     所有通用快捷 Copy 接口定义存储类
 *     全部接口只定义一个方法 copy() 且返回值一致
 *     唯一差异就是参数不同
 * </pre>
 */
public final class Copyable {

    private Copyable() {
    }

    // =======
    // = 无参 =
    // =======

    public interface Copy<T> {

        T copy();
    }

    // =======
    // = 有参 =
    // =======

    public interface CopyByParam<T, Param> {

        T copy(Param param);
    }

    public interface CopyByParam2<T, Param, Param2> {

        T copy(
                Param param,
                Param2 param2
        );
    }

    public interface CopyByParam3<T, Param, Param2, Param3> {

        T copy(
                Param param,
                Param2 param2,
                Param3 param3
        );
    }

    public interface CopyByParamArgs<T, Param> {

        T copy(Param... args);
    }
}