package asc.com.coy_admin;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

import java.util.Calendar;


/**
 * Created by THE KWON on 2015-12-12.
 */

public class PlanFragment extends Fragment {
    LinearLayout cur_layout;
    ParseObject tempObject = new ParseObject("Plan");
    int cur_year;
    int cur_mon;
    int cur_day;
    TextView text_date;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cur_layout=(LinearLayout)inflater.inflate(R.layout.fragment_plan,container,false);
        final EditText editclub=(EditText)cur_layout.findViewById(R.id.editclub);
        final EditText editdetail=(EditText)cur_layout.findViewById(R.id.editdetail);
        final EditText editplan=(EditText)cur_layout.findViewById(R.id.editplan);
        Button btAdd=(Button)cur_layout.findViewById(R.id.btAdd);
        Button btDate = (Button)cur_layout.findViewById(R.id.btDate);
        Button btADD_plan=(Button)cur_layout.findViewById(R.id.addplan);
        text_date = (TextView)cur_layout.findViewById(R.id.txtDate);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btADD_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),
                        editclub.getText()+", " + editdetail.getText()+", "+editplan.getText(),Toast.LENGTH_SHORT).show();
                tempObject.put("Title", editplan.getText().toString());
                tempObject.put("club", editclub.getText().toString());
                tempObject.put("Detail", editdetail.getText().toString());

                tempObject.saveInBackground();
            }
        });
        btDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur_year= Calendar.getInstance().get(Calendar.YEAR);
                cur_mon= Calendar.getInstance().get(Calendar.MONTH);
                cur_day=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);


                Dialog date_picker=new DatePickerDialog(getActivity(),new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        text_date.setText(""+cur_year+"."+(cur_mon + 1)+"."+ cur_day);
                    }
                },cur_year,cur_mon,cur_day);
                date_picker.show();

            }
        });
        return cur_layout;
    }

}
