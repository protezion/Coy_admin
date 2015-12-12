package asc.com.coy_admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by THE KWON on 2015-12-12.
 */
public class PlanFragment extends Fragment {
    LinearLayout cur_layout;

    @Override
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

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),
                        editclub.getText()+", " + editdetail.getText()+", "+editplan.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        return cur_layout;
    }

}
