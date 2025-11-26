package m0;

abstract class g {
    static int a(int i5) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i5) * -862048943), 15)) * 461845907);
    }

    static int b(Object obj) {
        int i5;
        if (obj == null) {
            i5 = 0;
        } else {
            i5 = obj.hashCode();
        }
        return a(i5);
    }
}
