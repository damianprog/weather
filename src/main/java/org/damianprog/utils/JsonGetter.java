package org.damianprog.utils;

import java.io.IOException;

import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
public class JsonGetter {

	OkHttpClient client = new OkHttpClient();

	public String get(String url) throws IOException {

		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();

	}

}
