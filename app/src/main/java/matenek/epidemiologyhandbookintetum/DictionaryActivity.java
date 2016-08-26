package matenek.epidemiologyhandbookintetum;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Locale;


/**
 * Created by admin on 25/08/16.
 */
public class DictionaryActivity extends AppCompatActivity {
    private TextView wordMeaning;
    private TextToSpeech convertToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String dictword = bundle.getString("DICTIONARY_ID");
        //int dictionaryId = intent.getIntExtra("DICTIONARY_ID",0);
        //long id = dictionaryId + 1;

        TextView word = (TextView)findViewById(R.id.word);
        wordMeaning = (TextView)findViewById(R.id.dictionary);
/*
        Button textToSpeech = (Button)findViewById(R.id.button);
*/

        DbBackend dbBackend = new DbBackend(DictionaryActivity.this);
        //QuizObject allQuizQuestions = dbBackend.getQuizById(id);
        QuizObject allQuizQuestions = dbBackend.getQuizById(dictword);

        word.setText(allQuizQuestions.getWord());
        wordMeaning.setText(allQuizQuestions.getDefinition());

/*        textToSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String convertTextToSpeech = wordMeaning.getText().toString();
                convertToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            convertToSpeech.setLanguage(Locale.US);
                            convertToSpeech.speak(convertTextToSpeech, TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                    }
                });
            }
        });*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

/*    @Override
    protected void onPause() {
        if(convertToSpeech != null){
            convertToSpeech.stop();
            convertToSpeech.shutdown();
        }
        super.onPause();
    }*/

}

