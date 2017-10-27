import java.util.Random;



class 随机数生成器类 {
  public static void main (String[] 参数) {
    Random 生成器 = new Random();
    System.out.println("我想到的数字是:" + 生成器.nextInt());
  }
}