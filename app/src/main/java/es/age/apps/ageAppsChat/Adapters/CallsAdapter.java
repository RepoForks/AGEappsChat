package es.age.apps.ageAppsChat.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import es.age.apps.ageAppsChat.R;

/**
 * Created by Adrián García Espinosa on 3/4/16.
 */
public class CallsAdapter extends RecyclerView.Adapter<CallsAdapter.CallViewHolder> {

    LayoutInflater inflater;
    ArrayList<String> items;
    Random r = new Random();
    int[] call_images ={R.drawable.ic_call_made_black_24dp,R.drawable.ic_call_received_black_24dp} ;

    public CallsAdapter(Context ctx, ArrayList<String> items) {
        inflater = LayoutInflater.from(ctx);
        this.items = items;

    }

    @Override
    public CallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View root = inflater.inflate(R.layout.call_item, parent, false);
        return new CallViewHolder(root);
    }

    @Override
    public void onBindViewHolder(CallViewHolder holder, int position) {

        holder.title.setText(items.get(position));
        int calltype =r.nextInt(2);
        holder.call.setImageResource(call_images[calltype]);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    static class CallViewHolder extends RecyclerView.ViewHolder {


        TextView title;
        ImageView call;

        public CallViewHolder(View itemView) {

            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            call = (ImageView) itemView.findViewById(R.id.call_made);
        }
    }
}
