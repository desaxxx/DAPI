package org.nandayo.dapi.editor;

import java.io.*;

/**
 * Utility for deep-copying objects via Java serialization.
 * <pre>
 * Requirements:
 *   - The object (and all its field types) must implement java.io.Serializable.
 *   - This is the safest, most straightforward approach for plugin data objects.
 *
 * If your objects are NOT serializable, you have two alternatives:
 *   A) Implement Serializable on them (recommended — add "implements Serializable").
 *   B) Replace deepCopy() with a manual clone strategy or a library like Kryo.
 * </pre>
 * The copy is used as the "working copy" during editing.
 * The original object is only overwritten when the player hits Save.
 */
public final class DeepCopyUtil {

    private DeepCopyUtil() {}

    /**
     * Creates a deep copy of the object via serialization.
     *
     * @throws RuntimeException if the object or any of its fields are not serializable.
     */
    @SuppressWarnings("unchecked")
    public static <T> T deepCopy(T object) {
        try {
            // Serialize to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
                oos.writeObject(object);
            }

            // Deserialize a fresh instance
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            try (ObjectInputStream ois = new ObjectInputStream(bis)) {
                return (T) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(
                "Failed to deep-copy object of type: " + object.getClass().getName()
                + ". Make sure the class and all its fields implement java.io.Serializable.",
                e
            );
        }
    }
}
