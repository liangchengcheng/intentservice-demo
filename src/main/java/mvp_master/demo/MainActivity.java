package mvp_master.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月17日14:49:36
 * Description:  老大那天问我IntentService  我却只知道能耗时操作不知道能自己结束，于是写个demo记下来！
 */
public class MainActivity extends AppCompatActivity {

    // TODO: 2015/12/17 Service 是不会转码你启动一个单独的    进程   他和他所在的应用都在痛一个进程里面 。
    
    // TODO: 2015/12/17  Service 也不是一个新的线程 因此不能在里面直接进行耗时操作

    // TODO: 2015/12/17 [IntentService]：
    // TODO: 2015/12/17 1会创建独立的work  线程去处理请求
    // TODO: 2015/12/17 2 会创建独立的woker 线程去处理onHandleIntent 里面的方法  无需处理多线程问题
    // TODO: 2015/12/17 3 所有请求处理完成后，IntentService会自动停止，无需调用stopSelf()方法停止Service； 
    // TODO: 2015/12/17 4 为Service的onBind()提供默认实现，返回null；
    // TODO: 2015/12/17 5 为Service的onStartCommand提供默认实现，将请求Intent添加到队列中；
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // TODO: 2015/12/17 启动MyIntentService的会使用单独的worker线程，因此不会阻塞前台的UI线程；而MyService会。     
        findViewById(R.id.btn_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建所需要启动的Service的Intent
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });

        findViewById(R.id.btn_intentservice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                startService(intent);
            }
        });
    }

}
