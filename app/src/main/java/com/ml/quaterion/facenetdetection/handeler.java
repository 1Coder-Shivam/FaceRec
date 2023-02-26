package com.ml.quaterion.facenetdetection;

import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class handeler {
    static long lastdate=0;
  static void arengeSet(Set<String> st){
       Date date=new Date();
       if((long)date.getTime()-lastdate>30000  && !st.isEmpty()){
           //Toast.makeText(getC,)
           Log.d("number",st.toString()+" "+lastdate);
           String pattern = "E, dd MMM yyyy HH:mm:ss z";
           String pat="MM_dd_yyyy";
           SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
           Log.d("Time",simpleDateFormat.format(date));
           lastdate=date.getTime();

         String filename=  new SimpleDateFormat(pat).format(date);
           Log.d("Timea",filename);
           try{
               File root = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"FinalProjectAttendance");
               Log.d("numberu",root.getAbsolutePath());
               if(!root.exists()){
                   root.mkdir();
                   Log.d("numberu","myfile");
               }
               File filepath = new File(root,"DSA"+filename+".txt");
               FileWriter writer = new FileWriter(filepath);
               writer.append(st.size()+"\n"+st.toString());
               writer.flush();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }

       }

    }
}
