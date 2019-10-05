package cn.anyplayer.simple.data.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 映射数据表与实体类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

    /**
     * 数据表表名
     *
     * @return
     */
    String value() default "";

    /**
     * 数据表表名
     *
     * @return
     */
    String name() default "";


    /**
     * 主键Id对应的字段名
     *
     * @return
     */
    String column() default "id";


    //主键Id对应的属性名
    //String property() default "id";

}
