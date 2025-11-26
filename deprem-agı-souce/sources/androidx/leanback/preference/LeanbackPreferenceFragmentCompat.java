package androidx.leanback.preference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public abstract class LeanbackPreferenceFragmentCompat extends BaseLeanbackPreferenceFragmentCompat {
    public LeanbackPreferenceFragmentCompat() {
        LeanbackPreferenceFragmentTransitionHelperApi21.addTransitions((Fragment) this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = LayoutInflater.from(onCreateView.getContext()).inflate(R.layout.leanback_preference_fragment, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.main_frame)).addView(onCreateView);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setTitle(getPreferenceScreen().getTitle());
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        View view = getView();
        if (view == null) {
            textView = null;
        } else {
            textView = (TextView) view.findViewById(R.id.decor_title);
        }
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
