package asc.com.coy_admin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by THE KWON on 2015-12-12.
 */
public class RecyclerAdapter extends RecyclerView.Adapter {
    Context mContext;
    List<List_item> items;
    int itemlist;

    public RecyclerAdapter(Context context, List<List_item> items) {
        this.mContext=context;
        this.items=items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, null);
        return new Item(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final List_item item = items.get(position);
                ((Item) holder).container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, DetailActivity.class);
                intent.putExtra("tgObjectId", item.getObjectId());
                intent.putExtra("tgClubIntro", item.getClubIntro());
                intent.putExtra("tgClubLeader", item.getClubLeader());
                intent.putExtra("tgClubLotate", item.getClubLotate());
                intent.putExtra("tgClubName", item.getClubName());
                intent.putExtra("tgClubPhone", item.getClubPhone());
                intent.putExtra("tgClubSub", item.getClubSub());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        ((Item)holder).text.setText(item.getClubName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    class Item extends RecyclerView.ViewHolder{
        TextView text;
        CardView container;

        public Item(View v) {
            super(v);
            text=(TextView)itemView.findViewById(R.id.itemlist);
            container=(CardView)itemView.findViewById(R.id.container);
        }
    }

}
