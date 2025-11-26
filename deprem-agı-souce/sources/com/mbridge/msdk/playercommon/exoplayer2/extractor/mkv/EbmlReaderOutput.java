package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

interface EbmlReaderOutput {
    public static final int TYPE_BINARY = 4;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_MASTER = 1;
    public static final int TYPE_STRING = 3;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_UNSIGNED_INT = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ElementType {
    }

    void binaryElement(int i5, int i6, ExtractorInput extractorInput) throws IOException, InterruptedException;

    void endMasterElement(int i5) throws ParserException;

    void floatElement(int i5, double d5) throws ParserException;

    int getElementType(int i5);

    void integerElement(int i5, long j5) throws ParserException;

    boolean isLevel1Element(int i5);

    void startMasterElement(int i5, long j5, long j6) throws ParserException;

    void stringElement(int i5, String str) throws ParserException;
}
