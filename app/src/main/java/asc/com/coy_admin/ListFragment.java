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

        List<List_item> items=new ArrayList<>();
        List_item[] item=new List_item[5];
        for(List_item i:item) {
            i = new List_item("aasdfghjklZxcvbnmsc");
            items.add(i);
            Log.d("ddd",i.getTitle());
        }
        mRecyclerView.setAdapter(new RecyclerAdapter(getActivity().getApplicationContext(),items));
        return cur_layout;
    }


}
