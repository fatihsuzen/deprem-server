package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;

final class DefaultEbmlReader implements EbmlReader {
    private static final int ELEMENT_STATE_READ_CONTENT = 2;
    private static final int ELEMENT_STATE_READ_CONTENT_SIZE = 1;
    private static final int ELEMENT_STATE_READ_ID = 0;
    private static final int MAX_ID_BYTES = 4;
    private static final int MAX_INTEGER_ELEMENT_SIZE_BYTES = 8;
    private static final int MAX_LENGTH_BYTES = 8;
    private static final int VALID_FLOAT32_ELEMENT_SIZE_BYTES = 4;
    private static final int VALID_FLOAT64_ELEMENT_SIZE_BYTES = 8;
    private long elementContentSize;
    private int elementId;
    private int elementState;
    private final ArrayDeque<MasterElement> masterElementsStack = new ArrayDeque<>();
    private EbmlReaderOutput output;
    private final byte[] scratch = new byte[8];
    private final VarintReader varintReader = new VarintReader();

    @Retention(RetentionPolicy.SOURCE)
    private @interface ElementState {
    }

    private static final class MasterElement {
        /* access modifiers changed from: private */
        public final long elementEndPosition;
        /* access modifiers changed from: private */
        public final int elementId;

        private MasterElement(int i5, long j5) {
            this.elementId = i5;
            this.elementEndPosition = j5;
        }
    }

    private long maybeResyncToNextLevel1Element(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.resetPeekPosition();
        while (true) {
            extractorInput.peekFully(this.scratch, 0, 4);
            int parseUnsignedVarintLength = VarintReader.parseUnsignedVarintLength(this.scratch[0]);
            if (parseUnsignedVarintLength != -1 && parseUnsignedVarintLength <= 4) {
                int assembleVarint = (int) VarintReader.assembleVarint(this.scratch, parseUnsignedVarintLength, false);
                if (this.output.isLevel1Element(assembleVarint)) {
                    extractorInput.skipFully(parseUnsignedVarintLength);
                    return (long) assembleVarint;
                }
            }
            extractorInput.skipFully(1);
        }
    }

    private double readFloat(ExtractorInput extractorInput, int i5) throws IOException, InterruptedException {
        long readInteger = readInteger(extractorInput, i5);
        if (i5 == 4) {
            return (double) Float.intBitsToFloat((int) readInteger);
        }
        return Double.longBitsToDouble(readInteger);
    }

    private long readInteger(ExtractorInput extractorInput, int i5) throws IOException, InterruptedException {
        extractorInput.readFully(this.scratch, 0, i5);
        long j5 = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            j5 = (j5 << 8) | ((long) (this.scratch[i6] & 255));
        }
        return j5;
    }

    private String readString(ExtractorInput extractorInput, int i5) throws IOException, InterruptedException {
        if (i5 == 0) {
            return "";
        }
        byte[] bArr = new byte[i5];
        extractorInput.readFully(bArr, 0, i5);
        while (i5 > 0 && bArr[i5 - 1] == 0) {
            i5--;
        }
        return new String(bArr, 0, i5);
    }

    public final void init(EbmlReaderOutput ebmlReaderOutput) {
        this.output = ebmlReaderOutput;
    }

    public final boolean read(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z4;
        if (this.output != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        while (true) {
            if (this.masterElementsStack.isEmpty() || extractorInput.getPosition() < this.masterElementsStack.peek().elementEndPosition) {
                if (this.elementState == 0) {
                    long readUnsignedVarint = this.varintReader.readUnsignedVarint(extractorInput, true, false, 4);
                    if (readUnsignedVarint == -2) {
                        readUnsignedVarint = maybeResyncToNextLevel1Element(extractorInput);
                    }
                    if (readUnsignedVarint == -1) {
                        return false;
                    }
                    this.elementId = (int) readUnsignedVarint;
                    this.elementState = 1;
                }
                if (this.elementState == 1) {
                    this.elementContentSize = this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
                    this.elementState = 2;
                }
                int elementType = this.output.getElementType(this.elementId);
                if (elementType == 0) {
                    extractorInput.skipFully((int) this.elementContentSize);
                    this.elementState = 0;
                } else if (elementType == 1) {
                    long position = extractorInput.getPosition();
                    this.masterElementsStack.push(new MasterElement(this.elementId, this.elementContentSize + position));
                    this.output.startMasterElement(this.elementId, position, this.elementContentSize);
                    this.elementState = 0;
                    return true;
                } else if (elementType == 2) {
                    long j5 = this.elementContentSize;
                    if (j5 <= 8) {
                        this.output.integerElement(this.elementId, readInteger(extractorInput, (int) j5));
                        this.elementState = 0;
                        return true;
                    }
                    throw new ParserException("Invalid integer size: " + this.elementContentSize);
                } else if (elementType == 3) {
                    long j6 = this.elementContentSize;
                    if (j6 <= 2147483647L) {
                        this.output.stringElement(this.elementId, readString(extractorInput, (int) j6));
                        this.elementState = 0;
                        return true;
                    }
                    throw new ParserException("String element size: " + this.elementContentSize);
                } else if (elementType == 4) {
                    this.output.binaryElement(this.elementId, (int) this.elementContentSize, extractorInput);
                    this.elementState = 0;
                    return true;
                } else if (elementType == 5) {
                    long j7 = this.elementContentSize;
                    if (j7 == 4 || j7 == 8) {
                        this.output.floatElement(this.elementId, readFloat(extractorInput, (int) j7));
                        this.elementState = 0;
                        return true;
                    }
                    throw new ParserException("Invalid float size: " + this.elementContentSize);
                } else {
                    throw new ParserException("Invalid element type " + elementType);
                }
            } else {
                this.output.endMasterElement(this.masterElementsStack.pop().elementId);
                return true;
            }
        }
    }

    public final void reset() {
        this.elementState = 0;
        this.masterElementsStack.clear();
        this.varintReader.reset();
    }
}
