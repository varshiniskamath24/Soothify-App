package com.example.soothify;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class saveSharedPreferences
{
    /*static final String PREF_USER_NAME= "username";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.commit();
    }

    public static String getUserName(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }*/
    private SharedPreferences sharedPreferences;
    private Context context;

    public saveSharedPreferences(Context applicationContext) {

    }

    public void saveSharedPreferences(Context context)
    {
        this.context=context;
        sharedPreferences=context.getSharedPreferences(context.getResources().getString(R.string.login_shared_preference),Context.MODE_PRIVATE);
    }
    public void login_status(boolean status){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_shared_preference),status);
        editor.commit();
    }
    public boolean read_login_status(){
        boolean status=false;
        status=sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_shared_preference),false);
        return status;
    }
}