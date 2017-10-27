package 聊天机器人;

import javax.xml.ws.Endpoint;

public class 聊天服务类 {
  public static void main(String[] arguments) {
    String url = "http://127.0.0.1:5335/service";
    Endpoint.publish(url, new 聊天机器人类());
    System.out.println("服务启动在:" + url);
  }
}