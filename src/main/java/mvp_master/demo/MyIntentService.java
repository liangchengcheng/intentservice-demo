package mvp_master.demo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:    { IntentService }
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //IntentService 会使用单独的线程来执行该方法的代码
        //该方法内执行耗时任务，比如下载文件，或者数据库查询，这里我们进行数据的模式等待20s
        long endTime = System.currentTimeMillis() + 20 * 1000;
        Log.e("lcc","start");
        while(System.currentTimeMillis()<endTime){
            synchronized (this){
                try {
                    wait(endTime-System.currentTimeMillis());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        Log.e("lcc","---------------over-------------------");
    }
}
