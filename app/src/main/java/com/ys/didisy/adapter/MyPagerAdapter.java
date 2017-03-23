package com.ys.didisy.adapter;
        import java.util.ArrayList;
        import java.util.List;

        import android.content.Context;
        import android.support.v4.view.PagerAdapter;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;

public class MyPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<ImageView> mImageViewCache = new ArrayList<ImageView>();
    private List<Integer> mImageUrl;

    public MyPagerAdapter(Context context, List<Integer> imageUrl){
        this.mContext = context;
        mImageUrl = imageUrl;
    }

    @Override
    public int getCount() {
        return mImageUrl != null ? mImageUrl.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView iv = (ImageView) object;
        container.removeView(iv);
        mImageViewCache.add(iv);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView image = null;
        if (mImageViewCache.isEmpty()){
            image = new ImageView(mContext);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }else {
            image = mImageViewCache.remove(0);
        }

        image.setImageResource(mImageUrl.get(position));
        container.addView(image);
        return image;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}