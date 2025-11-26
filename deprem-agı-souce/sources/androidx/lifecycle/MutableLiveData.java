package androidx.lifecycle;

public class MutableLiveData<T> extends LiveData<T> {
    public MutableLiveData(T t5) {
        super(t5);
    }

    public void postValue(T t5) {
        super.postValue(t5);
    }

    public void setValue(T t5) {
        super.setValue(t5);
    }

    public MutableLiveData() {
    }
}
