package com.project.frontend.ui.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.project.frontend.DTO.MemberDTO;
import com.project.frontend.R;
import com.project.frontend.ui.MainActivity;
import com.project.frontend.ui.item.ListViewItem;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> listViewItems = new ArrayList<ListViewItem>();
    private Context mainContext;
    private Activity activity;
    //임시 생성자
    public ListViewAdapter() {
        for(int i = 1; i < 30; i++) {
            listViewItems.add(new ListViewItem("user" + i, "user" + i, "hello, user" + i));
        }
    }

    @Override
    public int getCount() {
        return listViewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //아이템 생상
        Context context = viewGroup.getContext();
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item, viewGroup, false);
        }

        TextView userId = view.findViewById(R.id.userId);
        TextView nickname = view.findViewById(R.id.nickname);
        TextView introduction = view.findViewById(R.id.introduction);

        ListViewItem listViewItem = listViewItems.get(position);

        userId.setText(listViewItem.getUserId());
        nickname.setText(listViewItem.getNickname());
        introduction.setText(listViewItem.getIntroduction());

        return view;
    }
}
