class 识字循环类 {
  public static void main (String[] 参数) {
    int 识字量 = 1;
    int 每年翻倍数 = 2;
    int 年限 = 10;
    int 年份 = 0;

    while (年份 < 年限) {
      if (识字量 > 3000) {
        break;
      }
      识字量 = (1 + 每年翻倍数) * 识字量;
      年份 = 年份 + 1;
    }
    System.out.println(年份 + "年后认识" + 识字量 + "个字");
  }
}
