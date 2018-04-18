package com.example.rosa.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.util.Random;

/**
 * Created by rosa on 4/5/2018.
 */

class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private TextView mTextView;

    public SimpleAsyncTask(TextView mTextView) {
        this.mTextView = mTextView;
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);

        int s = n * 200;

        try{
            Thread.sleep(s);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    protected void onPostExecute(String result){
        mTextView.setText(result);
    }
}
