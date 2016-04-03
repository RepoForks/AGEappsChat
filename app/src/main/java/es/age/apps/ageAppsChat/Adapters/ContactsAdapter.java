package es.age.apps.ageAppsChat.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import es.age.apps.ageAppsChat.R;

/**
 * Created by Adrián García Espinosa on 3/4/16.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.CallViewHolder> {

    LayoutInflater inflater;
    ArrayList<String> items;
    Random r = new Random();
    String[] place = {"MOBILE", "SD", "SIM"};


    public ContactsAdapter(Context ctx, ArrayList<String> items) {
        inflater = LayoutInflater.from(ctx);
        this.items = items;

    }

    @Override
    public CallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View root = inflater.inflate(R.layout.contact_item, parent, false);
        return new CallViewHolder(root);
    }

    @Override
    public void onBindViewHolder(CallViewHolder holder, int position) {

        holder.title.setText(items.get(position));
        int chat_number = r.nextInt(3);
        holder.contact.setText(place[chat_number]);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    static class CallViewHolder extends RecyclerView.ViewHolder {


        TextView title;
        TextView contact;

        public CallViewHolder(View itemView) {

            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            contact = (TextView) itemView.findViewById(R.id.contact_place);
        }
    }
}
