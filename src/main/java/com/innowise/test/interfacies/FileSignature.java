package com.innowise.test.interfacies;

public interface FileSignature {

    byte[] HEAD_ZIP = {0x50, 0x4B};
    byte[] HEAD_SEVEN_ZIP = {0x37, 0x7A};
    byte[] HEAD_RAR = {0x52,0x61,0x72};

    static boolean signatureFound(final byte[] bytes, final byte[] expectedHeadingBytes){
        for (int i = 0; i < expectedHeadingBytes.length; i++){
            if(i >= bytes.length || bytes[i] != expectedHeadingBytes[i]){
                return false;
            }
        }
        return true;
    }
}
