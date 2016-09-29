package com.timehop.stickyheadersrecyclerview.sample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersTouchListener;
import com.timehop.stickyheadersrecyclerview.sample.pojo.Datum;
import com.timehop.stickyheadersrecyclerview.sample.pojo.Response;
import com.timehop.stickyheadersrecyclerview.sample.pojo.TrendingDataPojo;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * interface
 * to handle interaction events.
 * Use the factory method to
 * create an instance of this fragment.
 */
public class TrendingFragment extends Fragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = TrendingFragment.class.getSimpleName();
    private ProgressDialog mProgressHUD;
    private ImageView listType;
    private RecyclerView trendingListView;
    public StickyHeaderAdapter mListAdapter;
    private LinearLayout editSearch;
    private String keyword = "";
    private boolean linearListType = true;
    private String lat = "", log = "";
    private View mRootView;
    private int pageno = 1, total_page = 0;
    private List<Datum> list;
    LinearLayoutManager linearManager;
    private StickyRecyclerHeadersDecoration headersDecor;
    private StickyRecyclerHeadersTouchListener stickyRecyclerHeadersTouchListener;
    private RecyclerView trendingGridView;
    private String imagePath;      //contains path of the image to be shared on WhatsApp , Facebook and Instagram
    private String imageDescription; //contains description text of the image to be shared on WhatsApp , Facebook and Instagram
    private Bitmap theBitmap;      //contains the bitmap of the image to be shared
    private SwipeRefreshLayout swipeToRefreshList;
    private SwipeRefreshLayout swipeToRefreshGrid;
    private boolean decorationAdded = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_trending, container, false);
        initViews();
        setRecyclerView();
        getTrendingData();
        return mRootView;
    }

    private void initViews() {
        swipeToRefreshList = (SwipeRefreshLayout) mRootView.findViewById(R.id.list_refresh);
        swipeToRefreshList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mListAdapter.setMarginFromTop(true);
                pageno = 1;

                headersDecor.invalidateHeaders();
                getTrendingData(swipeToRefreshList);
            }
        });

        swipeToRefreshGrid = (SwipeRefreshLayout) mRootView.findViewById(R.id.grid_refresh);
        swipeToRefreshGrid.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageno = 1;
                getTrendingData(swipeToRefreshGrid);
            }
        });

        listType = (ImageView) mRootView.findViewById(R.id.trending_listSelector);
        editSearch = (LinearLayout) mRootView.findViewById(R.id.trending_editSearch);
        trendingListView = (RecyclerView) mRootView.findViewById(R.id.trending_list);
        trendingGridView = (RecyclerView) mRootView.findViewById(R.id.trending_grid);
        list = new ArrayList<>();
    }

    private int previousTotal = 0;
    private boolean loading = true;
    int firstVisibleItem, visibleItemCount, totalItemCount;

    /**
     * setting up recycler view for list view
     */
    private void setRecyclerView() {
        linearManager = new LinearLayoutManager(getActivity());
        trendingListView.setLayoutManager(linearManager);
        if (mListAdapter != null) {
            trendingListView.setAdapter(mListAdapter);
        }
        trendingListView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = trendingListView.getChildCount();
                RecyclerView.LayoutManager manager = trendingListView.getLayoutManager();
                if (manager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) manager;
                    totalItemCount = linearManager.getItemCount();
                    firstVisibleItem = linearManager.findFirstVisibleItemPosition();
                } else if (manager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager staggeredManager = (StaggeredGridLayoutManager) manager;
                    totalItemCount = staggeredManager.getItemCount();
                    int[] arr = new int[2];
                    staggeredManager.findFirstVisibleItemPositions(arr);
                    firstVisibleItem = arr[0];
                }

                if (!swipeToRefreshList.isRefreshing()) {
                    if (loading) {
                        if (totalItemCount > previousTotal) {
                            loading = false;
                            previousTotal = totalItemCount;
                        }
                    }
                    if (!loading && (totalItemCount - visibleItemCount)
                            <= (firstVisibleItem) && pageno <= total_page) {
                        // End has been reached
                        getTrendingData();
                        loading = true;
                    }
                }
            }
        });
    }

    /**
     * Adding item decorator for sticky header view
     */
    private void addHeaderDeconrator() {
        decorationAdded = true;
        Log.d(TAG, "adding header decorator");
        headersDecor = new StickyRecyclerHeadersDecoration(mListAdapter);
        trendingListView.addItemDecoration(headersDecor);
//        trendingListView.addItemDecoration(new DividerDecoration(getActivity()));
        stickyRecyclerHeadersTouchListener = new StickyRecyclerHeadersTouchListener(trendingListView, headersDecor);
        stickyRecyclerHeadersTouchListener.setOnHeaderClickListener(new StickyRecyclerHeadersTouchListener.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(View header, int position, long headerId) {

            }
        });

        trendingListView.addOnItemTouchListener(stickyRecyclerHeadersTouchListener);
        mListAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                if (headersDecor != null) {
                    trendingListView.invalidateItemDecorations();
                    headersDecor.invalidateHeaders();
                    Log.d("headers invalidated ","headers invalidated once");
                }
            }
        });

        final Runnable  mInvalidate = new Runnable() {
            @Override
            public void run() {
                trendingListView.invalidateItemDecorations();
                headersDecor.invalidateHeaders();
            }
        };

        mListAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                if (mInvalidate != null) {
                    trendingListView.post(mInvalidate);
                }
            }

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount) {
                if (mInvalidate != null) {
                    trendingListView.post(mInvalidate);
                }
            }

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                if (mInvalidate != null) {
                    trendingListView.post(mInvalidate);
                }
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                if (mInvalidate != null) {
                    trendingListView.post(mInvalidate);
                }
            }
        });
    }
    // get all trending images form server
    private void getTrendingData() {

        if (pageno!=1){
//            headersDecor.ITEM_OFFSET =0;
        }
        WebServices.trendingimages(String.valueOf(pageno), "145", " ", keyword, lat, log, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                parseTrendingData(responseString);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getActivity(), "Try Again!", Toast.LENGTH_SHORT).show();
                loading = false;
            }
        });
    }

    // get all trending images form server
    private void getTrendingData(final SwipeRefreshLayout swipeRefreshLayout) {
        WebServices.trendingimages(String.valueOf(pageno), "145", "", keyword, lat, log, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                swipeRefreshLayout.setRefreshing(false);
                parseTrendingData(responseString, true, swipeRefreshLayout);
            }
        });
    }

    //TODO
    private void parseTrendingData(String json) {
        pageno++;
        Gson gson = new Gson();
        TrendingDataPojo pojo = gson.fromJson(json, TrendingDataPojo.class);
        Response response = pojo.getResponse();
        total_page = response.getTotalPages();
        setAdapter(response);
    }

    private void parseTrendingData(String json, boolean isSwipeToRefresh, SwipeRefreshLayout swipeRefreshLayout) {
        pageno++;
        Gson gson = new Gson();
        TrendingDataPojo pojo = gson.fromJson(json, TrendingDataPojo.class);
        Response response = pojo.getResponse();
        total_page = response.getTotalPages();
        setAdapter(response, isSwipeToRefresh);
    }

    private void setAdapter(final Response response) {
        if (mListAdapter == null) {
            if (getActivity() == null) {
                return;
            }

            list.addAll(response.getData());
            mListAdapter = new StickyHeaderAdapter(getActivity(), list, response);
            trendingListView.setAdapter(mListAdapter);

            trendingListView.removeItemDecoration(headersDecor);
            if(trendingListView.getAdapter()!=null) {
                headersDecor = new StickyRecyclerHeadersDecoration(mListAdapter);
                trendingListView.addItemDecoration(headersDecor);
            }
        } else {
            mListAdapter.addData(response.getData());
            if (trendingListView.getAdapter() == null) {
                trendingListView.setAdapter(mListAdapter);
            }
        }
    }

    private void setAdapter(final Response response, boolean isSwipeToRefresh) {
        if (mListAdapter == null) {
            if (getActivity() == null) {
                return;
            }
            mListAdapter = new StickyHeaderAdapter(getActivity(), list, response);
            trendingListView.setAdapter(mListAdapter);
            trendingListView.removeItemDecoration(headersDecor);
            if (trendingListView.getAdapter() != null) {
                headersDecor = new StickyRecyclerHeadersDecoration(mListAdapter);
                trendingListView.addItemDecoration(headersDecor);
            }
        } else {
            mListAdapter.addData(response.getData(), isSwipeToRefresh);
            if (trendingListView.getAdapter() == null) {
                trendingListView.setAdapter(mListAdapter);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            Bundle mBundle = data.getExtras();
            lat = mBundle.getString("lat");      //these lat and log  value are coming from searching screen  if user has changed them
            log = mBundle.getString("log");
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    @Override
    public void onRefresh() {
        pageno = 1;
        getTrendingData();
    }
}