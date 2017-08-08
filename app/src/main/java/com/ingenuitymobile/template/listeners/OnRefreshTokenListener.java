package com.ingenuitymobile.template.listeners;

import com.ingenuitymobile.template.api.models.Authentication;

/**
 * Created by memengski on 8/8/17.
 */

public interface OnRefreshTokenListener {
    void onRefreshToken(Authentication authentication);
}
