package com.ingenuitymobile.template.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.ingenuitymobile.template.R;
import com.ingenuitymobile.template.utils.LogUtil;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by memengski on 8/8/17.
 */

public class BaseFragment extends Fragment {

    protected CompositeSubscription subscription;
    protected Context context;

    protected ProgressDialog progressDialog;

    public BaseFragment() {
        subscription = new CompositeSubscription();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (subscription.hasSubscriptions()) {
            subscription.clear();
        }
    }

    protected void hideKeyboard() {
        try {
            InputMethodManager inputManager = (InputMethodManager)
                    getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            LogUtil.e("Error in hiding keyboard", e);
        }
    }

    protected void hideKeyboard(View v) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(
                    Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        } catch (Exception e) {
            LogUtil.e("Error in hiding keyboard", e);
        }
    }

    protected void showKeyboard() {
        try {
            InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(
                    Activity.INPUT_METHOD_SERVICE);
            inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                    InputMethodManager.HIDE_IMPLICIT_ONLY);
        } catch (Exception e) {
            LogUtil.e("Error in hiding keyboard", e);
        }
    }

    protected View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                hideKeyboard(v);
            }
        }
    };
}
