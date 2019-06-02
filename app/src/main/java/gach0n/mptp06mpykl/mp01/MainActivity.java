package gach0n.mptp06mpykl.mp01;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


//import com.example.mp01.service.JobSchedulerStart;

import gach0n.mptp06mpykl.mp01.Fragment.Menu1Fragment;
import gach0n.mptp06mpykl.mp01.Fragment.Menu2Fragment;
import gach0n.mptp06mpykl.mp01.Fragment.Menu3Fragment;

import com.example.mp01.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //XML UI 선언
    EditText input;
    Button button;
    Button callWebView;
    TextView output;
    TextView webPasingSubList1;
    TextView webPasingSubList2;
    String HTMLPageURL = "https://search.naver.com/search.naver?ie=utf8&query=";
    String HTMLContentInStringFormat = "";
    String subItemList1 = "";
    String subItemList2 = "";
    String subItemListPrice1 = "";
    String subItemListPrice2 = "";
    PendingIntent intent;
    NotificationManager notificationManager;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    int price = -1;
    WebView browser;
    Menu1Fragment menu1Fragment;
    Menu2Fragment menu2Fragment;
    Menu3Fragment menu3Fragment;
    timerThread t;
    webParsingThread wt;

    //Sublist
    String[] sub1_ = new String[10];
    String[] sub2_= new String[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //XML Inflation
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("tag", "onCreate()");
        final LinearLayout linear2 = findViewById(R.id.linear2);
        final LinearLayout linear1 = findViewById(R.id.linear1);
        //menu2Fragment = (Menu2Fragment) getSupportFragmentManager().findFragmentById(R.id.jaesin);
        final ViewPager mainViewPager = findViewById(R.id.mainViewPager);
        mainViewPager.setAdapter(new BottomNavigationAdapter(getSupportFragmentManager()));
        callWebView = findViewById(R.id.callWebView);
        t = new timerThread();
        wt = new webParsingThread();

        //




        final BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        mainViewPager.setCurrentItem(0);
                        return true;
                    case R.id.side:
                        mainViewPager.setCurrentItem(1);
                        return true;
                    case R.id.notification:
                        mainViewPager.setCurrentItem(2);
                        return true;
                    default:
                        return false;
                }
            }
        });


        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigation.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        //UI 끌당
        input = findViewById(R.id.input);
        button = findViewById(R.id.button);
        output = findViewById(R.id.output);
        output.setVisibility(View.INVISIBLE);
        output.setMovementMethod(new ScrollingMovementMethod());
        intent = PendingIntent.getActivity(this, 0, new Intent(getApplicationContext(), MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹크롤링 중입니다...", Toast.LENGTH_LONG).show();
                JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                jsoupAsyncTask.execute();
                if (output.getVisibility() == View.INVISIBLE) {
                    output.setVisibility(View.VISIBLE);
                }
                TextView sub1_1=findViewById(R.id.sub1_1);
                sub1_1.setText(sub1_[0]);
                TextView sub1_3=findViewById(R.id.sub1_3);
                sub1_3.setText(sub1_[1]);
                TextView sub1_5=findViewById(R.id.sub1_5);
                sub1_5.setText(sub1_[2]);
                TextView sub1_7=findViewById(R.id.sub1_7);
                sub1_7.setText(sub1_[3]);
                TextView sub1_9=findViewById(R.id.sub1_9);
                sub1_9.setText(sub1_[4]);
                TextView sub2_1=findViewById(R.id.sub2_1);
                sub2_1.setText(sub1_[5]);
                TextView sub2_3=findViewById(R.id.sub2_3);
                sub2_3.setText(sub1_[6]);
                TextView sub2_5=findViewById(R.id.sub2_5);
                sub2_5.setText(sub1_[7]);
                TextView sub2_7=findViewById(R.id.sub2_7);
                sub2_7.setText(sub1_[8]);
                TextView sub2_9=findViewById(R.id.sub2_9);
                sub2_9.setText(sub1_[9]);
                TextView sub1_2=findViewById(R.id.sub1_2);
                sub1_2.setText(sub2_[0]);
                TextView sub1_4=findViewById(R.id.sub1_4);
                sub1_4.setText(sub2_[1]);
                TextView sub1_6=findViewById(R.id.sub1_6);
                sub1_6.setText(sub2_[2]);
                TextView sub1_8=findViewById(R.id.sub1_8);
                sub1_8.setText(sub2_[3]);
                TextView sub1_10=findViewById(R.id.sub1_10);
                sub1_10.setText(sub2_[4]);
                TextView sub2_2=findViewById(R.id.sub2_2);
                sub2_2.setText(sub2_[5]);
                TextView sub2_4=findViewById(R.id.sub2_4);
                sub2_4.setText(sub2_[6]);
                TextView sub2_6=findViewById(R.id.sub2_6);
                sub2_6.setText(sub2_[7]);
                TextView sub2_8=findViewById(R.id.sub2_8);
                sub2_8.setText(sub2_[8]);
                TextView sub2_10=findViewById(R.id.sub2_10);
                sub2_10.setText(sub2_[9]);
            }
        });

        callWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browser = findViewById(R.id.webkit);
                if (browser.getVisibility() == View.INVISIBLE) {
                    browser.setVisibility(View.VISIBLE);
                }
                browser.getSettings().setJavaScriptEnabled(true);
                browser.setWebViewClient(new WebViewClient());
                browser.loadUrl("https://search.naver.com/search.naver?ie=utf8&query=" + input.getText());
            }
        });
        //혹시 예전에 썻던 쿼리가 있으면 써야지
        applySharedPreference();
    } // 여기까지가 onCreate?

    public void ThreadStarter(boolean go) {
        if (go) {
            t.start();
        } else {

        }
    }

    public void applySharedPreference() {
        sh_Pref = getSharedPreferences("Previous query", MODE_PRIVATE);
        if (sh_Pref != null && sh_Pref.contains("storedQuery")) {
            String storedQuery = sh_Pref.getString("storedQuery", "이주형 교수님 짱");
            resultClass.setQuery(storedQuery);
            input.setText(resultClass.getQuery());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // create menu
        menu.add(0, 0, 50, "Push notification").setIcon(R.drawable.push).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, 1, 50, "Info").setIcon(R.drawable.info).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Timer 설정");
                alert.setMessage("[여기에 ms 단위로 입력]");
                final EditText input = new EditText(this);
                if (timerClass.getTime() >= 10000) {
                    input.setHint(Integer.toString(timerClass.getTime()));
                } else {
                    input.setHint("최소 10초! (10000ms)");
                }
                alert.setView(input);
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String timerAsString = "";
                        try {
                            timerAsString = input.getText().toString();
                            Log.d("tag", "설정한 Timer 값 : " + timerAsString);
                            int timer = Integer.parseInt(timerAsString);
                            if (timer < 1) {
                                Toast.makeText(getApplicationContext(), "자연수로 입력해주세요", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (timer < 10000) {
                                Toast.makeText(getApplicationContext(), "최소 10초!(10000ms)", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            timerClass.setTime(timer);
                            ThreadStarter(true);
                        } catch (NumberFormatException e) {
                            Toast.makeText(getApplicationContext(), "자연수로 입력해주세요", Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Log.d("tag", e.toString());
                        }
                    }
                });
                alert.setNegativeButton("알림 해제", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        timerClass.setTime(-1);
                    }
                });
                alert.show();
                break;
            case 1:
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jaeesin/MP_YKL"));
                startActivity(i);
                break;
            default:
                Toast.makeText(getApplicationContext(), "default", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {
        int lowPrice;

        @Override
        protected void onPreExecute() {
            lowPrice = 999999999;
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Log.d("tag", "doInBackground()");
                String sample = "";
                String sub = "";
                String userQuery = input.getText().toString();
                HTMLPageURL += userQuery;
                Document doc = Jsoup.connect(HTMLPageURL).get();
                Log.d("tag", "\nHTMLPageURL(modified) : " + HTMLPageURL);


                //여기부터 리스트뷰, 여기에 걸리면 갤러리뷰엔 걸리지 않습니다.
                Elements titles = doc.select("div.info_price em.num");
                for (Element e : titles) {
                    sample = e.text();
                    sample = sample.replaceAll("\\,", "");
                    price = Integer.parseInt(sample);
                    if (price < lowPrice) {
                        lowPrice = price;
                    }
                }

                int c=0;
                //ITEM
                Elements subItems = doc.select("ul.product_list li.product_item div.info strong");
                for (Element e : subItems) {
                    sub = e.text();
                    sub1_[c] = sub;
                    c++;
                }
                c=0;
                //PRICE
                Elements subItems_ = doc.select("ul.product_list li.product_item div.info em.num");
                for (Element e : subItems_) {
                    sub = e.text();
                    sub = sub.replace(",", "");
                    sub2_[c] = sub;
                    c++;
                }


                //여기가 갤러리뷰, 리스트뷰에 걸렸다면 이곳에 걸리지 않습니다.
                titles = doc.select("em.price_num");
                //전처리를 하면서, 최저가를 찾습니다.
                for (Element e : titles) {
                    sample = e.text();
                    int index = sample.indexOf("저");
                    sample = sample.substring(index + 1, sample.length());
                    index = sample.indexOf("원");
                    sample = sample.substring(0, index);
                    sample = sample.replaceAll("\\,", "");
                    Log.d("tag", sample);
                    price = Integer.parseInt(sample);
                    if (price < lowPrice) {
                        lowPrice = price;
                    }
                }
                Log.d("tag", "현재 userQuery : " + userQuery);
                Log.d("tag", "현재 lowPrice : " + lowPrice);


                //혹시라도 검색어를 잘못 입력했다면, 잘못 입력된 검색어 말고 보통 어떤 올바른 검색어로 검색하는지 찾습니다.
                titles = doc.select("div.sp_keyword dd em");
                String modifiedKeyword = titles.text();
                //검색어를 제대로 입력한 경우
                if (modifiedKeyword == "") {
                    Log.d("tag", "ModifiedKeyword(\"\") : " + modifiedKeyword);
                    HTMLContentInStringFormat = userQuery + "로 검색하니 " + lowPrice + "라는 값이 최저가로 나왔습니다.";
                }
                //검색어를 제대로 입력하지 않았지만, 검색하고 싶은 것을 어림 잡을 수 있는 경우
                if (modifiedKeyword != "") {
                    Log.d("tag", "ModifiedKeyword(not \"\") : " + modifiedKeyword);
                    if (lowPrice == 999999999) {
                        HTMLContentInStringFormat = "검색어가 잘못 된 것 같네요, " + modifiedKeyword + "로 검색해 보세요!";
                    } else {
                        HTMLContentInStringFormat = "검색어가 잘못 된 것 같네요, 하지만 " + modifiedKeyword + "로 검색하니 " + lowPrice + "라는 값이 최저가로 나왔습니다.";
                    }
                }
                //검색어를 제대로 입력하지도 않았고, 무엇을 검색하려는지 알 수 없을 경우.
                if (modifiedKeyword == "" & lowPrice == 999999999) {
                    HTMLContentInStringFormat = "검색어가 잘못 된 것 같네요.";
                }

                //셰어드프리퍼런스에 최근 유저쿼리(방금 쓴 거) 저-장
                sharedPreference(userQuery);
                resultClass.setQuery(userQuery);
                resultClass.setLowest(lowPrice);
            }
            //Log메시지가 주석을 대신합니다.
            catch (NumberFormatException e) {
                Log.d("tag", e.toString());
            } catch (IOException e) {
                Log.d("tag", e.toString());
                HTMLContentInStringFormat = "인터넷 연결이 원활하지 않음.";
            } catch (ArrayIndexOutOfBoundsException e) {
                Log.d("tag", e.toString() + "씨발");
            } catch (Exception e) {
                Log.d("tag", e.toString());
            }
            resultClass.setMsg(HTMLContentInStringFormat);
            Log.d("tag", "resultClass.getMsg() : " + resultClass.getMsg());
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.d("tag", "onPostExecute()");
            output.setText(resultClass.getMsg());
            //output.setTextSize(16);

            Bundle myBundle = new Bundle();
            myBundle.putString("content1", subItemList1);
            myBundle.putString("content2", subItemList2);
            HTMLPageURL = "https://search.naver.com/search.naver?ie=utf8&query=";
            HTMLContentInStringFormat = "";
            subItemList1 = "";
            subItemList2 = "";
            notification();
        }
    }

    public void sharedPreference(String query) {
        sh_Pref = getSharedPreferences("Previous query", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("storedQuery", query);
        toEdit.commit();
    }

    //여기서 부터 쓰레드
    public class timerThread extends Thread {
        public void run() {
            Log.d("tag", "timerThread run");
            wt.start();
            while (true) {
                while (timerClass.getTime() > 0) {
                    try {
                        Thread.sleep(timerClass.getTime() + 3000);
                        if (timerClass.getTime() == -1) {
                            Log.d("tag", "웹파싱 스레드 존버중");
                        } else {
                            wt.run();
                        }
                    } catch (InterruptedException e) {
                        Log.d("tag", e.toString());
                    } catch (IllegalThreadStateException e) {
                        Log.d("tag", e.toString());
                    }
                }
            }
        }
    }

    public class webParsingThread extends Thread {
        public void run() {
            Log.d("tag", "WebParsingThread run");
            JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
            jsoupAsyncTask.execute();
        }
    }

    public void notification() {
        Log.d("tag", "notification()");
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(300);
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.circle4white) // 아이콘 설정하지 않으면 오류남
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentTitle(resultClass.getQuery() + "/" + resultClass.getLowest()) // 제목 설정
                .setContentText(resultClass.getMsg()) // 내용 설정
                .setTicker(resultClass.getMsg()) // 상태바에 표시될 한줄 출력
                .setAutoCancel(true)
                .setContentIntent(intent);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());


    }
}