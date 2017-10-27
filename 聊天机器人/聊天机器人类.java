package 聊天机器人;

import javax.jws.WebService;

@WebService(endpointInterface = "聊天机器人.聊天接口")
public class 聊天机器人类 implements 聊天接口 {
  private String 小秘密 = "";
  
  @Override
  public String 回答(String 听到的) {
    System.out.println("我听到: " + 听到的);
    if (听到的.contains("?")) {
      return "你猜? 答案长度是" + 小秘密.length();
    } else if (听到的.contains("秘密")) {
      小秘密 = 听到的;
      return "我记住了";
    } else {
      return "...";
    }
  }
}