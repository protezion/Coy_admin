package asc.com.coy_admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THE KWON on 2015-12-12.
 */
public class ListFragment extends Fragment {
    LinearLayout cur_layout;
    RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cur_layout=(LinearLayout)inflater.inflate(R.layout.fragment_list, container, false);
        mRecyclerView=(RecyclerView)cur_layout.findViewById(R.id.recycler);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);

        final List<List_item> items=new ArrayList<>();
        List_item[] item=new List_item[5];

        ParseQuery<ParseObject> query=new ParseQuery<>("club");
        query.addAscendingOrder("Club_name");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if( e!= null) {
                    Toast.makeText(getActivity().getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                } else {
                    for (ParseObject o : list) {
                        List_item item = new List_item(o.getString("Club_name"));
                        items.add(item);
                        Log.d("ddd", item.getTitle());
                    }
                }
                mRecyclerView.setAdapter(new RecyclerAdapter(getActivity().getApplicationContext(),items));
            }

        });
        /*
        for(List_item i:item) {
            i = new List_item("aasdfghjklZxcvbnmsc");
            items.add(i);
            Log.d("ddd",i.getTitle());
        }
        */
        //mRecyclerView.setAdapter(new RecyclerAdapter(getActivity().getApplicationContext(),items));

        return cur_layout;
    }


}
