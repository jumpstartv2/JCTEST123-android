package com.ingenuitymobile.template.activities;

import android.os.Bundle;
import android.text.TextUtils;

import com.ingenuitymobile.template.R;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

/**
 * Created by memengski on 8/8/17.
 */

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();
        checkForCrashes();
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterManagers();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterManagers();
    }


    private void checkForCrashes() {
        if (!TextUtils.isEmpty(getString(R.string.hockey_app_id))) {
            CrashManager.register(this);
        }
    }

    private void unregisterManagers() {
        if (!TextUtils.isEmpty(getString(R.string.hockey_app_id))) {
            UpdateManager.unregister();
        }
    }
}
