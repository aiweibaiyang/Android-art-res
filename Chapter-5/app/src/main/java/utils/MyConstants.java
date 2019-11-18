package utils;

import android.os.Environment;

/**
 * Created by 25400 on 2019/11/17.
 */

public class MyConstants {

    public static final String CHAPTER_2_PATH = Environment.getExternalStorageDirectory().getPath() + "/art-code/Chapter-2/MyApplication";

    public static final String CACHE_FILE_PATH = CHAPTER_2_PATH + "usercache";

    public static final int MSG_FROM_CLIENT = 0;
    public static final int MSG_FROM_SERVICE = 1;

    public static final String REMOTE_ACTION = "com.ryg.chapter.action_REMOTE";
    public static final String EXTRA_REMOTE_VIEWS = "extra_remoteViews";
}
