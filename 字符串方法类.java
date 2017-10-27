class 字符串方法类 {
  public static void main (String[] 参数) {
    String 字符串 = "去是go";
    String 搜索字符串 = "go";
    System.out.println("\"" + 字符串 + "\"的长度:" + 字符串.length());
    System.out.println(搜索字符串 + "在\"" + 字符串 + "\"的位置是:" + 字符串.indexOf(搜索字符串));
    System.out.println("\"" + 字符串 + "\"的第一个字符是:" + 字符串.charAt(0));
  }
}