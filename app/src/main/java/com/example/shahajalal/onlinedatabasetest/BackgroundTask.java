package com.example.shahajalal.onlinedatabasetest;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String, Void, String> {

    Context context;
    String reg_url;

    BackgroundTask(Context ctx){

        this.context=ctx;
    }


    @Override
    protected void onPreExecute() {
        reg_url="https://shahajalal001samrat.000webhostapp.com/registration.php";
    }

    @Override
    protected String doInBackground(String... params) {


        String method=params[0];

        if(method.equals("register")){

            String name=params[1];
            String userName=params[2];
            String userPass=params[3];

            try {
                URL url =new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String data= URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(userName,"UTF-8")+"&"+
                        URLEncoder.encode("user_pass","UTF-8")+"="+URLEncoder.encode(userPass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream  inputStream=httpURLConnection.getInputStream();
                inputStream.close();
                return  "Registration Successful";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return  null;

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context,result,Toast.LENGTH_LONG).show();
    }
}
