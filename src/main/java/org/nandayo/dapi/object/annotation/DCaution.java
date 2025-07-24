package org.nandayo.dapi.object.annotation;

import org.jetbrains.annotations.ApiStatus;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiStatus.Internal
public @interface DCaution {

    String description();
    String deprecatedSince();
    String restoredSince();
}
