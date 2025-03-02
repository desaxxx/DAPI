package org.nandayo.DAPI.dobject;

import org.jetbrains.annotations.ApiStatus;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
@ApiStatus.Internal
public @interface DMerge {

    String since() default "";
}
