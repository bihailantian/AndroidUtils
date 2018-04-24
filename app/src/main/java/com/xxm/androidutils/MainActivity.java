package com.xxm.androidutils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xxm.androidutils.activity.MultiActivity;
import com.xxm.androidutils.domain.Item;
import com.xxm.androidutils.photowall.PhotoWallActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Context mContext;
    private List<Item> itemList = new ArrayList<>();

    {
        itemList.add(new Item("多点触摸", "",MultiActivity.class));
        itemList.add(new Item("照片墙", "使用GridView展示照片墙",PhotoWallActivity.class));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        ListView mListView = findViewById(R.id.listView);
        mListView.setAdapter(new ListAdapter());
        mListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Item item = itemList.get(position);
        Intent intent = new Intent(mContext,item.getClazz());
        startActivity(intent);
    }


    class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public Item getItem(int position) {
            return itemList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = View.inflate(mContext, R.layout.list_item, null);
                holder = new ViewHolder();
                holder.tvTitle = convertView.findViewById(R.id.tv_title);
                holder.tvMsg = convertView.findViewById(R.id.tv_msg);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Item item = getItem(position);
            holder.tvTitle.setText(item.getTitle());
            holder.tvMsg.setText(item.getMsg());

            return convertView;
        }


        class ViewHolder {
            TextView tvTitle;
            TextView tvMsg;
        }

    }


}
