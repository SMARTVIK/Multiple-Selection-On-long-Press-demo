package com.timehop.stickyheadersrecyclerview.sample;
/**
 * all static fields that are same used every where in class
 * constant fields are defiened here
 */

import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.List;


public class Constants {
	public static final String TYPE_USER = "4";
	public static final String TIME_PATTERN = "yyyy-MM-dd hh:mm:ss";
	public static final String DATE_FORMAT = "dd MMM, yyyy";
	public static final String USER_IS_BLOGGER = "1";
	public static final String BLOG_BOOKING_INFO = "blogBookingInfo";
	public static final String BLOG_STAT = "blogStats";
	public static final String HOME_SERVICE = "Home Services";
	public static final String MARK_IMAGE_FAV = "markImageFavorite";
	public static final String TIMEING = "timing";
	public static final String SUGGESTIONS = "is_suggestions_available";
	public static final String KEYWORD = "keyword";
	public static final String TRENDING_IMAGES = "trendingimages";
	public static final String GET_VENDOR_DETAILS = "getVendordetails";
	public static final String REVENUE_BY_DATE = "blogRevenueByDate";
	public static final String KEY_HASH = "o5Ak7jvJxBTa/LoAvUmDqQz28c0=";
	public static final String GROOMEFY_URL = "http://www.groomefy.com/";
	public static final String USER_IS_NOT_BLOGGER = "0";
	public static final int WRITE_EXTERNAL_STORAGE = 100;
	public static final int WRITE_EXTERNAL_STORAGE_WRITE = 101;
	public static final String VIEW_SERVICE = "blogClick";
	public static final int SEARCHING = 800;
	public static final int ACCESS_LOCATION_PERMISSION = 1000;
	public static final int CAMERA = 300;
	public static final double SCREEN_SIZE = 5.5;
	public static Typeface BOLD ;
	public static Typeface FONT_LIGHT;
	public static Typeface FONT_REGULAR;
	public static Typeface FONT_SEMIBOLD;

	public static final String webservice_success = "200";
	public static final String webservice_fail = "500";
	public static final String TEMP_PHOTO_FILE_NAME = "groomefytemp_photo.jpg";
	public static final String REVIMGPATH = "reviewimagepath";
//	public static final String VENDOR_IMGPATH = "http://admin.groomefy.com/vendor_image/";
//	public static final String VENDOR_IMGPATH = "http://beta.groomefy.com/vendor_image/";
	public static final ArrayList<String> COLOR_LIST = new ArrayList<String>() {{

		add("#00AE8F");
		add("#F44CA3");
		add("#9433E7");
		add("#E0A300");
		add("#3677EE");
		add("#E40F32");
		add("#7EA227");
		add("#08B3E5");

	}};

	//instagram integration
	public static final String CLIENT_ID = "your client id";
	public static final String CLIENT_SECRET = "your client secret";
	public static final String CALLBACK_URL = "redirect uri here";


	//Login flag

	public static final String isLogin = "isLogin";
	public static final String isWakthrough = "isWakthrough";
	public static final String DEVICE_TOKEN_GCM = "devicetoken";
	public static final String IMAGE_HEIGHT = "";
	public static final String FULL_IMAGE = "full_image";


	//My Account Blogger
	public static final String USER_EARNINGS = "userEarning";
	public static final String BLOG_LIST = "blogList";
	public static final String BLOG_STATS = "statistsBlogs";
	public static final String DATE_FOR_STATS = "date_for_stats";
	public static final String USER_IAMGE_BASE_URL = "http://beta.groomefy.com/user_images/";
	public static final String BLOG_ID = "blog_id";
	public static final String VENDOR_IMG_PATH = "http://beta.groomefy.com/vendor_image/";
	public static final String REVENUE_DATE = "revenue_date";
	public static final String HASH_TAG = "hash_tag";
	public static final String IS_BLOGGER = "blogger";

	/**
	 *  Trending screen
	 */
	public static String trendingRefresh = "0";
	public static final String USERNAME = "USERNAME";
	public static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";
	public static final ArrayList<String> SERVICES_MAIN = new ArrayList<String>() {{

		add("HAIR");
		add("FACE");
		add("BODY");
		add("NAILS");
		add("SPA");
		add("BODY ART");

	}};


	public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	public static final String[] DAYS = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	public static final String[] FROMHOURS = {"8:00 AM","8:30 AM","9:00 AM","9:30 AM","10:00 AM",
		"10:30 AM","11:00 AM","11:30 AM","12:00 PM","12:30 PM","1:00 PM","1:30 PM",
		"2:00 PM","2:30 PM","3:00 PM","3:30 PM","4:00 PM","4:30 PM","5:00 PM","5:30 PM","6:00 PM","6:30 PM","7:00 PM","7:30 PM","8:00 PM","8:30 PM","9:00 PM","9:30 PM","10:00 PM",
		"10:30 PM","11:00 PM","11:30 PM","12:00 AM","12:30 AM","1:00 AM","1:30 AM",
		"2:00 AM","2:30 AM","3:00 AM","3:30 AM","4:00 AM","4:30 AM","5:00 AM","5:30 AM","6:00 AM","6:30 AM","7:00 AM","7:30 AM"};

	public static final String[] TOHOURS = {"5:00 PM","5:30 PM","6:00 PM","6:30 PM","7:00 PM","7:30 PM","8:00 PM","8:30 PM","9:00 PM","9:30 PM","10:00 PM",
		"10:30 PM","11:00 PM","11:30 PM","12:00 AM","12:30 AM","1:00 AM","1:30 AM",
		"2:00 AM","2:30 AM","3:00 AM","3:30 AM","4:00 AM","4:30 AM","5:00 AM","5:30 AM","6:00 AM","6:30 AM","7:00 AM","7:30 AM","8:00 AM","8:30 AM","9:00 AM","9:30 AM","10:00 AM",
		"10:30 AM","11:00 AM","11:30 AM","12:00 PM","12:30 PM","1:00 PM","1:30 PM",
		"2:00 PM","2:30 PM","3:00 PM","3:30 PM","4:00 PM","4:30 PM"};

	public static final String[] SUB_CATEGORY = {"Haircuts and Hairdressing", "Blow Dry", "Hair Colouring and Highlights Treatments",
		"Hair Conditioning and Scalp Treatments", "Hair Consulting", "Brazilian Blow Dry Keratin Treatment", "Waxing","Hollywood Waxing",
		"Brazilian Waxing", "Threading", "French Bikini Wax","Male Waxing","Deep Tissue Massage","Therapeutic Massage",
		"Swedish Massage","Aromatherapy Massage","Thai Massage","Stone Massage Therapy","Pedicure","Manicure","Gel Nails","Two Week Manicure","Two Week Pedicure","Nail Extensions and Overlays",
		"Facials","Eyebrow and Eyelash Treatments","Eyelash Extensions","Microdermabrasion","HD Brows","Men's Facial",
		"Spray Tanning and Sunless Tanning","Body Wraps","Body Exfoliation Treatments","Colonic Hydrotherapy","Sunbeds and Tanning Booths","Steam and Sauna Therapy"};
		public static final String[] SUB_CATEGORY_ID = {"8","9","10","11","12","13","14","15","16","17","18",
			"19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43"};

	public static class Database {
		public static final String DATABASE_NAME = "ToolsKit.sqlite";
		public static final String COMPETENCY_DATA_TABLE = "COMPETENCY_TABLE";
		public static final String MASTER_DATA_TABLE = "MASTER_TABLE";
		public static final String ASSESSMENTS_TABLE = "ASSESSMENTS_TABLE";
	}

	public static List<String> getMainMenuList() {
		List<String> mainMenuList = new ArrayList<String>();
		mainMenuList.clear();
		mainMenuList.add("START A NEW ASSESSMENTS");
		mainMenuList.add("SAVED ASSESSMENTS");
		mainMenuList.add("INCOMPLETE ASSESSMENTS");
		mainMenuList.add("START BASELINE ASSESSMENTS");
		mainMenuList.add("VIEW CASE STUDIES");
		return mainMenuList;
	}

    // Common Constants
    public static final String RESPONSE = "response";
    public static final String CODE = "code";
    public static final String MESSAGE = "message";
    public static final String DATA = "data";
    public static final String THUMBNAILPATH = "thumbnail_path";
    public static final String IMG_PATH = "image_path";


	// Trending services
	public static final String IS_FAV = "is_favorite";
	public static final String IS_LIKED = "is_liked";
	public static final String CAT_ID = "category_id";
	public static final String SUB_CAT_ID = "sub_category_id";
	public static final String PROD_ID = "product_id";
	public static final String TOTAL_LIKE_COUNT = "total_like_count";
	public static final String IMAGE_NAME = "image_name";
	public static final String MARK_FAV = "mark_favorite";
	public static final String VENDOR_ID = "vendor_id";
	public static final String VENDOR_NAME = "vendor_name";
	public static final String VENDOR_IMAGE = "vendor_image";
	public static final String ID = "id";
	public static final String DESCRIPTION = "description";
	public static final String TRENDING_SEQ = "trending_sequence";
	public static final String CREATED_DATE = "created_date";
	public static final String LIKE_COUNT = "like_count";
	public static final String TAG_VENDOR_ID = "tag_vendor_id";
	public static final String TAG_VENDOR_NAME = "tag_vendor_name";
    public static final String TYPE = "type";
    public static final String VENDOR_IMAGEPATH = "vendor_image_path";
	public static final String VENDOR_THMBPATH = "vendor_thumbnail_path";


    //Login
    public static final String OTPCODE = "otp_code";
    public static final String STATUS = "status";
    public static final String USERID = "user_id";
    public static final String NAME = "user_name";
    public static final String USER_PHOTO = "user_photo";
	public static final String USER_DOB = "user_dob";
	public static final String USER_EMAIL = "user_email";
	public static final String USER_GENDER = "user_gender";

	//Category By Location
	public static final String SUB_CATEGORY_NAME = "category_name";
	public static final String TOTAL_NO_SHOP = "total_number_shop";

	//MyScreen
	public static final String ACTIVITYID = "activity_id";
	public static final String VENDOR_ADDR = "vendor_address";
	public static final String GALLERY_IMG = "gallery_image";
	public static final String RATING_VALUE = "rating_value";
	public static final String ACTIVITY_TYPE = "activity_type";
	public static final String REVIEW_TXT = "review_text";
	public static final String REVIEW_IMGS = "review_images";
	public static final String USER_POST_IMAGE = "user_post_image";
	public static final String USER_POST = "user_post";

	public static final String USER_THUMB_PATH = "user_thumbnail_path";
	public static final String USER_IMAGE_PATH = "user_image_path";
	public static final String GALLERY_IMGPATH = "gallery_image_path";
	public static final String GALLERY_THUMBPATH = "gallery_thumbnail_path";
	public static final String REVIEW_IMGPATH = "review_image_path";
	public static final String REVIEW_THUMBPATH = "review_thumbnail_path";

	public static final String USER_IMGPATH = "user_image_path";
	public static final String USER_THUMBPATH = "user_thumbnail_path";
	public static final String USER_DATA = "user_data";
	public static final String IMAGE_ID = "image_id";
	public static final String ISLIKE = "is_like";
	public static final String SERVICES_FOR = "services_for";
	public static final String SERVICES_TYPE = "services_type";

	//WishList
	public static final String WISHLISTID = "wishlist_id";
	public static final String TOTAL_SERVICE = "total_service";
	public static final String SHOP_ID = "shop_id";
	public static final String TOTAL_PRICE = "total_price";
	public static final String PROD_THUMBPATH = "product_thumb_image_path";
	public static final String PROD_IMGPATH = "product_image_path";

	//MyScreen FollowTab
	public static final String PROD_NAME = "product_name";
	public static final String PROD_PRICE = "product_price";
	public static final String PROD_DESC = "product_description";
	public static final String GALLERY_DESC = "gallery_description";
	public static final String VENDOR_TYPE = "vendor_type";
	public static final String LOGO_IMG = "logo_image";
	public static final String PROD_IMGS = "product_images";
	public static final String IMG_DESC = "image_description";
	public static String USERFOLLOWLIST = "vendorFollowActivity";

	//ReviewListing Rate
	public static final String RATING_PTS = "rating_points";
	public static final String REVIEW = "review";
	public static final String REVIEWID = "review_id";

	//Get User Address
	public static final String GETUSERADDR = "getUserAddress";
	public static final String ADDRESS = "address";
	public static final String ADDRESS_ID = "address_id";
	public static final String HOUSE_NO = "house_no";
	public static final String STREET = "street";
	public static final String LOCALITY = "locality";
	public static final String CITY = "city";
	public static final String CONTACT_NO = "contact_number";

	//Notifications
	public static final String NOTIF_ID = "notification_id";
	public static final String BOOKING_ID = "booking_id";
	public static final String NOTIF_DATE = "notification_date";
	public static final String BOOKING_DATE = "booking_date";
	public static final String BOOKING_STATUS = "booking_status";

}
