package ultimate.bravery.task1;

/**
 * Created by anton on 07/03/2016.
 * <p>
 * this is the serializer interface
 * <p>
 * note: when deserializing into an existing instance: all of the existing values should be overwritten by
 * values provided in the serialized string.
 * if a value is omitted in the serialized string - the convention is to set null over the additional fields in the
 * code.
 */
public interface SpecialSerializer {

    /**
     * returns a string representation of an instance.
     * the challenge here is not to use an existing library but to write the serializer by hand.
     *
     * @return a string representation of the instance (a serialization)
     */
    String serialize() throws InvalidBinaryTreeException;

    /**
     * override all of the values of the current instance using values present in the serialized string provided.
     * if null the behaviour is to not do anything to the current instance.
     *
     * @param serialized a serialized representation of an instance
     */
    void deserializeInto(String serialized) throws InvalidBinaryTreeException;

}
