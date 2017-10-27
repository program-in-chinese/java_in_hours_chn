package 聊天机器人;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
 
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface 聊天接口 {
  @WebMethod String 回答(String 听到的);
}