package com.example.smartproject3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartproject3.Comm_item;
import com.example.smartproject3.CustomDTO;
import com.example.smartproject3.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CommunityAdapter extends BaseAdapter {

    List<Comm_item> comm_list = new ArrayList<Comm_item>();

    public CommunityAdapter() {
    }

    public CommunityAdapter(List<Comm_item> comm_list) {
        this.comm_list = comm_list;
    }

    @Override
    public int getCount() {
        return comm_list.size();
    }

    @Override
    public Object getItem(int position) {
        return comm_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.comm_item, null, false);
            viewHolder = new CustomViewHolder();

            viewHolder.textUser = (TextView) convertView.findViewById(R.id.boardUser);
            viewHolder.textType = (TextView) convertView.findViewById(R.id.boardType);
            viewHolder.textReg = (TextView) convertView.findViewById(R.id.boardReg);
            viewHolder.textContent = (TextView) convertView.findViewById(R.id.boardContent);
            viewHolder.textDate = (TextView) convertView.findViewById(R.id.boardDate);

            convertView.setTag(viewHolder);


        }else{
            viewHolder = (CustomViewHolder) convertView.getTag();
        }

        Comm_item dto = comm_list.get(position);
        viewHolder.textUser.setText(dto.getBoardUser());
        viewHolder.textContent.setText(dto.getBoardContent());
        viewHolder.textType.setText(dto.getBoardType());
        viewHolder.textReg.setText(dto.getBoardReg());
        viewHolder.textDate.setText(dto.getBoardDate());

        return convertView;
    }

    class CustomViewHolder {
        TextView textUser;
        TextView textType;
        TextView textReg;
        TextView textContent;
        TextView textDate;
    }

    public void addItem(Comm_item dto) {
        comm_list.add(dto);
    }

    public void clear(){
        comm_list.clear();
    }


}
