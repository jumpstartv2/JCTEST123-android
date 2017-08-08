package com.ingenuitymobile.template;

import android.content.Context;
import android.content.SharedPreferences;

import com.ingenuitymobile.template.api.ApiClient;

/**
 * Created by memengski on 8/8/17.
 */

public class SessionStore {

    private static final String ACCESS_TOKEN = "accessToken";
    private static final String REFRESH_TOKEN = "refreshToken";
    private static final String FIREBASE_TOKEN = "firebaseToken";

    private static String getName(Context context) {
        return context.getResources().getString(R.string.app_name) + "-session";
    }

    static boolean restore(ApiClient apiClient, Context context) {
        final SharedPreferences savedSession = context.getSharedPreferences(getName(context),
                Context.MODE_PRIVATE);

        apiClient.setAccessToken(savedSession.getString(ACCESS_TOKEN, null));
        return apiClient.service != null;
    }

    public static boolean saveAccessToken(String accessToken, Context context) {
        Shared.apiClient.setAccessToken(accessToken);
        final SharedPreferences.Editor editor = context
                .getSharedPreferences(getName(context), Context.MODE_PRIVATE)
                .edit()
                .putString(ACCESS_TOKEN, accessToken);
        return editor.commit();
    }

    public static String restoreAccessToken(Context context) {
        final SharedPreferences savedUserId = context.getSharedPreferences(getName(context),
                Context.MODE_PRIVATE);
        return savedUserId.getString(ACCESS_TOKEN, null);
    }

    public static boolean saveRefreshToken(String refreshToken, Context context) {
        final SharedPreferences.Editor editor = context
                .getSharedPreferences(getName(context), Context.MODE_PRIVATE)
                .edit()
                .putString(REFRESH_TOKEN, refreshToken);
        return editor.commit();
    }

    public static String restoreRefreshToken(Context context) {
        final SharedPreferences savedUserId = context.getSharedPreferences(getName(context),
                Context.MODE_PRIVATE);
        return savedUserId.getString(REFRESH_TOKEN, null);
    }

    public static boolean saveFirebaseToken(String accessToken, Context context) {
        final SharedPreferences.Editor editor = context
                .getSharedPreferences(getName(context), Context.MODE_PRIVATE)
                .edit()
                .putString(FIREBASE_TOKEN, accessToken);
        return editor.commit();
    }

    public static String restoreFirebaseToken(Context context) {
        final SharedPreferences savedUserId = context.getSharedPreferences(getName(context),
                Context.MODE_PRIVATE);
        return savedUserId.getString(FIREBASE_TOKEN, null);
    }
}
