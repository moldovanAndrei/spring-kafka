/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.spring.kafka.datagenerator.data.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AvroEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 825107733627863295L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroEvent\",\"namespace\":\"org.spring.kafka.datagenerator.data.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"type\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"gps\",\"type\":{\"type\":\"record\",\"name\":\"AvroGps\",\"fields\":[{\"name\":\"long\",\"type\":\"double\"},{\"name\":\"lat\",\"type\":\"double\"}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AvroEvent> ENCODER =
      new BinaryMessageEncoder<AvroEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AvroEvent> DECODER =
      new BinaryMessageDecoder<AvroEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<AvroEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<AvroEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AvroEvent>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this AvroEvent to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a AvroEvent from a ByteBuffer. */
  public static AvroEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private long id;
   private java.lang.String type;
   private org.spring.kafka.datagenerator.data.avro.AvroGps gps;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AvroEvent() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param type The new value for type
   * @param gps The new value for gps
   */
  public AvroEvent(java.lang.Long id, java.lang.String type, org.spring.kafka.datagenerator.data.avro.AvroGps gps) {
    this.id = id;
    this.type = type;
    this.gps = gps;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return type;
    case 2: return gps;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: type = (java.lang.String)value$; break;
    case 2: gps = (org.spring.kafka.datagenerator.data.avro.AvroGps)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public java.lang.String getType() {
    return type;
  }

  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(java.lang.String value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'gps' field.
   * @return The value of the 'gps' field.
   */
  public org.spring.kafka.datagenerator.data.avro.AvroGps getGps() {
    return gps;
  }

  /**
   * Sets the value of the 'gps' field.
   * @param value the value to set.
   */
  public void setGps(org.spring.kafka.datagenerator.data.avro.AvroGps value) {
    this.gps = value;
  }

  /**
   * Creates a new AvroEvent RecordBuilder.
   * @return A new AvroEvent RecordBuilder
   */
  public static org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder newBuilder() {
    return new org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder();
  }

  /**
   * Creates a new AvroEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroEvent RecordBuilder
   */
  public static org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder newBuilder(org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder other) {
    return new org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder(other);
  }

  /**
   * Creates a new AvroEvent RecordBuilder by copying an existing AvroEvent instance.
   * @param other The existing instance to copy.
   * @return A new AvroEvent RecordBuilder
   */
  public static org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder newBuilder(org.spring.kafka.datagenerator.data.avro.AvroEvent other) {
    return new org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder(other);
  }

  /**
   * RecordBuilder for AvroEvent instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroEvent>
    implements org.apache.avro.data.RecordBuilder<AvroEvent> {

    private long id;
    private java.lang.String type;
    private org.spring.kafka.datagenerator.data.avro.AvroGps gps;
    private org.spring.kafka.datagenerator.data.avro.AvroGps.Builder gpsBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.type)) {
        this.type = data().deepCopy(fields()[1].schema(), other.type);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.gps)) {
        this.gps = data().deepCopy(fields()[2].schema(), other.gps);
        fieldSetFlags()[2] = true;
      }
      if (other.hasGpsBuilder()) {
        this.gpsBuilder = org.spring.kafka.datagenerator.data.avro.AvroGps.newBuilder(other.getGpsBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing AvroEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(org.spring.kafka.datagenerator.data.avro.AvroEvent other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.type)) {
        this.type = data().deepCopy(fields()[1].schema(), other.type);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.gps)) {
        this.gps = data().deepCopy(fields()[2].schema(), other.gps);
        fieldSetFlags()[2] = true;
      }
      this.gpsBuilder = null;
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.Long getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public java.lang.String getType() {
      return type;
    }

    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder setType(java.lang.String value) {
      validate(fields()[1], value);
      this.type = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder clearType() {
      type = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'gps' field.
      * @return The value.
      */
    public org.spring.kafka.datagenerator.data.avro.AvroGps getGps() {
      return gps;
    }

    /**
      * Sets the value of the 'gps' field.
      * @param value The value of 'gps'.
      * @return This builder.
      */
    public org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder setGps(org.spring.kafka.datagenerator.data.avro.AvroGps value) {
      validate(fields()[2], value);
      this.gpsBuilder = null;
      this.gps = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'gps' field has been set.
      * @return True if the 'gps' field has been set, false otherwise.
      */
    public boolean hasGps() {
      return fieldSetFlags()[2];
    }

    /**
     * Gets the Builder instance for the 'gps' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public org.spring.kafka.datagenerator.data.avro.AvroGps.Builder getGpsBuilder() {
      if (gpsBuilder == null) {
        if (hasGps()) {
          setGpsBuilder(org.spring.kafka.datagenerator.data.avro.AvroGps.newBuilder(gps));
        } else {
          setGpsBuilder(org.spring.kafka.datagenerator.data.avro.AvroGps.newBuilder());
        }
      }
      return gpsBuilder;
    }

    /**
     * Sets the Builder instance for the 'gps' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder setGpsBuilder(org.spring.kafka.datagenerator.data.avro.AvroGps.Builder value) {
      clearGps();
      gpsBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'gps' field has an active Builder instance
     * @return True if the 'gps' field has an active Builder instance
     */
    public boolean hasGpsBuilder() {
      return gpsBuilder != null;
    }

    /**
      * Clears the value of the 'gps' field.
      * @return This builder.
      */
    public org.spring.kafka.datagenerator.data.avro.AvroEvent.Builder clearGps() {
      gps = null;
      gpsBuilder = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AvroEvent build() {
      try {
        AvroEvent record = new AvroEvent();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.type = fieldSetFlags()[1] ? this.type : (java.lang.String) defaultValue(fields()[1]);
        if (gpsBuilder != null) {
          record.gps = this.gpsBuilder.build();
        } else {
          record.gps = fieldSetFlags()[2] ? this.gps : (org.spring.kafka.datagenerator.data.avro.AvroGps) defaultValue(fields()[2]);
        }
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AvroEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<AvroEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AvroEvent>
    READER$ = (org.apache.avro.io.DatumReader<AvroEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
