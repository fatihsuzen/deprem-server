package O1;

import android.view.View;
import android.widget.AdapterView;
import com.uptodown.activities.SearchActivity;

public final /* synthetic */ class A5 implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchActivity f3206a;

    public /* synthetic */ A5(SearchActivity searchActivity) {
        this.f3206a = searchActivity;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        SearchActivity.H3(this.f3206a, adapterView, view, i5, j5);
    }
}
