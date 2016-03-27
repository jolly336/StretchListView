package com.zihuatanejo.stretchlistview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试页面
 * Created by Haoxunwang on 2016/3/25.
 */
public class StretchActivity extends Activity implements StretchLayout.OnGiveUpTouchEventListener {

    private StretchLayout mStretchLayout;
    private LayoutInflater mInflater;
    private ListView mLv;
    private GridLayout mGridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretch);
        mInflater = LayoutInflater.from(this);
        initDatas();
        initView();

        mStretchLayout.setOnGiveUpTouchEventListner(this);
    }


    private List<String> list;

    private void initDatas() {
        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("我是第 " + i + " 条数据");
        }
    }

    private void initView() {
        mStretchLayout = (StretchLayout) findViewById(R.id.stretchLayout);
        mGridLayout = (GridLayout) findViewById(R.id.gridLayout);

        mLv = (ListView) findViewById(R.id.listView);
        mLv.setAdapter(new MyAdapter(list));

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(StretchActivity.this, "第 " + position + "位置", Toast.LENGTH_SHORT).show();
            }
        });


        for (int i = 0; i < mGridLayout.getChildCount(); i++) {
            Button button = (Button) mGridLayout.getChildAt(i);
            button.setOnClickListener(mListenr);
        }
    }

    private View.OnClickListener mListenr = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int childCount = mGridLayout.getChildCount();
            int viewId = v.getId();
            for (int i = 0; i < childCount; i++) {
                if (viewId == mGridLayout.getChildAt(i).getId()) {
                    Toast.makeText(StretchActivity.this, "button " + (i + 1) + " 被点击了！", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    @Override
    public boolean giveUpTouchEvent(MotionEvent event) {
        if (mLv.getFirstVisiblePosition() == 0) {
            View view = mLv.getChildAt(0);
            if (view != null && view.getTop() >= 0) {
                return true;
            }
        }
        return false;
    }


    private static class MyAdapter extends BaseAdapter {

        List<String> mDatas;

        public MyAdapter(List<String> list) {
            this.mDatas = list;
        }

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return mDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(parent.getContext());
            textView.setText(mDatas.get(position));
            textView.setTextColor(Color.BLUE);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
            return textView;
        }
    }

}
