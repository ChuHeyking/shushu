package com.chu.imgcraw;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class WeaponCraw {

    public static void main(String[] args) throws IOException {
        String url = "https://wiki.biligame.com/ys/%E6%AD%A6%E5%99%A8%E5%9B%BE%E9%89%B4";
        Document document = Jsoup.parse(new URL(url), 10000);
        Element cardSelectTr = document.getElementById("CardSelectTr");
        //System.out.println(cardSelectTr);
        Elements imgs = cardSelectTr.getElementsByTag("img");
        int i = 0;
        for (Element img : imgs) {
            String src = img.attr("src");
            String name = img.attr("alt");

            URL target = new URL(src);
            URLConnection urlConnection = target.openConnection();
            InputStream ins = urlConnection.getInputStream();
            FileOutputStream fos = new FileOutputStream("D:\\Y\\picture\\原神项目ps素材\\database\\weaponIMG\\"+name);

            byte[] bytes = new byte[1204*8];
            int len = 0;

            while ((len=ins.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }

            fos.close();
            ins.close();
            System.out.println(i++);
        }

    }
}
