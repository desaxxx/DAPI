package org.nandayo.DAPI.object.annotation;

import org.jetbrains.annotations.ApiStatus;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiStatus.Internal
public @interface DRenamed {

    String since();
    String from();
}
