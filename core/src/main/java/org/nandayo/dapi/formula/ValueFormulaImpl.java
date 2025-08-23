package org.nandayo.dapi.formula;

import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.util.DAPIException;
import org.nandayo.dapi.util.Validate;

import java.util.Locale;
import java.util.Map;

/**
 * @since 1.4.0
 */
abstract class ValueFormulaImpl implements ValueFormula {

    public static final Factory FACTORY = FactoryImpl.createFactory();


    @NotNull
    public static ValueFormula create(Map<String, Object> map) {
        Validate.notNull(map, "Map cannot be null.");
        ValueFormula.Type type = getType((String) map.get("type"));
        switch (type) {
            case SIMPLE:
                return SimpleValueFormulaImpl.deserialize(map);
            case CONDITIONAL:
                return ConditionalValueFormulaImpl.deserialize(map);
            case TABLE:
                return TableValueFormulaImpl.deserialize(map);
            default:
                throw new DAPIException("Invalid formula type.");
        }
    }

    @NotNull
    public static Type getType(String type) {
        try {
            return Type.valueOf(type.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException e) {
            return Type.SIMPLE;
        }
    }

    static abstract class ExpressionModifierImpl implements ExpressionModifier {
    }
}
