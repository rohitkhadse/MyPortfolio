package com.myportfolio.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myportfolio.R;
import com.myportfolio.SkillFragment;
import com.myportfolio.SkillItem;

import java.util.ArrayList;

/**
 * Created by User on 8/12/17.
 */

public class SkillAdapter extends BaseAdapter {

    ArrayList<Object> list;
    private static final int SKILL_ITEM = 0;
    private static final int HEADER = 1;
    private LayoutInflater inflater;

    public SkillAdapter(Context context, ArrayList<Object> list){
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof SkillItem){
            return SKILL_ITEM;
        }
        else {
            return HEADER;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;                       ///will return total number of views
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       if (view == null){
           switch (getItemViewType(i)){
               case SKILL_ITEM:
                   view = inflater.inflate(R.layout.item_list_view,null);
                   break;
               case HEADER:
                   view = inflater.inflate(R.layout.item_listview_header,null);
                   break;
           }
       }

       switch (getItemViewType(i)){
               case SKILL_ITEM:
                   ImageView image = (ImageView) view.findViewById(R.id.itemListViewImgRating);
                   TextView name= (TextView) view.findViewById(R.id.itemListViewText);

                   image.setImageResource(((SkillItem)list.get(i)).getImage());
                   name.setText(((SkillItem)list.get(i)).getName());
                   break;
               case HEADER:
                   TextView title = (TextView) view.findViewById(R.id.itemListViewHeader);
                   title.setText(((String)list.get(i)));
                   break;
           }
           return view;
    }
}
