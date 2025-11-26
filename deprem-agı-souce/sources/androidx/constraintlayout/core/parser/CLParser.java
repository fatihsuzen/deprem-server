package androidx.constraintlayout.core.parser;

public class CLParser {
    static boolean sDebug = false;
    private String mContent;
    private boolean mHasComment = false;
    private int mLineNumber;

    enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i5, TYPE type, boolean z4, char[] cArr) {
        CLElement cLElement2;
        if (sDebug) {
            System.out.println("CREATE " + type + " at " + cArr[i5]);
        }
        switch (type.ordinal()) {
            case 1:
                cLElement2 = CLObject.allocate(cArr);
                break;
            case 2:
                cLElement2 = CLArray.allocate(cArr);
                break;
            case 3:
                cLElement2 = CLNumber.allocate(cArr);
                break;
            case 4:
                cLElement2 = CLString.allocate(cArr);
                break;
            case 5:
                cLElement2 = CLKey.allocate(cArr);
                break;
            case 6:
                cLElement2 = CLToken.allocate(cArr);
                break;
            default:
                cLElement2 = null;
                break;
        }
        i5++;
        if (cLElement2 == null) {
            return null;
        }
        cLElement2.setLine(this.mLineNumber);
        if (z4) {
            cLElement2.setStart((long) i5);
        }
        if (cLElement instanceof CLContainer) {
            cLElement2.setContainer((CLContainer) cLElement);
        }
        return cLElement2;
    }

    private CLElement getNextJsonElement(int i5, char c5, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (!(c5 == 9 || c5 == 10 || c5 == 13 || c5 == ' ')) {
            if (c5 == '\"' || c5 == '\'') {
                int i6 = i5;
                CLElement cLElement2 = cLElement;
                char[] cArr2 = cArr;
                if (cLElement2 instanceof CLObject) {
                    return createElement(cLElement2, i6, TYPE.KEY, true, cArr2);
                }
                return createElement(cLElement2, i6, TYPE.STRING, true, cArr2);
            } else if (c5 != '[') {
                if (c5 != ']') {
                    if (c5 == '{') {
                        return createElement(cLElement, i5, TYPE.OBJECT, true, cArr);
                    } else if (c5 != '}') {
                        switch (c5) {
                            case '+':
                            case '-':
                            case '.':
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                return createElement(cLElement, i5, TYPE.NUMBER, true, cArr);
                            case ',':
                            case ':':
                                break;
                            case '/':
                                CLElement cLElement3 = cLElement;
                                char[] cArr3 = cArr;
                                int i7 = i5 + 1;
                                if (i7 >= cArr3.length || cArr3[i7] != '/') {
                                    return cLElement3;
                                }
                                this.mHasComment = true;
                                return cLElement3;
                            default:
                                if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                    return createElement(cLElement, i5, TYPE.KEY, true, cArr);
                                }
                                int i8 = i5;
                                CLElement createElement = createElement(cLElement, i8, TYPE.TOKEN, true, cArr);
                                CLToken cLToken = (CLToken) createElement;
                                if (cLToken.validate(c5, (long) i8)) {
                                    return createElement;
                                }
                                throw new CLParsingException("incorrect token <" + c5 + "> at line " + this.mLineNumber, cLToken);
                        }
                    }
                }
                int i9 = i5;
                CLElement cLElement4 = cLElement;
                cLElement4.setEnd((long) (i9 - 1));
                CLElement container = cLElement4.getContainer();
                container.setEnd((long) i9);
                return container;
            } else {
                return createElement(cLElement, i5, TYPE.ARRAY, true, cArr);
            }
        }
        return cLElement;
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    public CLObject parse() throws CLParsingException {
        int i5;
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i6 = 1;
        this.mLineNumber = 1;
        boolean z4 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                i7 = -1;
                break;
            }
            char c5 = charArray[i7];
            if (c5 == '{') {
                break;
            }
            if (c5 == 10) {
                this.mLineNumber++;
            }
            i7++;
        }
        if (i7 != -1) {
            CLObject allocate = CLObject.allocate(charArray);
            allocate.setLine(this.mLineNumber);
            allocate.setStart((long) i7);
            int i8 = i7 + 1;
            CLElement cLElement = allocate;
            while (i8 < length) {
                char c6 = charArray[i8];
                if (c6 == 10) {
                    this.mLineNumber += i6;
                }
                if (this.mHasComment) {
                    if (c6 == 10) {
                        this.mHasComment = z4;
                    } else {
                        i5 = i6;
                        i8++;
                        i6 = i5;
                        z4 = false;
                    }
                }
                if (cLElement == null) {
                    break;
                }
                if (cLElement.isDone()) {
                    cLElement = getNextJsonElement(i8, c6, cLElement, charArray);
                } else if (cLElement instanceof CLObject) {
                    if (c6 == '}') {
                        cLElement.setEnd((long) (i8 - 1));
                    } else {
                        cLElement = getNextJsonElement(i8, c6, cLElement, charArray);
                    }
                } else if (!(cLElement instanceof CLArray)) {
                    boolean z5 = cLElement instanceof CLString;
                    if (z5) {
                        long j5 = cLElement.mStart;
                        if (charArray[(int) j5] == c6) {
                            cLElement.setStart(j5 + 1);
                            cLElement.setEnd((long) (i8 - 1));
                        }
                    } else {
                        if (cLElement instanceof CLToken) {
                            CLToken cLToken = (CLToken) cLElement;
                            i5 = i6;
                            if (!cLToken.validate(c6, (long) i8)) {
                                throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                            }
                        } else {
                            i5 = i6;
                        }
                        if ((cLElement instanceof CLKey) || z5) {
                            long j6 = cLElement.mStart;
                            char c7 = charArray[(int) j6];
                            if ((c7 == '\'' || c7 == '\"') && c7 == c6) {
                                cLElement.setStart(j6 + 1);
                                cLElement.setEnd((long) (i8 - 1));
                            }
                        }
                        if (!cLElement.isDone() && (c6 == '}' || c6 == ']' || c6 == ',' || c6 == ' ' || c6 == 9 || c6 == 13 || c6 == 10 || c6 == ':')) {
                            long j7 = (long) (i8 - 1);
                            cLElement.setEnd(j7);
                            if (c6 == '}' || c6 == ']') {
                                cLElement = cLElement.getContainer();
                                cLElement.setEnd(j7);
                                if (cLElement instanceof CLKey) {
                                    cLElement = cLElement.getContainer();
                                    cLElement.setEnd(j7);
                                }
                            }
                        }
                        if (cLElement.isDone() && (!(cLElement instanceof CLKey) || ((CLKey) cLElement).mElements.size() > 0)) {
                            cLElement = cLElement.getContainer();
                        }
                        i8++;
                        i6 = i5;
                        z4 = false;
                    }
                } else if (c6 == ']') {
                    cLElement.setEnd((long) (i8 - 1));
                } else {
                    cLElement = getNextJsonElement(i8, c6, cLElement, charArray);
                }
                i5 = i6;
                cLElement = cLElement.getContainer();
                i8++;
                i6 = i5;
                z4 = false;
            }
            int i9 = i6;
            while (cLElement != null && !cLElement.isDone()) {
                if (cLElement instanceof CLString) {
                    cLElement.setStart((long) (((int) cLElement.mStart) + 1));
                }
                cLElement.setEnd((long) (length - 1));
                cLElement = cLElement.getContainer();
            }
            if (sDebug) {
                System.out.println("Root: " + allocate.toJSON());
            }
            return allocate;
        }
        throw new CLParsingException("invalid json content", (CLElement) null);
    }
}
