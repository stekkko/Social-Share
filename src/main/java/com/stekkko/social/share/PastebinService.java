package com.stekkko.social.share;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PastebinService {


    private static Pattern pattern = Pattern.compile("https://pastebin.com/*");
    private static LanguageMap LANGUAGE_MAP = new LanguageMap();
    private static String PASTEBIN_BASE_URL = "https://pastebin.com/api/api_post.php";
    private static String API_DEV_KEY = "HYeqw2eo4oK3QumYeOS8LaW_LlIZky8_";


    public static String share(String selection, String fileExtension, String fileName) throws Exception {
        return shareAndGetResponse(selection, fileExtension, fileName);
        //return extractKeyFrom(response);
    }

    private static String shareAndGetResponse(String selection, String fileExtension, String fileName) throws IOException {
        URL url = new URL(PASTEBIN_BASE_URL);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        String data =
                "api_dev_key=" + API_DEV_KEY +
                        "&api_option=" + "paste" +
                        "&api_paste_private=" + 0 +
                        "&api_paste_name=" + "Shared: " + URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString()) +
                        "&api_paste_expire_date=" + "N" +
                        "&api_paste_format=" + LANGUAGE_MAP.getLanguageDropdownIdFor(fileExtension) +
                        "&api_paste_code=" + URLEncoder.encode(selection, StandardCharsets.UTF_8.toString());

        writer.write(data);
        writer.flush();
        writer.close();

        StringBuffer answer = loadResponse(conn);

        return answer.toString();
    }


    private static StringBuffer loadResponse(URLConnection conn) throws IOException {
        StringBuffer answer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            answer.append(line);
        }

        reader.close();
        return answer;
    }


    private static String extractKeyFrom(String response) {
        Matcher matcher = pattern.matcher(response);

        if (matcher.find()) {
            return matcher.group(1);
        }

        throw new RuntimeException("Sorry. Plugin wasn't able to extract url to pasted code fragment.\n" + response);
    }
}
