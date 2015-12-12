package asc.com.coy_admin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by THE KWON on 2015-12-12.
 */
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textSub = (TextView)findViewById(R.id.textSub);
        TextView textLocation = (TextView)findViewById(R.id.textLocation);
        TextView textDetail = (TextView)findViewById(R.id.textDetail);
        TextView textPhone = (TextView)findViewById(R.id.textPhone);
        Button btImg = (Button)findViewById(R.id.btImg);
        EditText editLeader = (EditText)findViewById(R.id.editLeader);
    }


}
