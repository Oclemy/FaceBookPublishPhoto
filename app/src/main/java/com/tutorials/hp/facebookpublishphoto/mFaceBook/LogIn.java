package com.tutorials.hp.facebookpublishphoto.mFaceBook;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.listeners.OnLoginListener;

import java.util.List;

/**
 * Created by Oclemmy on 5/3/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class LogIn {

    Context c;
    SimpleFacebook fb;

    public LogIn(Context c, SimpleFacebook fb) {
        this.c = c;
        this.fb = fb;
    }

    public void login()
    {
        fb.login(loginListener);
    }

    OnLoginListener loginListener=new OnLoginListener() {
        @Override
        public void onLogin(String accessToken, List<Permission> acceptedPermissions, List<Permission> declinedPermissions) {
            Toast.makeText(c,"Logged In",Toast.LENGTH_SHORT).show();
            //PUBLISH PHOTO
            new PhotoPublisher(c,fb).publishPhoto();
        }

        @Override
        public void onCancel() {
            Toast.makeText(c,"Cancelled ",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onException(Throwable throwable) {
            Log.e("Exception",throwable.getMessage());
        }

        @Override
        public void onFail(String reason) {
            Log.i("Fail", reason);

        }
    };
}
