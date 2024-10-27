package com.ffi_benchmark;

import com.google.flatbuffers.FlatBufferBuilder;

public class FlatBufferDemo {
    static {
        System.loadLibrary("flatbufferdemo");
    }

    public native void readFlatBufferCpp(byte[] messageData);

    public void writeUserData() {
        FlatBufferBuilder builder = new FlatBufferBuilder(1024);

        int nameoff = builder.createString("Yogesh");
        int gender = builder.createString("Male");

        Person.startPerson(builder);
        Person.addName(builder, nameoff);
        Person.addGender(builder, gender);
        Person.addAge(builder, (int)21);

        int person = Person.endPerson(builder);
        builder.finish(person);

        byte[] messageData = builder.sizedByteArray();
        
        readFlatBufferCpp(messageData);

    }
}