package com.blbuyer.erp.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.blbuyer.core.logging.Logger;
import com.blbuyer.core.logging.LoggerUtils;

public class HttpClientUtil {
	private static final Logger LOGGER = LoggerUtils.getLogger(HttpClientUtil.class);

	public static String doPostFrom(String url, Map<String, Object> paramMap) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = "";
        // 创建httpClient实例
        httpClient = HttpClients.createDefault();
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        // 封装post请求参数
        if (null != paramMap && paramMap.size() > 0) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            // 循环遍历，获取迭代器
            for(Map.Entry<String, Object> mapEntry : paramMap.entrySet()){
            	nvps.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue().toString()));
            }
            // 为httpPost设置封装好的请求参数
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpPost);
            // 从响应对象中获取响应内容
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(), e);
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return result;
    }
	
	public static String doPostByJson(String url, String jsonStr) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = "";
        // 创建httpClient实例
        httpClient = HttpClients.createDefault();
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
        // 构建消息实体
        StringEntity stringEntity = new StringEntity(jsonStr, Charset.forName("UTF-8"));
        stringEntity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpPost);
            // 从响应对象中获取响应内容
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(), e);
        }  finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return result;
    }
	
	
	//get
	public static int getStatusPostByJson(String url, String jsonStr,Map<String, String> headerMap) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        int result = 0;
        // 创建httpClient实例
        httpClient = HttpClients.createDefault();
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
        
        // 设置请求头     
        if (null != headerMap && headerMap.size() > 0) {
            // 循环遍历，获取迭代器
            for(Map.Entry<String, String> mapEntry : headerMap.entrySet()){
            	httpPost.addHeader(mapEntry.getKey(), mapEntry.getValue());
            }
           
        }
        
        // 构建消息实体
        StringEntity stringEntity = new StringEntity(jsonStr, Charset.forName("UTF-8"));
        stringEntity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpPost);
            
            LOGGER.info("***httpstatus:{}", httpResponse.getStatusLine().getStatusCode());
            // 从响应对象中获取响应内容
            //HttpEntity entity = httpResponse.getEntity();
            result = httpResponse.getStatusLine().getStatusCode();
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(), e);
        }  finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return result;
    }
	
	
	public static String doPostByXml(String url, String xml) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = "";
        // 创建httpClient实例
        httpClient = HttpClients.createDefault();
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/xml; charset=utf-8");
        // 构建消息实体
        StringEntity stringEntity = new StringEntity(xml, Charset.forName("UTF-8"));
        stringEntity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        stringEntity.setContentType("application/xml");
        httpPost.setEntity(stringEntity);
        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpPost);
            // 从响应对象中获取响应内容
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return result;
    }
	
	
	public static String httpGet(String url, Map<String, String> headerMap) {
		CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = "";
        // 创建httpClient实例
        httpClient = HttpClients.createDefault();
        // 创建httpPost远程连接实例
        HttpGet httpGet = new HttpGet(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpGet.setConfig(requestConfig);
        // 设置请求头     
        if (null != headerMap && headerMap.size() > 0) {
            // 循环遍历，获取迭代器
            for(Map.Entry<String, String> mapEntry : headerMap.entrySet()){
            	httpGet.addHeader(mapEntry.getKey(), mapEntry.getValue());
            }
           
        }

        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpGet);
            // 从响应对象中获取响应内容
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(), e);
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return result;
	}
	
	public static String httpGetHeader(String url, Map<String, String> headerMap, String responseHeaderName) {
		CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = "";
        // 创建httpClient实例
        httpClient = HttpClients.createDefault();
        // 创建httpPost远程连接实例
        HttpGet httpGet = new HttpGet(url);
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .build();
        // 为httpPost实例设置配置
        httpGet.setConfig(requestConfig);
        // 设置请求头     
        if (null != headerMap && headerMap.size() > 0) {
            // 循环遍历，获取迭代器
            for(Map.Entry<String, String> mapEntry : headerMap.entrySet()){
            	httpGet.addHeader(mapEntry.getKey(), mapEntry.getValue());
            }
           
        }

        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpGet);
            // 从响应对象中获取响应内容
            result = httpResponse.getFirstHeader(responseHeaderName).getValue();
        } catch (Exception e) {
        	LOGGER.error(e.getMessage(), e);
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                	LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return result;
	}
	
}
