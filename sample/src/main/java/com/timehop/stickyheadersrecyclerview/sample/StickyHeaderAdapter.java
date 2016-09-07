package com.timehop.stickyheadersrecyclerview.sample;

import android.content.Context;
import android.provider.SyncStateContract;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.sample.pojo.Datum;
import com.timehop.stickyheadersrecyclerview.sample.pojo.Response;
import com.timehop.stickyheadersrecyclerview.sample.pojo.TagswiseVendorlist;

import java.util.List;

/**
 * Created by user on 7/13/2016.
 */
public class StickyHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyRecyclerHeadersAdapter<StickyHeaderAdapter.HeaderViewHolder> {

    private static final String TAG = StickyHeaderAdapter.class.getSimpleName();
    private int viewType;
    private String mThumbPath, mUserThumbnailPath, mVendorThumbnailPath, mVendorImagePath, mUserImagePath, mImagePath;
    private Context context;
    private List<Datum> list;
    private LayoutInflater inflater;

    public StickyHeaderAdapter(Context context, List<Datum> list, Response response) {
        this.context = context;
        mThumbPath = response.getThumbnailPath();
        mUserThumbnailPath = response.getUserThumbnailPath();
        mVendorThumbnailPath = response.getVendorThumbnailPath();
        mVendorImagePath = response.getVendorImagePath();
        mUserImagePath = response.getUserImagePath();
        mImagePath = response.getImagePath();
        this.list = list;
        inflater = LayoutInflater.from(context);
        setRecyclerLayoutType(TYPE_LIST);
    }

    private int checkType() {
        return viewType;
    }

    public void setRecyclerLayoutType(int listType) {
        viewType = listType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder = null;
        if (viewType == TYPE_LIST) {
            view = inflater.inflate(R.layout.trending_list_cell, null);
            holder = new TrendingListViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {

        final Datum data = list.get(position) ;

        final TrendingListViewHolder holder = (TrendingListViewHolder) viewHolder;
        if (holder.tvErrMsg.getVisibility() == View.VISIBLE) {
            holder.tvErrMsg.setVisibility(View.GONE);
        }

        holder.tvUserName.setText(data.getVendorName());
        final String likes = data.getTotalLikeCount();
        if (likes != null && !likes.equals("")) {
            String formtedLikes = Utility.formatNumber(likes);
            holder.tvLike.setText(Utility.createSpannableText(formtedLikes, context.getString(R.string.like)));
        }
        holder.tvMsg.setText(Utility.createSpannableTextSecond(data.getDescription(), context.getResources().getColor(R.color.brown), context));
        holder.tvMsg.setMovementMethod(LinkMovementMethod.getInstance());
        if (data.getCreatedDate() != null && data.getCreatedDate().length() > 0) {
            holder.tvTime.setText(Utility.formatTime(data.getCreatedDate()));
        }
        //profile image
        String profileImgPath = null;
        if (data.getType() != null && data.getType().equals(Constants.TYPE_USER)) {
            profileImgPath = mUserThumbnailPath + data.getVendorImage();
        } else if (data.getType() != null && !(data.getType().equals(Constants.TYPE_USER))) {
            profileImgPath = mVendorImagePath + data.getVendorImage();
        }
        Picasso.with(context).load(profileImgPath).fit().placeholder(R.drawable.ic_launcher).into(holder.ivProfile);
        //Large image
        final String imgName = data.getImageName();
        final String largeImgPath = mImagePath + imgName;
        Glide.with(context)
                .load(largeImgPath).placeholder(R.drawable.ic_launcher)
                .into(holder.ivFullImg);
        if (data.getIsLiked().equals("0")) {
            holder.ivLike.setImageResource(R.drawable.ic_launcher);
        } else {
            holder.ivLike.setImageResource(R.drawable.ic_launcher);
        }
        if (data.getIsFavorite().equals("0")) {
            holder.ivStyleBook.setImageResource(R.drawable.ic_launcher);
        } else {
            holder.ivStyleBook.setImageResource(R.drawable.ic_launcher);
        }
        // Other vendor list for same job code
        final List<TagswiseVendorlist> vendorList = data.getTagswiseVendorlist();
        int size = vendorList.size();
        if (size > 0) {
            LinearLayout.LayoutParams buttonLayoutParams = (LinearLayout.LayoutParams) holder.likeShareFavLayout.getLayoutParams();
            if (buttonLayoutParams != null) {
                buttonLayoutParams.setMargins(0, 0, 0, 0);
                holder.likeShareFavLayout.setLayoutParams(buttonLayoutParams);
            }
            if (holder.rlSimilarVendor.getChildCount() > 0) {
                holder.rlSimilarVendor.removeAllViews();
            }
            LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) holder.llSimilar.getLayoutParams();
            params2.leftMargin = 3;
            params2.rightMargin = 3;
            holder.llSimilar.setVisibility(View.VISIBLE);
            holder.tvSimilarLabel.setText(context.getString(R.string.get_similar) + " " + data.getTagsName().get(0).getCategoryName().toUpperCase());
            int phoneWidth = Utility.getDisplayWidth(context);
            Log.d("TrendingAdapter", "phoneWidth: " + phoneWidth);
            //            int vwp = Utility.convertDpToPixel(70, context);


            int vwp = 0;

            if (phoneWidth > 1080) {

                vwp = phoneWidth / 5;
            } else {
                vwp = phoneWidth / 6;
            }

            //display width is 1080 and
            int totalViewWidth = vwp;
            Log.d("TrendingAdapter", "vwp: " + vwp);
            for (int i = 0; i < size; i++) {
                totalViewWidth = totalViewWidth + (vwp - 65);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(vwp - 40, vwp - 40));
                if ((totalViewWidth) > phoneWidth) {
                    params.leftMargin = 0;
                    params.rightMargin = 0;
                    TextView tvNum = (TextView) inflater.inflate(R.layout.vendor_num_view, null);
                    tvNum.setText("+" + (size - 5));
                    tvNum.setHeight(150);
                    tvNum.setWidth(150);
                              tvNum.setLayoutParams(params);
                    holder.rlSimilarVendor.addView(tvNum);
                    break;
                }
                final TagswiseVendorlist vendorlist = vendorList.get(i);
                com.github.siyamed.shapeimageview.CircularImageView view = (com.github.siyamed.shapeimageview.CircularImageView) inflater.inflate(R.layout.vendor_circular_img_view, null);
//                        view.setBorderColor(context.getResources().getColor(R.color.grey));
                params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(150, 150));
                view.setBorderWidth(0);
                if (i == 0) {
                    params.leftMargin = 20;
                    params.rightMargin = 13;

                } else {
                    params.leftMargin = 13;
                    params.rightMargin = 13;
                }
                view.setLayoutParams(params);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                holder.rlSimilarVendor.addView(view);
                Picasso.with(context).load(mVendorThumbnailPath + vendorlist.getVendorImage()).placeholder(R.drawable.ic_launcher).into(view);
            }
        } else {
            holder.llSimilar.setVisibility(View.GONE);
            Log.d(TAG, "no similar suggestions are availlable ");
            LinearLayout.LayoutParams buttonLayoutParams = (LinearLayout.LayoutParams) holder.likeShareFavLayout.getLayoutParams();
            if (buttonLayoutParams != null) {
                buttonLayoutParams.setMargins(0, 0, 0, 150);
                holder.likeShareFavLayout.setLayoutParams(buttonLayoutParams);
            }
        }
    }

    @Override
    public long getHeaderId(int position) {
        return position;
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = null;
        try {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_view, parent, false);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder holder, int position) {

        final Datum data = list.get(position);

        holder.tvUserName.setText(data.getVendorName());
        String profileImgPath = null;
        if (data != null && data.getType() != null && data.getType().equals("4")) {
            profileImgPath = mUserThumbnailPath + data.getVendorImage();
        } else {
            profileImgPath = mVendorImagePath + data.getVendorImage();
        }
        Glide.with(context).load(profileImgPath).placeholder(R.drawable.ic_launcher).fitCenter().into(holder.ivProfile);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private static final int ITEM_FOOTER = 1;
    public static final int TYPE_LIST = 0;

    @Override
    public int getItemViewType(int position) {
        return checkType();
    }

    private boolean isFooter(int pos) {
        if (pos == list.size() - 1) {
            return true;
        }
        return false;
    }

    public void addData(List<Datum> arrayList) {
        list.addAll(arrayList);
        this.notifyDataSetChanged();
    }

    public void addData(List<Datum> arrayList, boolean isSwipeToRefresh) {
        list.clear();
        list.addAll(arrayList);
        this.notifyDataSetChanged();
    }

    public class TrendingListViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivProfile, ivMore, ivFullImg, ivLike, ivStyleBook, ivShare;
        private TextView tvUserName, tvLike, tvMsg, tvTime, tvSimilarLabel, tvRates, tvdes, tvErrMsg;
        private LinearLayout llSimilar;
        private LinearLayout rlSimilarVendor;
        private LinearLayout likeShareFavLayout;

        public TrendingListViewHolder(View itemView) {
            super(itemView);
            ivProfile = (ImageView) itemView.findViewById(R.id.trending_profilePic);
            ivMore = (ImageView) itemView.findViewById(R.id.iv_more);
            tvUserName = (TextView) itemView.findViewById(R.id.trending_name);
            ivFullImg = (ImageView) itemView.findViewById(R.id.trending_fullImg);
            tvLike = (TextView) itemView.findViewById(R.id.tv_like_count);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            ivLike = (ImageView) itemView.findViewById(R.id.iv_like);
            ivStyleBook = (ImageView) itemView.findViewById(R.id.iv_stylebook);
            ivShare = (ImageView) itemView.findViewById(R.id.iv_share);
            llSimilar = (LinearLayout) itemView.findViewById(R.id.ll_similar);
            tvSimilarLabel = (TextView) itemView.findViewById(R.id.tv_label_similar);
//        tvRates = (TextView)itemView.findViewById(R.id.tv_rates);
            likeShareFavLayout = (LinearLayout) itemView.findViewById(R.id.like_fav_layout);
            rlSimilarVendor = (LinearLayout) itemView.findViewById(R.id.rl_similar_vendor);
            tvdes = (TextView) itemView.findViewById(R.id.tv_dis_msg);
            tvMsg = (TextView) itemView.findViewById(R.id.tv_msg);
            tvErrMsg = (TextView) itemView.findViewById(R.id.err_msg);


        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProfile, ivMore;
        TextView tvUserName;
        RelativeLayout headerView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            ivProfile = (ImageView) itemView.findViewById(R.id.trending_profilePic);
            ivMore = (ImageView) itemView.findViewById(R.id.iv_more);
            tvUserName = (TextView) itemView.findViewById(R.id.trending_name);
            headerView = (RelativeLayout) itemView.findViewById(R.id.header_view);
        }
    }
}