package com.tutorials.hp.facebookpublishphoto.mFaceBook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.entities.Photo;
import com.sromku.simple.fb.listeners.OnPublishListener;
import com.tutorials.hp.facebookpublishphoto.R;

/**
 * Created by Oclemmy on 5/3/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class PhotoPublisher {

    Context c;
    SimpleFacebook fb;
    static final String ALBUM_ID="962590287170645";

    public PhotoPublisher(Context c, SimpleFacebook fb) {
        this.c = c;
        this.fb = fb;
    }

    public void publishPhoto()
    {
        Bitmap bm= BitmapFactory.decodeResource(c.getResources(), R.drawable.hubble2);
        Photo photo=new Photo.Builder()
                .setImage(bm)
                .setName("Hubble Space Telescope Two")
                .build();

        fb.publish(photo,ALBUM_ID,publishListener);

    }

    OnPublishListener publishListener=new OnPublishListener() {
        @Override
        public void onComplete(String response) {
            super.onComplete(response);
            Toast.makeText(c, "Published Successfully", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onException(Throwable throwable) {
            super.onException(throwable);
            Log.e("Exception", throwable.getMessage());
        }

        @Override
        public void onFail(String reason) {
            super.onFail(reason);
            Log.i("Fail", reason);
        }
    };
}

