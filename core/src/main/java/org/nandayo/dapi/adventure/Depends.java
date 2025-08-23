package org.nandayo.dapi.adventure;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @since 1.4.0
 */
interface Depends {

    Set<ConstantInfo> dependants();
    default Set<ConstantInfo> dependantsWithin(Collection<ConstantInfo> constants) {
        Set<ConstantInfo> result = new HashSet<>();
        for(ConstantInfo c : constants) {
            if(dependants().contains(c)) {
                result.add(c);
            }
        }
        return result;
    }
}
