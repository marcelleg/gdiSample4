package com.gibblicious.gdi.Sample4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;
import java.util.ArrayList;
import com.gibblicious.gdi.Sample4.networking.Photo;
import com.gibblicious.gdi.Sample4.networking.Photos;;
import com.squareup.picasso.Picasso;


public class FlickerAdapter extends RecyclerView.Adapter<FlickerAdapter.ViewHolder> {

    private static final String TAG = "FlickerAdapter";

    List<Photo> imageList = new ArrayList<>();
    Context context;

    public FlickerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public FlickerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView imageView = (ImageView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item, parent, false);

        return new FlickerAdapter.ViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(FlickerAdapter.ViewHolder holder, int position) {
        Photo photo = imageList.get(position);
        String url = getImageUrl(photo);

        Picasso.with(context)
                .load(url)
                .resize(1000, 800)
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public void setImageList(Photos photos) {
        imageList = photos.getPhoto();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView iv;

        public ViewHolder(ImageView itemView) {
            super(itemView);
            iv = itemView;
        }
    }

    private String getImageUrl(Photo photo) {
        StringBuilder sb = new StringBuilder("https://farm");
        sb.append(String.valueOf(photo.getFarm()));
        sb.append(".staticflickr.com/");
        sb.append(photo.getServer());
        sb.append("/");
        sb.append(photo.getId());
        sb.append("_");
        sb.append(photo.getSecret());
        sb.append("_n.jpg");
        return sb.toString();
    }
}
