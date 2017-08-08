package com.ingenuitymobile.template.services;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.ingenuitymobile.template.utils.LogUtil;

/**
 * Created by memengski on 8/8/17.
 */

public class MyGcmListenerService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        LogUtil.e("AAA Receive notification");
        if (remoteMessage.getData().size() > 0) {
            LogUtil.e("AAA id " + remoteMessage.getData().get("id"));
            LogUtil.e("AAA type " + remoteMessage.getData().get("type"));

            final String type = remoteMessage.getData().get("type");
            final String id = remoteMessage.getData().get("id");
            final String title = remoteMessage.getNotification().getTitle();
            final String message = remoteMessage.getNotification().getBody();

            LogUtil.e("AAA Notiff title:  " + title);
            LogUtil.e("AAA Notiff message: " + message);

        }
    }
}
