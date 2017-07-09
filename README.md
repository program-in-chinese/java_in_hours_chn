# Java编程一天入门

## 一 准备编程 (建议时间: 20分钟. 如果卡住,请在代码库开issue, 下同)
编程就是让计算机做你想让它做的事.

编程语言是工具,就像锤子,应该拿上手就可以用.

为了编写第一个Java程序,必需一个Java开发套件(JDK),以及一个写程序的文本编辑工具.
本文的代码足够简单,集成开发环境的用处不大,任何文本编辑器都可以(推荐工具待定.写本文时用的是Komodo Editor免费版).

安装Oracle JDK后, 打开命令行窗口,运行javac和java,不报错"command not found",即为成功,可以继续. (待续:常见问题与解决)

扩展资料: 解释器与编译器的区别, JDK(Oracle JDK, OpenJDK), IDE(Eclipse, NetBeans, IntelliJ等等)

## 二 问个好吧 (建议时间: 20分钟)

新建文本文件,命名为"问好.java".输入最简单的一个Java程序:

```
class 问好 {
  public static void main (String[] 参数) {
    // 待续: 要让它做的事
  }
}
```

这个程序定义了一个类(class),名叫"问好",文件名一般与类名相同. 这个类就是一个程序. 里面的main是程序入口. 注意所有的大括号都需要配对. 双斜杠"//"之后的是注释,是为读代码的人方便理解写的,不影响编译运行.
"参数"很扎眼吧,不用急,第四讲就知道它做什么了.

这个程序可以编译运行(见"手把手"部分),但运行后没有任何输出.因为这个程序是个空架子,没有任何可以看到的运行结果.下面就让它做点事.

```
class 问好 {
  public static void main (String[] 参数) {
    // 要让它做的事
    System.out.println("吃了么");
  }
}
```

加上的这行代码将打印一行字,内容是"吃了么".

试试编译运行,将看到命令行下输出:
```
吃了么
```

试试改字符串的内容,再编译运行.恭喜! 你已经可以写出无数个不同的Java程序了.
再试试加一行相同的代码,输出结果变了吗? 恭喜! 你已经可以写出无限长的Java程序了.

### 手把手:
在命令行下编译和运行
#### 编译:
在程序文件的目录下,运行下面的命令
```
$ javac 问好.java
```
此命令将程序文件编译生成.class文件,在这个目录下多了一个"问好.class"文件

注: 在Windows下, 如果报错"unmappable character for encoding GBK", 请加编码参数:
```
$ javac -encoding utf8 问好.java
```
#### 运行
下面的命令寻找并运行叫"问好"的类:
```
$ java 问好
```

## 三 Java的现状 (建议时间: 10分钟)
在更进一步之前,最好了解现在Java都用来做什么.

优点:
- Oracle JDK是开源的, 另有一个社区维护的版本OpenJDK也是.
- 程序员用户群很大, 能碰到的问题基本上都被前人趟过雷了.
- 可以用的成熟的经过时间检验的库很多.

用途:
- 很大一部分网络服务
- 大多数安卓手机应用
- 少量游戏和桌面应用
- 一些企业内部用Java Applet做可以嵌入网页的在线工具. 注: Chrome浏览器已不支持Java Applet,原因之一是安全性

扩展资料: Apache Maven, Java Applet

## 四 用Java算术 (建议时间: 40分钟)

新建文件"四则运算.java"
```
class 四则运算 {
  public static void main (String[] 参数) {
    System.out.println(1+2);
  }
}
```
编译运行后,果然输出3. 再试试其他四则运算吧,加减乘除运算符分别是+-*/.
还有括号也可以用. 注: 如果算式中所有的数都是整数,那么每步运算都会取整
恭喜! 你已经可以用Java程序完成数学运算了.

那么其他的运算呢?
新建文件"根号.java"
```
class 根号 {
  public static void main (String[] 参数) {
    System.out.println(Math.sqrt(4));
  }
}
```
看起来告诉程序的值是4,编译运行后, 果然如愿打印出了2.0. Math.sqrt是Java中开根号的方法.
应该不用啰嗦了,试试把4改成其他的数,看看结果如何?
现在,你可能已经觉得程序的"回答"太"精简"和生硬了,那么人性化一些吧,下面开始只列出main方法内的代码
```
    System.out.println("4的平方根是" + Math.sqrt(4));
```
输出听起来顺耳些了,但如果想要把4改成其他数,需要改程序的两个地方,这种麻烦可要不得! 可以把4先存到一个变量里,然后在两处引用同一个变量:
```
    int 数 = 4;
    System.out.println(数 + "的平方根是" + Math.sqrt(数));
```
这样只要改一处了.不过,为了改输入值,还是要改程序,再编译再运行,这种麻烦可要不得! "参数"终于派上用场了.
```
    int 数 = Integer.parseInt(参数[0]);
    System.out.println(数 + "的平方根是" + Math.sqrt(数));
```
"参数[0]"是"参数"数组的第一个值. Integer.parseInt是Java把字符串转换成整数的方法.
现在代码里没有了输入值,该怎样告诉程序需要给什么数开根号呢?
在运行程序时,命令后加上一个"参数":
```
$ java 根号 4
```
如果忘了在运行时加参数, 这个程序会打印一个异常报告: java.lang.ArrayIndexOutOfBoundsException
意思是:数组是空的,却要取第一个值,没辙.

试试多加几个参数吧, 参数[1]是"参数"数组第二个值,以此类推.
恭喜! 你的程序不用修改代码就可以接受不同的外部输入了.

Math是Java自带标准库中的数学类,包含很多有用的方法.详细请查阅JDK文档. 标准库还有很多有用的类.
比如随机数很有用,聊天机器人少不了它.
新建"随机数生成器.java":
```
class 随机数生成器 {
  public static void main (String[] 参数) {
    java.util.Random 生成器 = new java.util.Random();
    System.out.println("来一个随机数:" + 生成器.nextInt());
  }
}
```
java.util.Random是随机数类的全路径, java.util是它所在的包. 没有全路径Java就找不到这个类了.
为什么Math和Integer没有这样的前缀呢? 因为他们在java.lang包里,是"亲生"的,不用包名Java也能找到这些类.

"生成器"是随机数类的一个"个体". 用new关键词来产生. 一个现实的比方: "人"是一个类型, 你我都是同样类型的不同个体.
nextInt是产生一个随机数的方法. 为什么Math.sqrt和Integer.parseInt不用new出一个个体呢? 留个悬念吧.

这样重复类的全名看着真累, 下面用import来开头导入这个类路径, 之后就不用再重复了:
```
import java.util.Random;

class 随机数生成器 {
  public static void main (String[] 参数) {
    Random 生成器 = new Random();
    System.out.println("来一个随机数:" + 生成器.nextInt());
  }
}
```

扩展资料: 数组, 异常, 方法, JDK文档

## 五 变量-在程序中保存修改信息 (建议时间: 15分钟)

在上一讲的"根号"类中,用了一个整形(int)变量来保存输入值. "参数"是一个字符串(String)数组.
Java中还有其他几种基本变量: boolean, char, byte, short, long, float, double
```
boolean 布尔量 = true; // true或false,真或假
char 字符 = '好'; // 单个字符
byte 字节 = 27; // -128到127, 即-2^7到(2^7-1)
short 短整数 = 12345; // -32768到32767, 即-2^15到(2^15-1)
int 整数 = 1234567890; // -2^31到(2^31-1)
long 长整数 = 123456789000000000l; // -2^63到(2^63-1)
float 单精度浮点数 = 1.1f; // 2^-126到(2-2^-23)*2^127
double 双精度浮点数 = 1.1; // 2^-1074到(2-2^-52)*2^1023
```
它们的范围逐渐增大,可以根据需要选择. 长整数后如果不加'l',会被默认为int值.

上一讲的四则运算类中,已经尝试了4种运算符. 变量运算的结果可以赋给自己,或者另一个变量.

举个例子,某投资方法,可以有8%的年回报率,那么1000元的初始投入资金,3年之后会变成多少.下面是一个很直白的计算方法:
```
class 投资回报 {
  public static void main (String[] 参数) {
    float 账户余额 = 1000f;
    float 回报率 = 0.08f;

    // 第一年
    账户余额 = (1 + 回报率) * 账户余额;

    // 第二年
    账户余额 = (1 + 回报率) * 账户余额;

    // 第三年
    账户余额 = (1 + 回报率) * 账户余额;
    System.out.println("三年后变成" + 账户余额 + "元");
  }
}
```
你的感觉没错, 它看起来就很累赘, 而且如果要算20年后呢? 恭喜! 你已经有了判断代码优劣的直觉. 至于改进方法,留个悬念吧.

## 六 文字 (建议时间: 30分钟)

之前的程序都用文字的形式"回答"结果. 就像现实世界一样, 文字是最经典基本的人机交流方式. 为此Java提供了很多文本处理的方法.

第一讲中的"吃了么"是一个字符串(String). 它由三个字符(char)组成: '吃','了','么'.
注意在定义变量时字符用单引号,而字符串用双引号. 就像上一讲的浮点数后的f和长整数后的l一样, 这些都是Java的"传统". 考虑到Java诞生在上世纪90年代初,就配合一下吧.

可能已经注意到String开头是大写的,没错,和其他基本变量类型不同,它是一个类.关于类和个体(俗称"对象"),后面会再讲到. 暂时不需深究.

第一讲中也许已经试过了多个System.out.println,每个会打出一行. 如果不想另起一行, 用System.out.print就行.

既然用双引号包起来的就是字符串,那么如果想在字符串里显示双引号,该怎么办呢? 这需要加一个反斜杠: \\"

那么反斜杠又是个特殊符号了, 如果要显示它, 就需要再加一个: \\\\
类似的还有\t(制表符), \n(换行)等等. 如果将来有一个想不出怎么显示的东西, 再找本工具书看看Java特殊字符部分吧. 下面的程序演示一些:
```
class 特殊字符 {
  public static void main (String[] 参数) {
    System.out.println("边检员看了看证件,头没抬地说\t\"这么久没回了啊?\".\n百感交集,不知为何咧着嘴回了一句\t\"是啊,抗战还没完呢\"");
  }
}
```
前几讲已经用过加号连接多个字符串,以及其他类型的变量. 只要是基本变量,都可以这样和字符串用加号连接,产生一个新的字符串.

字符串有不少常用方法,比如获取长度,搜索子字符串,变换英文大小写等等.下面演示他们的用法:
```
class 字符串方法 {
  public static void main (String[] 参数) {
    String 字符串 = "去是go";
    String 搜索字符串 = "go";
    System.out.println("\"" + 字符串 + "\"的长度:" + 字符串.length());
    System.out.println(搜索字符串 + "在\"" + 字符串 + "\"的位置是:" + 字符串.indexOf(搜索字符串));
    System.out.println("\"" + 字符串 + "\"转换为大写是:" + 字符串.toUpperCase());
  }
}
```
扩展资料: 类型转换

## 七 如果...就...不然... (建议时间: 30分钟)
代码说了算:
```
if (年龄 < 20) {
  System.out.println("没到法定婚龄! 等几年再结婚吧");
} else {
  System.out.println("妹妹,真想嫁也拦不住你.要不再考虑一天?");
}
```
if就是"如果",后面跟的是条件, 紧接着的{}在条件满足时执行; else就是"不然",紧接着的{}在之前的条件不满足时执行.
没错, {}里当然可以有多行代码. 然后在if里套if试试?

Java支持所有数学中的大小比较符号: < > >= <=

另外, 因为单个=被用于变量赋值, 判断"等于"就用了双等号: == 不等于呢? !=

如果有并列的多个条件,可以串起来这样写:
```
if (年龄 < 5) {
  System.out.println("这是哪家闺女啊?爸妈在哪儿呢?");
} else if (年龄 < 20) {
  System.out.println("没到法定婚龄! 等几年再结婚吧");
} else {
  System.out.println("妹妹,真想嫁也拦不住你.要不再考虑一天?");
}
```
如果把 <5 和 <20的顺序倒过来:
```
if (年龄 < 20) {
  System.out.println("没到法定婚龄! 等几年再结婚吧");
} else if (年龄 < 5) {
  System.out.println("这是哪家闺女啊?爸妈在哪儿呢?");
} else {
  System.out.println("妹妹,真想嫁也拦不住你.要不再考虑一天?");
}
```
即使是3岁的小朋友也满足<20的条件, 因此会执行输出"没到法定婚龄! 等几年再结婚吧".
是的,计算机执行程序就是这么老(si)实(ban), 执行第一个被满足的条件之后的{}内代码, 而且无视后面所有else的条件判断.

注意,字符串的"等于"判断有自己的方法equals,比大小用compareTo:
```
if ("辛苦".equals("不辛苦")) {
  System.out.println("辛不辛苦无所谓");
} else if ("辛苦".compareTo("不辛苦") > 0){
  System.out.println("辛苦点好");
} else {
  System.out.println("不辛苦好");
}
```

扩展资料: &&, ||, switch, ?:, 字符串比较

## 八 直到...一直... (建议时间: 30分钟)
记得算投资回报的程序么? 如果要算20年, 难道必须重复20行"账户余额 = (1 + 回报率) * 账户余额;"吗? 用脚趾想也不可能吧.

在写代码之前, 不妨先构思一下该怎么算. 多了一个输入值是年限,比如20. 照原来的思路应该是: 每过一年增一次值, 直到过了20年. 这样就需要记着过了多少年. 对计算机来说, 一个变量用来"记"变化的值最合适:
```
for (int 年份 = 0; 年份 < 年限; 年份 = 年份 + 1) {
  账户余额 = (1 + 回报率) * 账户余额;
}
```

同样的循环用while的格式来写是这样:
```
int 年份 = 0;
while (年份 < 年限) {
  年份 = 年份 + 1;
  账户余额 = (1 + 回报率) * 账户余额;
}
```
看起来for循环更紧凑, 也更不容易写错. while循环里,如果忘写了"年份 = 年份 + 1;",可就有趣了,因为年份没有增加, 循环中止条件一直不能满足(0永远小于年限), 代码运行停不下来,俗称"死循环". 而for循环里因为定了"(初始化; 循环条件; 执行语句)"的格式, 少了一项会很扎眼.

如果想要提前结束循环,可以用break. 比方说,想知道啥时候能赚到2000:
```
int 年份 = 0;
while (年份 < 年限) {
  if (账户余额 > 2000) {
    break;
  }
  年份 = 年份 + 1;
  账户余额 = (1 + 回报率) * 账户余额;
}
System.out.println(年份 + "年后变成" + 账户余额 + "元");
```
break执行后,它所在的循环就被打断,程序从循环之后开始执行.

如果想要循环继续执行,但是跳过循环内的部分代码,可以用continue. 一个牵强的例子,如果从第三年才开始有回报:
```
for (int 年份 = 0; 年份 < 年限; 年份 = 年份 + 1) {
  if (年份 < 3) {
    continue;
  }
  账户余额 = (1 + 回报率) * 账户余额;
}
```
注: 有更简短的实现方法, 这个例子只为了演示continue的用处.
恭喜! 至此控制流介绍完了.

扩展资料: 变量初始值, 作用域, ++, --, do...while

## 九 造个人 (建议时间: 30分钟)

我们都是人类,每个人都是一个个体,大多数人有共有的属性和行为,同时也存在个体之间的差异.
下面就来在程序里定义一个"人"类:
```
public class 人 {
}
```
这样的"人"还什么都做不了. 我们出生后都有姓名,那么它也应该有:
```
public class 人 {
  String 姓名 = "无名氏";
  
  public void 自我介绍() {
    System.out.println("我叫" + 姓名);
  }
}
```
这个类具有了"姓名"属性, "自我介绍"方法引用了这个属性并输出加工后的回答.
class前的public表示"人"可以在其他类里使用. 比如这个"世界"类里, "我"是"人"类的一个个体:
```
class 世界 {
  public static void main(String[] 参数) {
    人 我 = new 人();
    我.自我介绍();
  }
}
```
不过,应该有个像样的名字,而不是默认的"无名氏". 需要在自我介绍之前,先定名字:
```
    我.姓名 = "小白";
```
编译运行"世界"后,可以看到输出.

这个世界好像太单调了,人有不同分类,大人,小孩等等,他们做不同的事.新建"大人"类:
```
public class 大人 extends 人 {
  String 责任 = "扶老携幼";
  
  public void 生活() {
    System.out.println("我必须" + 责任);
  }
}
```
再新建"小孩"类:
```
public class 小孩 extends 人 {
  String 想做的事 = "大人的事";
  
  public void 长大() {
    System.out.println("我要做" + 想做的事);
  }
}
```
现在的世界要喧闹一些了:
```
class 世界 {
  public static void main(String[] 参数) {
    大人 大白 = new 大人();
    小孩 小白 = new 小孩();
    
    大白.姓名 = "大白";
    大白.自我介绍();
    大白.生活();
    
    小白.姓名 = "小白";
    小白.自我介绍();
    小白.长大();
  }
}
```
"大人"和"小孩"都是"人"的扩展类(俗称"子类"), 他们也可以有自己的"子类",比如"婴儿"可以是"小孩"的子类.

扩展资料: 接口(interface)

## 十 让它更像人 (建议时间: 30分钟)

一个人还有很多属性:
```
public class 人 {
  String 姓名 = "无名氏";
  int 年龄 = 0;
  float 身高 = 0.0f;
  private String 小秘密 = "";
  
  public void 自我介绍() {
    System.out.println("我叫" + 姓名 + ", 今年" + 年龄 + "岁");
  }
}
```
谁的小秘密都不可以直接让别人知道. private就限制了这个变量只能给个体内部使用, 任何其他类里,都不能直接获取这个值. 下面这个程序在编译会报错:
```
class 世界 {
  public static void main(String[] 参数) {
    人 我 = new 人();
    System.out.println(我.小秘密);
  }
}
```
既然这个小秘密只能由自己引用和修改, 一般有公开方法可以让其他类间接接触这个变量:
```
public String 回答(String 听到的) {
  if (听到的.contains("?")) {
    return "你猜? 答案长度是" + 小秘密.length();
  } else if (听到的.contains("秘密")) {
    小秘密 = 听到的;
    return "我记住了";
  } else {
    return "...";
  }
}
```
根据"听到的"内容, 如果里面包含问号, 就提示秘密的字符串长度, 让猜秘密. 如果包含"秘密"两个字,就把它存在"小秘密"变量里. 再不然,就...了.

这个方法返回(return)一个字符串. 可以在"世界"类里打印出每个回答.

扩展资料: private/protected/public, static, final

## 走上社会

## 数据排排坐-数组

## 更多结构

## 出错是难免的

## 为人民服务
编译运行服务器:
```
$ javac chatbot/聊天服务.java
$ java chatbot/聊天服务
```
运行客户端:
```
$ javac chatbot/聊天客户端.java
$ java chatbot/聊天客户端 秘密哦
我记住了
$ java chatbot/聊天客户端 你是谁?
你猜? 答案长度是3
```

扩展资料: JAX-WS, SOAP, REST

待定:

## 分身有术-多线程

## 文字到图形

## 读写文件

## 内部类, closure, lambda
