package androidx.profileinstaller;

enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);
    
    private final long mValue;

    private FileSectionType(long j5) {
        this.mValue = j5;
    }

    static FileSectionType fromValue(long j5) {
        FileSectionType[] values = values();
        for (int i5 = 0; i5 < values.length; i5++) {
            if (values[i5].getValue() == j5) {
                return values[i5];
            }
        }
        throw new IllegalArgumentException("Unsupported FileSection Type " + j5);
    }

    public long getValue() {
        return this.mValue;
    }
}
