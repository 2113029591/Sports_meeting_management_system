import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public class Login {
    int isReturn;
    public static void main(String[] args) {
        Student student1=new Student("zhang3","123456","张3","333333",true,1,120);
        Student student2=new Student("zhang4","123456","张4","444444",true,1,120);
        Student student3=new Student("zhang5","123456","张5","555555",false,1,120);
        Student student4=new Student("zhang6","123456","张6","666666",false,1,120);
        Student student5=new Student("zhang7","123456","张7","777777",false,1,120);

        Administrator adm1=new Administrator("管理员01","456789");
        Administrator adm2=new Administrator("管理员02","456789");
        Administrator adm3=new Administrator("管理员03","456789");

        Map<String,Student> totalStudent=new HashMap<>();
        totalStudent.put(student1.getUserName(),student1);
        totalStudent.put(student2.getUserName(),student2);
        totalStudent.put(student3.getUserName(),student3);
        totalStudent.put(student4.getUserName(),student4);
        totalStudent.put(student5.getUserName(),student5);

        Map<String,Administrator> totalAdm=new HashMap<>();
        totalAdm.put(adm1.getUserName(),adm1);
        totalAdm.put(adm2.getUserName(),adm2);
        totalAdm.put(adm3.getUserName(),adm3);
        Iterator iterA=totalAdm.entrySet().iterator();

        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入运动会管理系统！！");
        //最开始的大循环
        while(true){
            boolean isIN=false;
            System.out.print("是否为管理员(1为是，0为否):");
            int isAdm=input.nextInt();
            if(isAdm==0){
                System.out.println("=====================================");
                System.out.print("是否注册(1为是，0为否):");
                //注册功能
                if(input.nextInt()==1){
                    System.out.print("输入注册的用户名：");
                    Student studentLogon=new Student();
                    studentLogon.setUserName(input.next());
                    System.out.print("输入注册的密码：");
                    studentLogon.setPassword(input.next());
                    System.out.print("输入真实姓名和学号（以一个空格隔开）:");
                    studentLogon.setTrueName(input.next());
                    studentLogon.setUserId(input.next());
                    studentLogon.setGrade(120);
                    studentLogon.setJoin(false);
                    studentLogon.setIsPassed(1);
                    totalStudent.put(studentLogon.getUserName(),studentLogon);
                    System.out.println("注册成功！！,请重新登录");
                }
                while(true){
                    System.out.println("=====================================");
                    System.out.print("用户名：");
                    String username=input.next();
                    System.out.print("密码：");
                    String password=input.next();
                    Iterator iterS=totalStudent.entrySet().iterator();
                    while(iterS.hasNext()){
                        Map.Entry entryS=(Map.Entry)iterS.next();
                        if(((Student)entryS.getValue()).getUserName().equals(username)){
                            if(((Student)entryS.getValue()).getPassword().equals(password)){
                                isIN=true;
                            }
                        }
                    }
                    //登录成功的情况
                    if(isIN==true){
                        System.out.println("登录成功！！");
                        while(true){
                            int action;
                            System.out.println("=====================================");
                            System.out.println("1为参加报名");
                            System.out.println("2为查看成绩和排名");
                            System.out.println("3为大赛总排名");
                            System.out.println("4为查看信息");
                            System.out.println("5为返回");
                            System.out.print("选择一个行为");

                        }
                    }else {
                        System.out.println("登录失败,用户名或密码错误,请重新输入");
                    }
                }
        }


        }










    }
}
