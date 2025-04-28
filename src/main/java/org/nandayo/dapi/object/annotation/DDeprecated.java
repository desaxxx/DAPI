package org.nandayo.dapi.object.annotation;

import org.jetbrains.annotations.ApiStatus;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiStatus.Internal
public @interface DDeprecated {

    String since();
}
