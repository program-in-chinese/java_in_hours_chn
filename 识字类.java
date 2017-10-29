class 识字类 {
  public static void main (String[] 参数) {
    int 识字量 = 1;
    int 每年翻倍数 = 2;

    // 第一年
    识字量 = (1 + 每年翻倍数) * 识字量;

    // 第二年
    识字量 = (1 + 每年翻倍数) * 识字量;

    // 第三年
    识字量 = (1 + 每年翻倍数) * 识字量;
    System.out.println("三年后认识" + 识字量 + "个字咯");
  }
}