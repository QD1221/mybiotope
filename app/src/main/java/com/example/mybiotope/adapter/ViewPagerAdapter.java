package com.example.mybiotope.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mybiotope.R;


public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private String[] text = {"Mua bán cây cảnh", "Mạng xã hội cây cảnh", "Kiến thức cây cảnh"};
    private String[] text2 = {"Sở hữu cây cảnh theo ý thích trở nên dễ dàng hơn bao giờ hết!", "Sáng tạo nội dung, chia sẻ cảm xúc với cộng đồng người yêu cây cảnh", "Thưởng thức các tác phẩm của nghệ nhân và tìm hiểu cách chăm sóc cây"};
    private Integer[] images = {R.drawable.splash1, R.drawable.splash2, R.drawable.splash3};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.splash1, null);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        TextView textView1 = view.findViewById(R.id.textView1);
        textView1.setText(text[position]);

        TextView textView2 = view.findViewById(R.id.textView2);
        textView2.setText(text2[position]);


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}