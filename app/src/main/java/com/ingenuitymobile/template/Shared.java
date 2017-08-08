package com.ingenuitymobile.template;

import android.content.Context;

import com.ingenuitymobile.template.api.ApiClient;
import com.ingenuitymobile.template.api.models.Authentication;
import com.ingenuitymobile.template.api.models.User;
import com.ingenuitymobile.template.listeners.OnDisplayErrorListener;
import com.ingenuitymobile.template.listeners.OnRefreshTokenListener;
import com.ingenuitymobile.template.utils.LogUtil;

/**
 * Created by memengski on 8/8/17.
 */

public class Shared {

    public static ApiClient apiClient;
    public static User user;

    public static void init(Context context) {
        final String consumerSecret = context.getResources().getString(R.string.client_secret);
        final String basUrl = context
                .getResources()
                .getString(BuildConfig.DEBUG ? R.string.staging_url : R.string.live_url);

        apiClient = new ApiClient(
                consumerSecret,
                basUrl,
                new RefreshTokenListener(context),
                new DisplayErrorListener(context));

        SessionStore.restore(apiClient, context);
        user = new User();
    }

    private static class DisplayErrorListener implements OnDisplayErrorListener {

        private Context context;

        DisplayErrorListener(Context context) {
            this.context = context;
        }

        @Override
        public void onDisplayError(Throwable e) {

        }
    }

    private static class RefreshTokenListener implements OnRefreshTokenListener {

        private Context context;

        RefreshTokenListener(Context context) {
            this.context = context;
        }

        @Override
        public void onRefreshToken(Authentication authentication) {
            SessionStore.saveRefreshToken(authentication.refresh_token, context);
            SessionStore.saveAccessToken(authentication.accessToken, context);
            LogUtil.e("AAA " + authentication.accessToken);
        }
    }
}
