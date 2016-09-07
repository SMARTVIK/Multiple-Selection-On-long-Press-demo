package com.timehop.stickyheadersrecyclerview.sample;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

/**
 * all webservice methods are mentioned here which are used from various classes and adapters
 */
public class WebServices {
    private static final String TAG = WebServices.class.getSimpleName();


    //these are live urls

//        public static final String VENDOR_IMAGE = "http://admin.groomefy.com/vendor_image/";
//        private static final String BOGGER_BETA_BASE_URL = "http://admin.groomefy.com/consumerapi/";
//    public static final String GALLERY_THUMBNAILS = "http://admin.groomefy.com/gallery_images/thumbnails/";

    //these are BETA urls
    public static final String VENDOR_IMAGE = "http://beta.groomefy.com/vendor_image/";
    private static final String BOGGER_BETA_BASE_URL = "http://beta.groomefy.com/consumerapi/";
    public static final String GALLERY_THUMBNAILS = "http://beta.groomefy.com/gallery_images/thumbnails/";
    public static final String USER_IMAGES = "http://beta.groomefy.com/user_images/";


    public static String TOKEN = "65083469071c68692af56a4ddb842f51";
    public static String TRENDING_IMAGES = "newtrendingimages";
    public static String LIKE_FAV = "markImageFavorite";
    public static String LOGIN = "login";
    public static String CREATEPROFILE = "createprofile";
    public static String CATEGORYBYLOCATION = "totalCategoryByLocation";
    public static String SHOP_LIST_BY_LOCATION = "getShopByLocation";
    public static String SHOP_DETAILS = "getShopDetails";
    public static String USERACTIVITYLIST = "myactivity";
    public static String USERWISHLIST = "getWishlist";
    public static String PRODUCT_LISTING = "getProductListing";
    public static String CREATE_WISHLIST = "createWishlist";
    public static String WISHLIST_LISTING = "getWishlist";
    public static String GETSHOPRATING = "getShopRating";
    public static String ADDSHOPRATING = "newaddShopRating";
    public static String ADDUSERADDRESS = "addUserAddress";
    public static String FOLLOW_SHOP = "followShop";
    public static String CREATE_BOOKING = "createBooking";
    public static String FOLLOW_LIST = "myfollowlist";
    public static String BOOKING_LISTING = "getBookingListing";
    public static String AUTOSUGGESTIONS = "autoSuggestKeywords";
    public static String CANCEL_APPOINTMENT = "cancelAppointment";
    public static String REVIEW_LISTING = "reviewListing";
    public static String SHOP_GALLERY = "shopgalleryimages";
    public static String ADDNEWPOST = "adduserpost";
    public static String REPORT_TEMPLATE = "gettemplet";
    public static String REPORT_CONTENT = "reportcontent";
    public static String ADD_PAYMENT_DETAILS = "addPaymentDetails";
    public static String USERFAVORITES = "getfavoritetrendingdetail";
    public static String GET_FAV_LIKED = "getfavoriteandlike";
    public static String DELETE_USER_ADDRESS = "removeuseraddress";
    public static String GETIMGFAVANDLIKE = "getImageFavoriteAndLike";
    public static String REMOVEACTIVITY = "removemyactivity";
    public static String GETNOTIFICATIONS = "getconsumernotification";

    static AsyncHttpClient client = new AsyncHttpClient();

    public static void removemyactivity(String user_id, String activity_id, String id, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("methodname", REMOVEACTIVITY);
        paramslist.put("user_id", user_id);
        paramslist.put("activity_id", activity_id);
        paramslist.put("id", id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void getImageFavoriteAndLike(String user_id, String image_id, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", GETIMGFAVANDLIKE);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("image_id", image_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void autoSuggestKeywords(String keyword, String search_type, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", AUTOSUGGESTIONS);
        paramslist.put("token", TOKEN);
        paramslist.put("keyword", keyword);
        paramslist.put("search_type", search_type);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void getReportTemplate(JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("methodname", REPORT_TEMPLATE);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void reportContent(String user_id, String id, String template_id, String content_type, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("image_id", id);
        paramslist.put("template_id", template_id);
        paramslist.put("content_type", content_type);
        paramslist.put("methodname", REPORT_CONTENT);

        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void adduserpost(String user_id, String imgID, String vendor_id, String user_post, String post_images, String tagVendorId, String tagVendorName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", ADDNEWPOST);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("id", imgID);
        paramslist.put("vendor_id", vendor_id);
        paramslist.put("user_post", user_post);
        paramslist.put("post_images", post_images);
        paramslist.put("vendor_id", tagVendorId);
        paramslist.put("vendor_name", tagVendorName);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void addUserAddress(String user_id, String house_no, String street, String locality, String city, String contact_number, String address_id, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", ADDUSERADDRESS);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("house_no", house_no);
        paramslist.put("street", street);
        paramslist.put("locality", locality);
        paramslist.put("city", city);
        paramslist.put("contact_number", contact_number);
        paramslist.put("address_id", address_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void createProfile(String id, String name, String email, String dob, String gender, String img, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", CREATEPROFILE);
        paramslist.put("token", TOKEN);
        paramslist.put("id", id);
        paramslist.put("name", name);
        paramslist.put("email", email);
        paramslist.put("dob", dob);
        paramslist.put("gender", gender);
        paramslist.put("user_photo", img);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void login(String countrycode, String mobno, String device_id, String device_token, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", LOGIN);
        paramslist.put("token", TOKEN);
        paramslist.put("countrycode", countrycode);
        paramslist.put("username", mobno);
        paramslist.put("device_type", "1");
        paramslist.put("device_token", device_token);
        paramslist.put("device_id", device_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void getCategoryByLocation(String category_id, String lat, String longi, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", CATEGORYBYLOCATION);
        paramslist.put("token", TOKEN);
        paramslist.put("lat", lat);
        paramslist.put("log", longi);
        paramslist.put("category_id", category_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void trendingimages(String page_no, String user_id, String fav, String keyword, String lat, String log, TextHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", TRENDING_IMAGES);
        paramslist.put("page_no", page_no);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("favorite", fav);
        paramslist.put("keyword", keyword);
        paramslist.put("lat", lat);
        paramslist.put("log", log);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void ShopListingByLocation(String page_no, String category_id, String latitude, String logitude, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("page_no", page_no);
        paramslist.put("category_id", category_id);
        paramslist.put("latitude", latitude);
        paramslist.put("logitude", logitude);
        paramslist.put("methodname", SHOP_LIST_BY_LOCATION);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void ShopListingByFilter(String page_no, String category_id, String latitude, String logitude, String services_for, String services_type, String order_by, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("page_no", page_no);
        paramslist.put("category_id", category_id);
        paramslist.put("latitude", latitude);
        paramslist.put("logitude", logitude);
        paramslist.put("services_for", services_for);
        paramslist.put("services_type", services_type);
        paramslist.put("order_type", "ASC");
        paramslist.put("order_by", order_by);

        paramslist.put("methodname", SHOP_LIST_BY_LOCATION);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void commonService(String methodname, String user_id, JsonHttpResponseHandler jsonHttpResponseHandler) {
        Log.d(TAG, " hitting webservice from common service ");
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", methodname);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void sendToken(String token, String user_id, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("regid", token);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void GetShopDetail(String shop_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("shop_id", shop_id);
        paramslist.put("methodname", SHOP_DETAILS);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void DeleteUserAddress(String user_id, String address_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("address_id", address_id);
        paramslist.put("methodname", DELETE_USER_ADDRESS);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void getFavLiked(String user_id, String product_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("product_id", product_id);
        paramslist.put("methodname", GET_FAV_LIKED);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }


    public static void GetShopDetailWithLogin(String user_id, String shop_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("shop_id", shop_id);
        paramslist.put("methodname", SHOP_DETAILS);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void getProductListing(String shop_id, String category_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("shop_id", shop_id);
        paramslist.put("category_id", category_id);
        paramslist.put("methodname", PRODUCT_LISTING);

        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void getShopGallery(String shop_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("shop_id", shop_id);
        paramslist.put("methodname", SHOP_GALLERY);

        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void createWishlist(String user_id, String shop_id, String product_id, String category_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("shop_id", shop_id);
        paramslist.put("product_id", product_id);
        paramslist.put("category_id", category_id);
        paramslist.put("methodname", CREATE_WISHLIST);

        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void removeWishlist(String is_removed, String user_id, String shop_id, String product_id, String category_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("is_removed", is_removed);
        paramslist.put("user_id", user_id);
        paramslist.put("shop_id", shop_id);
        paramslist.put("product_id", product_id);
        paramslist.put("category_id", category_id);
        paramslist.put("methodname", CREATE_WISHLIST);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void getWishlist(String user_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("methodname", WISHLIST_LISTING);
        WebServices.post(paramslist, jsonHttpResponseHandler);

    }

    public static void likeFavorite(String user_id, String id, String likeOrFav, String status, String vendor_id, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", LIKE_FAV);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("id", id);
        paramslist.put(likeOrFav, status);
        paramslist.put("vendor_id", vendor_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }


    public static void addShopRating(String user_id, String vendor_id, String rating_points, String review, String review_images, String is_review, String is_rating, String review_id, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", ADDSHOPRATING);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("vendor_id", vendor_id);
        paramslist.put("rating_points", rating_points);
        paramslist.put("review", review);
        paramslist.put("review_images", review_images);
        paramslist.put("is_review", is_review);
        paramslist.put("is_rating", is_rating);
        paramslist.put("review_id", review_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void getShopRating(String user_id, String vendor_id, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", GETSHOPRATING);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("vendor_id", vendor_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void getReviewListing(String user_id, String shop_id, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", REVIEW_LISTING);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("shop_id", shop_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void getFollowList(String user_id, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", FOLLOW_LIST);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void followShop(String user_id, String vendor_id, String is_follow, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", FOLLOW_SHOP);
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("vendor_id", vendor_id);
        paramslist.put("is_follow", is_follow);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }


    public static void createBooking(String address, String address_id, String booking_amount, String current_date, String payment_mode, String service_for, String user_id, String vendor_id, String product_id, String booking_date, String booking_time, String service_type, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", CREATE_BOOKING);
        paramslist.put("token", TOKEN);

        paramslist.put("address", address);
        paramslist.put("address_id", address_id);
        paramslist.put("booking_amount", booking_amount);
        paramslist.put("booking_date", booking_date);
        paramslist.put("booking_time", booking_time);
        paramslist.put("current_date", current_date);
        paramslist.put("payment_mode", payment_mode);
        paramslist.put("product_id", product_id);
        paramslist.put("service_for", service_for);
        paramslist.put("service_type", service_type);
        paramslist.put("shop_id", vendor_id);
        paramslist.put("user_id", user_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }




    public static void createBooking(String postId, String address, String address_id, String booking_amount, String current_date, String payment_mode, String service_for, String user_id, String vendor_id, String product_id, String booking_date, String booking_time, String service_type, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("methodname", CREATE_BOOKING);
        paramslist.put("token", TOKEN);
        paramslist.put("post_id",postId);
        paramslist.put("address", address);
        paramslist.put("address_id", address_id);
        paramslist.put("booking_amount", booking_amount);
        paramslist.put("booking_date", booking_date);
        paramslist.put("booking_time", booking_time);
        paramslist.put("current_date", current_date);
        paramslist.put("payment_mode", payment_mode);
        paramslist.put("product_id", product_id);
        paramslist.put("service_for", service_for);
        paramslist.put("service_type", service_type);
        paramslist.put("shop_id", vendor_id);
        paramslist.put("user_id", user_id);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }






    public static void addPaymentDetail(String base_amount, String booking_id, String charges, String gateway_response, String payment_type, String pg_txn_id, String transaction_id, String user_id, String vendor_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("base_amount", base_amount);
        paramslist.put("booking_id", booking_id);
        paramslist.put("charges", charges);
        paramslist.put("gateway_response", gateway_response);
        paramslist.put("payment_type", payment_type);
        paramslist.put("pg_txn_id", pg_txn_id);
        paramslist.put("transaction_id", transaction_id);
        paramslist.put("user_id", user_id);
        paramslist.put("vendor_id", vendor_id);


        paramslist.put("methodname", ADD_PAYMENT_DETAILS);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void cancelBooking(String booking_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("booking_id", booking_id);
        paramslist.put("methodname", CANCEL_APPOINTMENT);
        WebServices.post(paramslist, jsonHttpResponseHandler);
    }

    public static void getBookingListingNotif(String booking_id, JsonHttpResponseHandler jsonHttpResponseHandler) {

        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("booking_id", booking_id);
        paramslist.put("methodname", BOOKING_LISTING);
        WebServices.post(paramslist, jsonHttpResponseHandler);

    }

    public static void getBookingListing(String user_id, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("methodname", BOOKING_LISTING);
        WebServices.post(paramslist, jsonHttpResponseHandler);

    }

    public static void getBlogs(String user_id, int page_no, String apiUrlName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("page_no", page_no);
        paramslist.put("methodname", apiUrlName);
        WebServices.getBlogger(apiUrlName, paramslist, jsonHttpResponseHandler);
    }

	/*{
        methodname = blogStats;
		post _id "= 124;
		user_id =
		month=“June 2016”
		token = 65083469071c68692af56a4ddb842f51;
	}*/


    public static void getBlogStats(String user_id, String post_id, String month, String apiUrlName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("post_id", post_id);
        paramslist.put("month", month);
        paramslist.put("methodname", apiUrlName);
        WebServices.getBlogger(apiUrlName, paramslist, jsonHttpResponseHandler);
    }

    public static void getlocationaddress(String url, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        WebServices.get(url, paramslist, jsonHttpResponseHandler);
    }

    public static void post(RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
        String finalUrl = BOGGER_BETA_BASE_URL;
        Log.v("Post url...", "" + finalUrl);
        Log.v("Post Parameters", "" + params);
        client.post(finalUrl, params, jsonHttpResponseHandler);
    }

    public static void post(RequestParams params, TextHttpResponseHandler jsonHttpResponseHandler) {
        String finalUrl = BOGGER_BETA_BASE_URL;
        Log.v("Post url...", "" + finalUrl);
        Log.v("Post Parameters", "" + params);
        client.post(finalUrl, params, jsonHttpResponseHandler);
    }

    public static void get(String apiNameUrl, RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
        String finalUrl = BOGGER_BETA_BASE_URL + apiNameUrl;
        Log.e("Post url...", "" + finalUrl);
        client.get(finalUrl, params, jsonHttpResponseHandler);
    }

    public static void getBlogger(String apiNameUrl, RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
        String finalUrl = BOGGER_BETA_BASE_URL;
        Log.e("Post url...", "" + finalUrl);
        client.post(finalUrl, params, jsonHttpResponseHandler);
    }

    /**
     * dont call this method
     */
    public static void onInit() {
        client.addHeader("ContentType", "application/x-www-form-urlencoded");
        client.addHeader("Access", "application/json");
        client.setTimeout(30000);
    }

    public static void getUserStats(String userId, String apiUrlName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", userId);
        paramslist.put("methodname", apiUrlName);
        getBlogger(apiUrlName, paramslist, jsonHttpResponseHandler);
    }

    public static void getBlogRevenueByMonth(String user_id, String month, String apiURLName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", user_id);
        paramslist.put("methodname", apiURLName);
        paramslist.put("month", month);
        getBlogger(apiURLName, paramslist, jsonHttpResponseHandler);
    }

    public static void getBlogStatsByMonth(String userId, String month, String apiUrlName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", userId);
        paramslist.put("methodname", apiUrlName);
        paramslist.put("month", month);
        getBlogger(apiUrlName, paramslist, jsonHttpResponseHandler);
    }

    public static void getBlogBookingInfoByDate(String userID, String postId, String date, String apiUrlName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", userID);
        paramslist.put("methodname", apiUrlName);
        paramslist.put("date", date);
        paramslist.put("post_id", postId);
        getBlogger(apiUrlName, paramslist, jsonHttpResponseHandler);
    }

    public static void getBlogStatistics(String userId, String month, String apiUrlName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", userId);
        paramslist.put("methodname", apiUrlName);
        paramslist.put("month", month);
        getBlogger(apiUrlName, paramslist, jsonHttpResponseHandler);
    }

    public static void isBlogger(String userId, String apiUrlName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", userId);
        paramslist.put("methodname", apiUrlName);
        getBlogger(apiUrlName, paramslist, jsonHttpResponseHandler);
    }

    public static void postBookmark(String apiUrlName, String userId, String vendorId, String postId, String likeValue, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", userId);
        paramslist.put("id", postId);
        paramslist.put("mark_favorite", likeValue);
        paramslist.put("vendor_id", vendorId);
        paramslist.put("methodname", apiUrlName);
        like(apiUrlName, paramslist, jsonHttpResponseHandler);
    }


    public static void likePost(String apiUrlName, String userId, String vendorId, String postId, String likeValue, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", userId);
        paramslist.put("id", postId);
        paramslist.put("like", likeValue);
        paramslist.put("vendor_id", vendorId);
        paramslist.put("methodname", apiUrlName);
        like(apiUrlName, paramslist, jsonHttpResponseHandler);
    }

    private static void like(String apiUrlName, RequestParams paramslist, JsonHttpResponseHandler jsonHttpResponseHandler) {
        String finalUrl = BOGGER_BETA_BASE_URL;
        Log.e("Post url...", "" + finalUrl);
        client.post(finalUrl, paramslist, jsonHttpResponseHandler);
    }

    public static void getHashtag(String userId, int page_number, String apiUrlName, String keyword, String lat, String log, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("user_id", userId);
        paramslist.put("page_no", Integer.toString(page_number));
        paramslist.put("log", log);
        paramslist.put("lat", lat);
        paramslist.put("methodname", apiUrlName);
        paramslist.put("keyword", keyword);
        getBlogger(apiUrlName, paramslist, jsonHttpResponseHandler);
    }

    public static void getVendorDetails(String vendorIds, String apiUrlName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("methodname", apiUrlName);
        paramslist.put("vendor_id", vendorIds);
        getBlogger(apiUrlName, paramslist, jsonHttpResponseHandler);
    }

    public static void getBlogRevenueByDate(String userId, String date, String apiUrlName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("methodname", apiUrlName);
        paramslist.put("user_id", userId);
        paramslist.put("date",date);
        getBlogger(apiUrlName, paramslist, jsonHttpResponseHandler);

    }

    public static void viewCountService(String postId, String apiUrlName, JsonHttpResponseHandler jsonHttpResponseHandler) {
        RequestParams paramslist = new RequestParams();
        paramslist.put("token", TOKEN);
        paramslist.put("methodname", apiUrlName);
        paramslist.put("id",postId);
        getBlogger(apiUrlName, paramslist, jsonHttpResponseHandler);
    }

    public interface WebServiceListener {

        public void onSuccess(String arg0);

        public void onFailure(String arg1);

    }

}
