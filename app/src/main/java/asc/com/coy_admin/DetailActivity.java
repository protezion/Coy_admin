package asc.com.coy_admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by THE KWON on 2015-12-12.
 */

public class DetailActivity extends AppCompatActivity {

    Intent intent;
    EditText textSub;
    EditText textLocation;
    EditText textIntro;
    EditText textPhone;
    EditText editLeader;
    Button btImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        intent = getIntent();
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(intent.getStringExtra("tgClubName"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textSub = (EditText)findViewById(R.id.textSub);
        textLocation = (EditText)findViewById(R.id.textLocation);
        textIntro = (EditText)findViewById(R.id.textDetail);
        textPhone = (EditText)findViewById(R.id.textPhone);
        btImg = (Button)findViewById(R.id.btImg);
        editLeader = (EditText)findViewById(R.id.editLeader);

        textSub.setText(intent.getStringExtra("tgClubSub"));
        textLocation.setText(intent.getStringExtra("tgClubLotate"));
        textIntro.setText(intent.getStringExtra("tgClubIntro"));
        textPhone.setText(intent.getStringExtra("tgClubPhone"));
        editLeader.setText(intent.getStringExtra("tgClubLeader"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_ok) {
            ParseQuery<ParseObject> parseObject = ParseQuery.getQuery("club");
            parseObject.whereEqualTo("objectId", getIntent().getStringExtra("tgObjectId"));
            parseObject.getFirstInBackground(new GetCallback<ParseObject>() {
                @Override
                public void done(ParseObject parseObject, ParseException e) {
                    parseObject.put("Club_intro", textIntro.getText().toString());
                    parseObject.put("Club_leader", editLeader.getText().toString());
                    parseObject.put("Club_phone", textPhone.getText().toString());
                    parseObject.put("Club_sub", textSub.getText().toString());
                    parseObject.saveInBackground();
                    Toast.makeText(DetailActivity.this, "Finish!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
            }
        return super.onOptionsItemSelected(item);
    }
}
