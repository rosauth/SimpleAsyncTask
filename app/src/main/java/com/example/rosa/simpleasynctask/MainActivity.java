package com.example.rosa.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TEXT_STATE = "currentText";
    private TextView mTextView = null;

    /**
     *	Initializes	the	activity.
     *	@param	savedInstanceState	The	current	state	data
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView1);

        if(savedInstanceState!=null){
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    /**`
     *	Handles	the	onCLick	for	the	"Start	Task"	button.	Launches	the	AsyncTask
     *	which	performs	work	off	of	the	UI	thread.
     *
     *	@param	view	The	view	(Button)	that	was	clicked.
     */
    public void startTask(View view) {
        mTextView.setText(R.string.napping);

        new SimpleAsyncTask(mTextView).execute();
    }

    /**
     *	Saves	the	contents	of	the	TextView	to	restore	on	configuration	change.
     *	@param	outState	The	bundle	in	which	the	state	of	the	activity	is	saved when
     *                     	it	is	spontaneously	destroyed.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setContentView(R.layout.activity_main);

        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}
