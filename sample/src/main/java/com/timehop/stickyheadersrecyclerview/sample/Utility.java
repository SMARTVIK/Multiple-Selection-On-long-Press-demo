package com.timehop.stickyheadersrecyclerview.sample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore.Images;
import android.telephony.TelephonyManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Wildnet technologies
 */
public class Utility {

    private float mWidthPixels;
    private float mHeightPixels;


    private  void setRealDeviceSizeInPixels(Context context) {

        WindowManager windowManager = ((Activity)context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);

        // since SDK_INT = 1;
        mWidthPixels = displayMetrics.widthPixels;
        mHeightPixels = displayMetrics.heightPixels;

        // includes window decorations (statusbar bar/menu bar)
        if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
            try {
                mWidthPixels = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
                mHeightPixels = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
            } catch (Exception ignored) {
            }
        }

        // includes window decorations (statusbar bar/menu bar)
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                Point realSize = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(display, realSize);
                mWidthPixels = realSize.x;
                mHeightPixels = realSize.y;
            } catch (Exception ignored) {
            }
        }

    }

    public  double getDeviceScreenSize(Context context){
        setRealDeviceSizeInPixels(context);
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(mWidthPixels / dm.xdpi, 2);
        double y = Math.pow(mHeightPixels / dm.ydpi, 2);
        double screenInches = Math.sqrt(x + y);
        return screenInches;
    }


     public static int getPhoneDpiLevel(Context context){
         DisplayMetrics metrics = new DisplayMetrics();
         WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
         windowManager.getDefaultDisplay().getMetrics(metrics);
         switch(metrics.densityDpi){
             case DisplayMetrics.DENSITY_LOW:
                 return 1;
             case DisplayMetrics.DENSITY_MEDIUM:
                 return 2;
             case DisplayMetrics.DENSITY_HIGH:
                 return 3;
             default:
                 return -1;
         }
     }


    public static Spannable createSpannableText(String startString, String endString) {
        Spannable spannable = new SpannableString(startString + " " + endString);
        int preLen = startString.length();
        int postLen = endString.length();
        spannable.setSpan(new CustomTypefaceSpan(Constants.BOLD), 0, preLen, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new CustomTypefaceSpan(Constants.FONT_REGULAR), preLen, preLen + postLen, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return spannable;
    }

    public static void createSpannableText(String string, String mainString , Spannable spannable , int colorcode, final Context context) {
        String[] arr = string.split("(?=#)");
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            final String s = arr[i];
            int from = mainString.indexOf(s.trim());
            int to = from + s.length();
            spannable.setSpan(new MyClickableSpan() {
                @Override
                public void onClick(View widget) {


                }
                @Override
                public void updateDrawState(TextPaint ds) {
                    ds.setUnderlineText(false);
                }
            }, from, to, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            spannable.setSpan(new ForegroundColorSpan(colorcode), from, to, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        }
    }


    public static Spannable createSpannableTextSecond(String string, int colorcode, final Context context) {
        if (string == null) {
            return null;
        }
        Spannable spannable = new SpannableString(string);

        if (getCount(string,' ')==0 && getCount(string)>1){
            createSpannableText(string,string,spannable,colorcode,context);
            return spannable;
        }
        String[] arr = string.split(" ");
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            final String s = arr[i];

            if (s.contains("#")) {
                int countHash = getCount(s);
                if (countHash > 1) {
                    createSpannableText(s, string, spannable, colorcode, context);
                } else {
                    int from = string.indexOf(s.trim());
                    int to = from + s.length();
                    spannable.setSpan(new MyClickableSpan() {
                        @Override
                        public void onClick(View widget) {

                            showToast(context,s);
                        }

                        @Override
                        public void updateDrawState(TextPaint ds) {
                            ds.setUnderlineText(false);
                        }
                    }, from, to, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    spannable.setSpan(new ForegroundColorSpan(colorcode), from, to, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                }
            }

        }
        return spannable;
    }

    private static int getCount(String s) {
        int counter = 0;
        for( int i=0; i<s.length(); i++ ) {
            if( s.charAt(i) == '#' ) {
                counter++;
            }
        }
        return counter;
    }


    private static int getCount(String s, char ch) {
        int counter = 0;
        for( int i=0; i<s.length(); i++ ) {
            if( s.charAt(i) == ch ) {
                counter++;
            }
        }
        return counter;
    }




    public static String formatNumber(String totalLikeCount) {
        String formatedNum = null;
        try {
            int num = Integer.parseInt(totalLikeCount);
            if (num >= 1000) {
                formatedNum = formatNumber((double) num / 1000) + "k";
            } else {
                return String.valueOf(num);
            }
        } catch (NumberFormatException e) {

        }
        return formatedNum;
    }

    public static String formatNumber(double v) {
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        return df.format(v);

    }

    public static String formatTime(String createdDate) {
        long millis = getMillis(createdDate);
        return changeMillisToDate(millis);

    }

    public static String changeMillisToDate(long millis) {
        String msg = null;
        Calendar cal = Calendar.getInstance();
        long diff = (cal.getTimeInMillis() - millis);
        long temp = diff / 60000;
        if (temp >= 60) {
            temp = temp / 60;
            if (temp >= 24) {
                temp = temp / 24;
                if (temp > 1) {
                    cal.setTimeInMillis(millis);
                    Date date = cal.getTime();

                    return formatDate(date);

                } else {
                    msg = temp + " day ago";
                }
            } else {
                msg = temp + " hour ago";
            }
        } else {
            msg = temp + " min ago";
        }
        return msg;
    }

    public static String formatDate(Date date) {
        DateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault());

        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.YEAR) == getYear(date)){

            String tempDate = simpleDateFormat.format(date);
            return tempDate.substring(0,tempDate.indexOf(","));
        }

        return simpleDateFormat.format(date);
    }

    private static int getYear(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        return calendar.get(Calendar.YEAR);
    }

    private static long getMillis(String createdDate) {
        long millis = 0;

        SimpleDateFormat format = new SimpleDateFormat(Constants.TIME_PATTERN);
        try {
            Date date = format.parse(createdDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            millis = calendar.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return millis;
    }

    public static int convertDpToPixel(int dp, Context context) {
        float density = (float) getDensityInDpi(context) / 160;

        return (int) (dp * density);
    }

    public static int getDisplayWidth(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    public static class Config {
        public static final boolean DEVELOPER_MODE = false;
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }


    public static void addPreferences(Context context, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences("VOTE_INDIA", Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getPreferences(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences("VOTE_INDIA", Context.MODE_PRIVATE);
        String text = prefs.getString(key, "");
        return text;
    }

    public static class Extra {
        public static final String IMAGES = "com.nostra13.example.universalimageloader.IMAGES";
        public static final String IMAGE_POSITION = "com.nostra13.example.universalimageloader.IMAGE_POSITION";
    }

    public static int getDensityInDpi(Context mContext) {
        final DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenDensity = metrics.densityDpi;
        return screenDensity;
    }

    public static int convertPxToDpi(Context mContext, int value) {
        int mValue = value;
        mValue = mValue / (getDensityInDpi(mContext) / 160);

        return mValue;

    }

    // clear the cache data from call
    public static boolean deleteCacheDirectory(Context context) {
        final String sdState = android.os.Environment.getExternalStorageState();
        File cacheDir;

        if (sdState.equals(android.os.Environment.MEDIA_MOUNTED)) {
            final File sdDir = android.os.Environment.getExternalStorageDirectory();
            cacheDir = new File(sdDir, "data/tac/images");
        } else
            cacheDir = context.getCacheDir();
        return deleteDir(cacheDir);
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            final String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // The directory is now empty so delete it
        return dir.delete();
    }


    @SuppressLint("SimpleDateFormat")
    /***
     *
     * @param SimpleDateFormat
     * @return
     * get Current data with spacified formmate
     * like getCTime(dd-MM-yy); for 02-12-90
     */
    public static String getCTime(String SimpleDateFormat) {
        Date date = new Date();
        java.text.SimpleDateFormat sdf;
        sdf = new SimpleDateFormat(SimpleDateFormat);
        return sdf.format(date);
    }

    /**
     * This method Tells us that the device is connected with Internet
     *
     * @return True if connected/False if disconnected.
     **/
    public static boolean isInternetConnected(Context mContext) {

		/*
         * final ConnectivityManager connec = (ConnectivityManager)
		 * mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
		 *
		 * if (connec != null&& (connec.getNetworkInfo(1).getState() ==
		 * NetworkInfo.State.CONNECTED)|| (connec.getNetworkInfo(0).getState()
		 * == NetworkInfo.State.CONNECTED)) { return true; } return false;
		 */

        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }

        return false;

    }

    /**
     * This method is for displaying Toast Message on The Screen
     *
     * @param mContext
     * @param string
     */

    public static void showToast(Context mContext, String string) {
        Toast t = Toast.makeText(mContext, string, Toast.LENGTH_SHORT);
        t.show();
    }

    /**
     * This method is help to save the data in local sharedPrefences(Local data
     * file) <br>
     * public static void saveDataLocally(Context mContext, String key, String
     * data)
     *
     * @param
     */
    public static void saveDataTosharedPrefences(Context mContext, String key, String data) {
        final String PREFS_NAME = "SettingDetails";
        final SharedPreferences SpyAppData = mContext.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = SpyAppData.edit();
        editor.putString(key, data);
        editor.commit();
    }

    /**
     * This method gives the saved data from local SharedPreferences File by
     * just Send context and the key name of the data
     */
    public static String getDataFromsharedPrefences(Context mContext, String key) {
        final String PREFS_NAME = "SettingDetails";
        final SharedPreferences ToolsAppData = mContext.getSharedPreferences(PREFS_NAME, 0);
        final String preData = ToolsAppData.getString(key, "").trim();
        return preData;

    }

    /**
     * This Method gives the Device id associated with the Device
     *
     * @return String Device id
     */
    public static String getDeviceKey(Context mContext) {
        String theDevId;
        if (Utility.getDataFromsharedPrefences(mContext, "deviceid").length() > 0) {
            theDevId = Utility.getDataFromsharedPrefences(mContext, "deviceid");

        } else {

            theDevId = ((TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        }
        return theDevId;

    }

    public static Bitmap newResizeImage(Bitmap mImage, int mNewWidth, int mNewHeight) {
        System.gc();
        int w = mImage.getWidth();
        int h = mImage.getHeight();

        float scaleWidth = ((float) mNewWidth) / w;
        float scaleHeight = ((float) mNewHeight) / h;

        Matrix matrix = new Matrix();

        matrix.postScale(scaleWidth, scaleHeight);

        Bitmap mNewImg = Bitmap.createBitmap(mImage, 0, 0, w, h, matrix, true);

        return mNewImg;

    }

    /**
     * getting private key save in local data file this key is help to convert
     * string to SHA1 encryption
     * <p/>
     * Method <br>
     * Utility.getPrivateKey(Context context);
     *
     * @param=getPrivateKey
     */

    public static String getPrivateKey(final Context mContext) {

        final String userKey = getDataFromsharedPrefences(mContext, "userKey").trim();

        if (userKey.length() != 0) {
            return userKey;
        }

        return null;
    }

    public static File getDataDir(Context context) throws Exception {
        File audioRoot = context.getDir("ToolsKit", Context.MODE_PRIVATE);
        if (audioRoot == null) {
            audioRoot.mkdir();
        }
        return audioRoot;
    }

    public static void deleteFileFromCache(Context mContext, String mFileName) {
        File rootfile = null;

        try {
            rootfile = getDataDir(mContext);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (rootfile != null) {
            File mfile = new File(rootfile, mFileName);
            if (mfile.exists()) {
                mfile.delete();
            }
        }
    }

    public static String getCurrentTime() {

        Calendar c = Calendar.getInstance();


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("gmt"));
        String formattedDate = df.format(c.getTime());
        return formattedDate;

    }

    public static String getTimeFormat(String time1) {
        final String time = time1;
        String t2 = "";

        try {
            DateFormat sdf = new SimpleDateFormat("hh:mm");
            final Date dateObj = sdf.parse(time);
            System.out.println(dateObj);
            System.out.println(new SimpleDateFormat("K:mm a").format(dateObj));
            t2 = new SimpleDateFormat("KK:mm a").format(dateObj).toString();
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return t2;
    }

    public static long dateDiff(String dateStart, String dateEnd) {

        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        String inputString1 = dateStart;
        String inputString2 = dateEnd;
        long totDays = 0;

        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            totDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return totDays;
    }

    public static String getDateFormat(String date1) {

        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = form.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat postFormater = new SimpleDateFormat("MMM dd, yyyy");
        String newDateStr = postFormater.format(date);

        return newDateStr;
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Uri getImageUri(Context inContext, Bitmap inImage) {
        if (inImage != null) {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            inImage.compress(Bitmap.CompressFormat.PNG, 100, bytes);
            String path = Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
            return Uri.parse(path);
        }
        return null;
    }

    public static boolean appInstalledOrNot(Context context, String pkgName) {
        boolean app_installed = false;
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo("" + pkgName, 0);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    public static Bitmap stringToBitmap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }


    public static boolean isLocationEnabled(Context context) {


        LocationManager lm = null;
        boolean gps_enabled = false, network_enabled = false;
        if (lm == null) {
            lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        }
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {

        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }
        if (gps_enabled == true && network_enabled == true) {
            return true;
        } else {
            return false;
        }

    }

    public static String printnotificationDifference(Date endDate) {

        //milliseconds
        StringBuilder updatedTime = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        Date startDate = null;
        try {
            startDate = dateFormat.parse(dateFormat.format(cal.getTime()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        long different = startDate.getTime() - endDate.getTime();

        //       System.out.println("startDate : " + startDate);
        //       System.out.println("endDate : "+ endDate);
        //       System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays,
                elapsedHours, elapsedMinutes, elapsedSeconds);
        if (elapsedDays > 0) {
            updatedTime.append(elapsedDays + " days");
            return updatedTime.toString();

        }
        if (elapsedHours > 0) {
            updatedTime.append(elapsedHours + " hour");
            return updatedTime.toString();


        }
        if (elapsedMinutes > 0) {
            updatedTime.append(elapsedMinutes + " minutes");
            return updatedTime.toString();


        }
        if (elapsedSeconds > 0) {
            updatedTime.append(elapsedSeconds + " second");
            return updatedTime.toString();


        }
        return updatedTime.toString();

    }

    public static boolean CheckDates(String currentDate, String clickDate) {

        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");

        boolean b = false;

        try {
            if (dfDate.parse(clickDate).before(dfDate.parse(currentDate))) {
                b = false;  // If start date is before end date.
            } else if (dfDate.parse(currentDate).equals(dfDate.parse(clickDate))) {
                b = true;  // If two dates are equal.
            } else {
                b = true; // If start date is after the end date.
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }


    public static String getMonthName(int month) {
        switch (month) {
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";
        }
        return null;
    }

}
