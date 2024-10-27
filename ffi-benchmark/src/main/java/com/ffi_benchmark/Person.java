// automatically generated by the FlatBuffers compiler, do not modify
package com.ffi_benchmark;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class Person extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_24_3_25(); }
  public static Person getRootAsPerson(ByteBuffer _bb) { return getRootAsPerson(_bb, new Person()); }
  public static Person getRootAsPerson(ByteBuffer _bb, Person obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Person __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String name() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer nameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  public int age() { int o = __offset(6); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public String gender() { int o = __offset(8); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer genderAsByteBuffer() { return __vector_as_bytebuffer(8, 1); }
  public ByteBuffer genderInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 8, 1); }

  public static int createPerson(FlatBufferBuilder builder,
      int nameOffset,
      int age,
      int genderOffset) {
    builder.startTable(3);
    Person.addGender(builder, genderOffset);
    Person.addAge(builder, age);
    Person.addName(builder, nameOffset);
    return Person.endPerson(builder);
  }

  public static void startPerson(FlatBufferBuilder builder) { builder.startTable(3); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(0, nameOffset, 0); }
  public static void addAge(FlatBufferBuilder builder, int age) { builder.addInt(1, age, 0); }
  public static void addGender(FlatBufferBuilder builder, int genderOffset) { builder.addOffset(2, genderOffset, 0); }
  public static int endPerson(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }
  public static void finishPersonBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
  public static void finishSizePrefixedPersonBuffer(FlatBufferBuilder builder, int offset) { builder.finishSizePrefixed(offset); }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Person get(int j) { return get(new Person(), j); }
    public Person get(Person obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

