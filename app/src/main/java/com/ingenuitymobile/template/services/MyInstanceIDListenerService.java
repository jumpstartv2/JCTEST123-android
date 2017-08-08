package com.ingenuitymobile.template.services;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.ingenuitymobile.template.SessionStore;
import com.ingenuitymobile.template.utils.LogUtil;

/**
 * Created by memengski on 8/8/17.
 */

public class MyInstanceIDListenerService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        final String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        LogUtil.e("AAA Refreshed token: " + refreshedToken);
        SessionStore.saveFirebaseToken(refreshedToken, this);
    }
}
