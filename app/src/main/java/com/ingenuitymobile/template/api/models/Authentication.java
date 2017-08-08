package com.ingenuitymobile.template.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by memengski on 8/8/17.
 */

public class Authentication {


    @SerializedName("access_token")
    public String accessToken;
    @SerializedName("token_type")
    public String tokenType;
    @SerializedName("expires_in")
    public String expiresIn;
    @SerializedName("refresh_token")
    public String refresh_token;
}
