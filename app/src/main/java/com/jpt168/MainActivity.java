package com.jpt168;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends Activity {

    Button testNewNotice;
    Button testNoticeReaded;
    Button testSMSCode;
    Button testGet;
    Button testPost;
    Button testNotice;
    Button testCity;
    Button testSystemTime;
    Button testOrderQuery;
    Button testCountry;
    Button testAirline;
    Button testAirport;
    Button testFrequentQuery;
    Button testAddFrequent;
    Button testUpdateFrequent;
    Button testDelFrequent;
    Button testCreateOrder;
    Button testPayUrl;
    Button testPayVerify;
    Button testFareRule;
    Button testCabinCheck;
    Button testPriceCheck;
    Button testDealer;
    Button testConsumers;
    Button testUserLogin;
    Button testResetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);
//        if (android.os.Build.VERSION.SDK_INT > 9) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }
//        testNewNotice = (Button)findViewById(R.id.testNewNotice);
//        testNoticeReaded = (Button)findViewById(R.id.testNoticeReadedApi);
//        testSMSCode = (Button)findViewById(R.id.testSMSCodeApi);
//        testGet = (Button) findViewById(R.id.testGet);
//        testPost = (Button) findViewById(R.id.testPost);
//        testNotice = (Button) findViewById(R.id.testNotice);
//        testCity = (Button) findViewById(R.id.testCity);
//        testSystemTime = (Button) findViewById(R.id.testSystemTime);
//        testOrderQuery = (Button) findViewById(R.id.testOrderQuery);
//        testCountry = (Button) findViewById(R.id.testCountry);
//        testAirline = (Button) findViewById(R.id.testAirline);
//        testAirport = (Button) findViewById(R.id.testAirport);
//        testFrequentQuery = (Button) findViewById(R.id.testFrequentQuery);
//        testAddFrequent = (Button) findViewById(R.id.testAddFrequent);
//        testUpdateFrequent = (Button) findViewById(R.id.testUpdateFrequent);
//        testDelFrequent = (Button) findViewById(R.id.testDelFrequent);
//        testCreateOrder = (Button) findViewById(R.id.testCreateOrder);
//        testPayUrl = (Button) findViewById(R.id.testPayUrl);
//        testPayVerify = (Button) findViewById(R.id.testPayVerify);
//        testFareRule = (Button) findViewById(R.id.testFareRule);
//        testCabinCheck = (Button) findViewById(R.id.testCabinCheck);
//        testPriceCheck = (Button) findViewById(R.id.testPriceCheck);
//        testDealer = (Button) findViewById(R.id.testDealer);
//        testConsumers = (Button) findViewById(R.id.testConsumers);
//        testUserLogin = (Button) findViewById(R.id.testUserLogin);
//        testResetPwd = (Button) findViewById(R.id.testResetPwd);
//        testNewNotice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final GetNewNoticeTask getNewNoticeTask = new GetNewNoticeTask(MainActivity.this,2);
//                getNewNoticeTask.setShowDialog(true);
//                getNewNoticeTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//                        if(o instanceof NewNotice){
//                            NewNotice newNotice = (NewNotice)o;
//                            Log.i("testNewNotice","number-->" + newNotice.getNewNoticesNumber());
//                            Log.i("testNewNotice","result-->" + newNotice.getResult());
//                            Log.i("testNewNotice","message-->" + newNotice.getMessage());
//                        }
//                    }
//                });
//                TaskManager.executeTask(getNewNoticeTask);
//            }
//        });
//
//        testNoticeReaded.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetNoticeReadedTask getNoticeReadedTask = new GetNoticeReadedTask(MainActivity.this,2,110,0);
//                getNoticeReadedTask.setShowDialog(true);
//                getNoticeReadedTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener(){
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//                        NoticeReaded noticeReaded = (NoticeReaded)o;
//                        Log.i("testNoticeReaded","UnReadedNumber-->" + noticeReaded.getUnReadedNumber());
//                        Log.i("testNoticeReaded","Result-->" + noticeReaded.getResult());
//                        Log.i("testNoticeReaded","Message-->" + noticeReaded.getMessage());
//                    }
//                });
//                TaskManager.executeTask(getNoticeReadedTask);
//            }
//        });
//
//        testSMSCode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetSMSCodeTask getSMSCodeTask = new GetSMSCodeTask(MainActivity.this,"chensp001","13800138000",2,0);
//                getSMSCodeTask.setShowDialog(true);
//                getSMSCodeTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//                        SMSCode smsCode = (SMSCode)o;
//                        Log.i("testSMSCode","Message-->" + smsCode.getMessage());
//                        Log.i("testSMSCode","Result-->" + smsCode.getResult());
//                        Log.i("testSMSCode","OperationResult-->" + smsCode.getOperationResult());
//                    }
//                });
//                TaskManager.executeTask(getSMSCodeTask);
//            }
//        });
//
//        testGet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = "http://124.74.111.138:6010/user/GetNewNoticesNumber" + "?request={\"UserId\":" + 2 + ",\"Partner\":\"" + "jintong\"" + ",\"TimeSpan\":\"" + "2015-07-01 15:07:54\"}";
//                url = url.replaceAll("\"", "%22");
//                url = url.replaceAll(" ", "%20");
//                url = url.replaceAll("\\{", "%7B");
//                url = url.replaceAll("\\}", "%7D");
//                Log.i("testGet","url-->" + url);
//
//
//                HttpGet httpGet = new HttpGet(url);
//                HttpClient httpClient = new DefaultHttpClient();
//                try{
//                    HttpResponse response = httpClient.execute(httpGet);
//                    HttpEntity httpEntity = response.getEntity();
//                    InputStream inputStream = httpEntity.getContent();
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//                    String result = "";
//                    String line = "";
//                    while (null != (line = reader.readLine())){
//                        result += line;
//                    }
//                    Log.i("testGet","result-->" + result);
//                }catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        testPost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String httpUrl="http://124.74.111.138:6010/user/GetNewNoticesNumber";
//                String resultData="";
//                URL url=null;
//                try{
//                    url=new URL(httpUrl);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//                if(url!=null){
//                    try{
//                        HttpURLConnection urlConn=(HttpURLConnection)url.openConnection();
//                        urlConn.setDoInput(true);
//                        urlConn.setDoOutput(true);
//                        urlConn.setRequestMethod("POST");
//                        urlConn.setUseCaches(false);
//                        urlConn.setInstanceFollowRedirects(true);
//                        urlConn.setRequestProperty("contentType", "GBK");
//                        urlConn.connect();
//                        DataOutputStream out=new DataOutputStream(urlConn.getOutputStream());
//                        String content="request={\"TimeSpan\":\"2015-07-01 15:07:54\",\"Partner\":\"jintong\",\"UserId\":2}";
//                        Log.i("testPost","content-->" + content);
//                        out.writeBytes(content);
//                        out.flush();
//                        out.close();
//                        BufferedReader reader=new BufferedReader(new InputStreamReader(urlConn.getInputStream(),"GBK"));
//                        String inputLine=null;
//                        while((inputLine=reader.readLine())!=null){
//                            resultData+=inputLine+"\n";
//                        }
//                        reader.close();
//                        urlConn.disconnect();
//                        Log.i("testPost","resultData-->" + resultData);
//                    }catch (Exception e){
//                        e.printStackTrace();;
//                    }
//                }
//
//            }
//        });
//
//        testNotice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetNoticeTask getNoticeTask = new GetNoticeTask(MainActivity.this,3,5,1,2);
//                getNoticeTask.setShowDialog(true);
//                getNoticeTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getNoticeTask);
//            }
//        });
//
//        testCity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetCityTask getCityTask = new GetCityTask(MainActivity.this);
//                getCityTask.setShowDialog(true);
//                getCityTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getCityTask);
//            }
//        });
//
//        testSystemTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetTimeTask getTimeTask = new GetTimeTask(MainActivity.this);
//                getTimeTask.setShowDialog(true);
//                getTimeTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getTimeTask);
//            }
//        });
//
//        testOrderQuery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetOrderQueryTask getOrderQueryTask = new GetOrderQueryTask(MainActivity.this,1,"chensp001",3,1,10,"","","","","","",0,"2015-06-17 00:00:00","2015-06-18 00:00:00",2,"jintong","2015-06-18 14:41:55");
//                getOrderQueryTask.setShowDialog(true);
//                getOrderQueryTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getOrderQueryTask);
//            }
//        });
//
//        testCountry.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetCountryTask getCountryTask = new GetCountryTask(MainActivity.this);
//                getCountryTask.setShowDialog(true);
//                getCountryTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getCountryTask);
//            }
//        });
//
//        testAirline.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetAirlineTask getAirlineTask = new GetAirlineTask(MainActivity.this);
//                getAirlineTask.setShowDialog(true);
//                getAirlineTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getAirlineTask);
//            }
//        });
//
//        testAirport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetAirportTask getAirportTask = new GetAirportTask(MainActivity.this);
//                getAirportTask.setShowDialog(true);
//                getAirportTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getAirportTask);
//            }
//        });
//
//        testFrequentQuery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetFrequentQueryTask getFrequentQueryTask = new GetFrequentQueryTask(MainActivity.this,0,"zhang",99,2,1,2);
//                getFrequentQueryTask.setShowDialog(true);
//                getFrequentQueryTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getFrequentQueryTask);
//            }
//        });
//
//        testAddFrequent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AddFrequentTask addFrequentTask = new AddFrequentTask(MainActivity.this,0,"zhang/san",0,"1980-01-01 00:00:00",0,"G12345678",1,"CN","2020-06-19 00:00:00","CN","13800138000","021-12345678","testabc@testabc.com",2);
//                addFrequentTask.setShowDialog(true);
//                addFrequentTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(addFrequentTask);
//            }
//        });
//
//        testUpdateFrequent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UpdateFrequentTask updateFrequentTask = new UpdateFrequentTask(MainActivity.this,1060,"geng/xin",1,"2005-02-02 00:00:00",1,"1234567890156",0,"US","2025-06-19 00:00:00","US","987654321","13579","update@msn.com",2);
//                updateFrequentTask.setShowDialog(true);
//                updateFrequentTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(updateFrequentTask);
//            }
//        });
//
//        testDelFrequent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DelFrequentTask delFrequentTask = new DelFrequentTask(MainActivity.this,1061,2);
//                delFrequentTask.setShowDialog(true);
//                delFrequentTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(delFrequentTask);
//            }
//        });
//
//        testCreateOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CreateOrderTask createOrderTask = new CreateOrderTask(MainActivity.this,"8c5f3d65-decb-4342-9c38-e00165167073","ZHANG/KANGXIN",0,"1980-01-01 00:00:00",0,"G12345678",1,"CN","2020-01-01 00:00:00","127.0.0.1","","","","",false,false,2);
//                createOrderTask.setShowDialog(true);
//                createOrderTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(createOrderTask);
//            }
//        });
//
//        testPayUrl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetPayUrlTask getPayUrlTask = new GetPayUrlTask(MainActivity.this,"150617595197","ZFB",2);
//                getPayUrlTask.setShowDialog(true);
//                getPayUrlTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getPayUrlTask);
//            }
//        });
//
//        testPayVerify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetPayVerifyTask getPayVerifyTask = new GetPayVerifyTask(MainActivity.this,"150617595197","ZFB",2);
//                getPayVerifyTask.setShowDialog(true);
//                getPayVerifyTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getPayVerifyTask);
//            }
//        });
//
//        testFareRule.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetFareRuleTask getFareRuleTask = new GetFareRuleTask(MainActivity.this,"RTPVGHKG20150621_00010101Y_ADU_1_","ea369c90-508d-40a5-af8b-2eae591253a9",2);
//                getFareRuleTask.setShowDialog(true);
//                getFareRuleTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getFareRuleTask);
//            }
//        });
//
//        testCabinCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetCabinCheckTask getCabinCheckTask = new GetCabinCheckTask(MainActivity.this,"RTPVGHKG20150621_00010101Y_ADU_1_","e1fec756-c706-4181-8329-f35e466ce754",1,2);
//                getCabinCheckTask.setShowDialog(true);
//                getCabinCheckTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getCabinCheckTask);
//            }
//        });
//
//        testPriceCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetPriceCheckTask getPriceCheckTask = new GetPriceCheckTask(MainActivity.this,"RTPVGHKG20150621_00010101Y_ADU_1_","70bada30-eabc-461b-b5fb-47aef857af44",1,0,0,2);
//                getPriceCheckTask.setShowDialog(true);
//                getPriceCheckTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getPriceCheckTask);
//            }
//        });
//
//        testDealer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetDealerTask getDealerTask = new GetDealerTask(MainActivity.this,2);
//                getDealerTask.setShowDialog(true);
//                getDealerTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getDealerTask);
//            }
//        });
//
//        testConsumers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetConsumersTask getConsumersTask = new GetConsumersTask(MainActivity.this,1);
//                getConsumersTask.setShowDialog(true);
//                getConsumersTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getConsumersTask);
//            }
//        });
//
//        testUserLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetUserLoginTask getUserLoginTask = new GetUserLoginTask(MainActivity.this,"chensp001","666888",0);
//                getUserLoginTask.setShowDialog(true);
//                getUserLoginTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getUserLoginTask);
//            }
//        });
//
//        testResetPwd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GetResetPwdTask getResetPwdTask = new GetResetPwdTask(MainActivity.this,"oemtest111","13801639889","8wnqs8",0);
//                getResetPwdTask.setShowDialog(true);
//                getResetPwdTask.addOnTaskFinishedListener(new JPTTask.OnTaskFinishedListener() {
//                    @Override
//                    public void onTaskFinish(Object o, JPTTask task, Exception exception) {
//
//                    }
//                });
//                TaskManager.executeTask(getResetPwdTask);
//            }
//        });
    }


}
