import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;

import java.util.*;

public class Login {
    int isReturn;
    public final static Map<Integer,Student> studentHasGrade = new HashMap();
    public final static Map<Integer,Student> studentRank = new HashMap();
    public static void main(String[] args) {
        Student student1=new Student("zhang3","123456","张3","333333",false,0,120);
        Student student2=new Student("zhang4","123456","张4","444444",true,2,120);
        Student student3=new Student("zhang5","123456","张5","555555",true,1,120);
        Student student4=new Student("zhang6","123456","张6","666666",true,1,120);
        Student student5=new Student("zhang7","123456","张7","777777",false,0,120);

        Administrator adm1=new Administrator("管理员01","456789");
        Administrator adm2=new Administrator("管理员02","456789");
        Administrator adm3=new Administrator("管理员03","456789");

        Message message1=new Message(1,"asdfasdfasdfasdfasdfasdfasdfasdf");
        Message message2=new Message(2,"qwerqwerqwerqwerqwerqwerqwer");
        Map<Integer,Message> totalMessage=new HashMap<>();
        totalMessage.put(message1.getCount(),message1);
        totalMessage.put(message2.getCount(),message2);

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
//        Iterator iterA=totalAdm.entrySet().iterator();

        int count=2;
        boolean isFinished=false;

        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入运动会管理系统！！");
        //最开始的大循环
        while(true){
            System.out.println("=====================================");
            System.out.print("是否登录为管理员(1为是，0为否):");
            int isAdm=input.nextInt();
            if(isAdm==0){
                System.out.println("=====================================");
                System.out.print("是否注册(1为是，0为否):");

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
                    studentLogon.setIsJoin(false);
                    studentLogon.setIsPassed(1);
                    totalStudent.put(studentLogon.getUserName(),studentLogon);
                    System.out.println("注册成功！！,请重新登录");
                }//注册功能
//                while(true){
                    boolean isIN=false;
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
                        Student studentData=totalStudent.get(username);//浅拷贝
//                        System.out.println(totalStudent.get(username).getIsJoin());
                        while(true){
                            int action;
                            System.out.println("=====================================");
                            System.out.println("0为参加报名");
                            System.out.println("1为查看报名情况");
                            System.out.println("2为查看成绩和排名");
                            System.out.println("3为大赛总排名");
                            System.out.println("4为查看信息");
                            System.out.println("5为返回");
                            System.out.print("选择一个行为:");
                            action=input.nextInt();
                            if(action==0){
                                if(isFinished==true){
                                    System.out.println("=====================================");
                                    System.out.println("报名活动已经结束。");
                                }
                                else{
                                    studentData.setIsJoin(true);
                                    studentData.setIsPassed(1);
//                                System.out.println(totalStudent.get(username).getIsJoin());
                                    System.out.println("=====================================");
                                    System.out.println("报名成功，等待审核！！");
                                }
                            }//参加报名
                            if(action==1){
                                if(studentData.getIsJoin()==false){
                                    System.out.println("=====================================");
                                    System.out.println("未报名");
                                }
                                else{
                                    if(studentData.getIsPassed()==1){
                                        System.out.println("=====================================");
                                        System.out.println("审核中");
                                    }
                                    if(studentData.getIsPassed()==2){
                                        System.out.println("=====================================");
                                        System.out.println("报名成功");
                                    }
                                    if(studentData.getIsPassed()==3){
                                        System.out.println("=====================================");
                                        System.out.println("报名未通过");
                                    }
                                }
                            }//查看报名情况
                            if(action==2){
                                if(studentData.getIsJoin()==false){
                                    System.out.println("=====================================");
                                    System.out.println("未报名，无成绩");
                                }
                                else{
                                    System.out.println("=====================================");
                                    System.out.println("这里还没有写");
                                }
                            }//查看成绩和排名
                            if(action==3){
                                System.out.println("=====================================");
                                System.out.println("查看大赛总成绩（为写）");
                            }//大赛总排名
                            if(action==4){
                                System.out.println("=====================================");
                                Iterator iterM=totalMessage.entrySet().iterator();
                                while(iterM.hasNext()){
                                    Map.Entry entryM=(Map.Entry)iterM.next();
                                    System.out.println("第"+((Message)entryM.getValue()).getCount()+"条信息："+
                                            ((Message)entryM.getValue()).getMessage());
                                }
                            }//查看信息
                            if(action==5)
                                break;
                        }
                    }else {
                        System.out.println("登录失败,用户名或密码错误,请重新输入");
                    }
//                }
            }
            //管理员登录
            else{
                boolean isIN=false;
                System.out.println("=====================================");
                System.out.print("输入管理员用户名：");
                String username=input.next();
                System.out.print("输入管理员密码：");
                String password=input.next();
                Iterator iterA=totalAdm.entrySet().iterator();
                while(iterA.hasNext()){
                    Map.Entry entryA=(Map.Entry)iterA.next();
                    if(((Administrator)entryA.getValue()).getUserName().equals(username)){
                        if(((Administrator)entryA.getValue()).getPassword().equals(password)){
                            isIN=true;
                        }
                    }
                }
                if(isIN==true){
                    System.out.println("=====================================");
                    System.out.println("登录成功！！");
                    while (true){
                        System.out.println("=====================================");
                        System.out.println("1未启停报名活动行为");
                        System.out.println("2为审批参赛申请");
                        System.out.println("3为查看和统计报名情况");
                        System.out.println("4为录入比赛成绩");
                        System.out.println("5为查看运动员成绩和排名");
                        System.out.println("6为查看总排名");
                        System.out.println("7为退出账号");
                        System.out.print("请输入行为:");
                        int action=input.nextInt();
                        if(action==7){
                            System.out.println("已退出");
                            break;
                        }//退出登录
                        if(action==1){
                            System.out.println("=====================================");
                            System.out.print("是否停止报名（1为是，0为否）:");
                            int isFinish=input.nextInt();
                            if(isFinish==1){
                                isFinished=true;
                            }
                            System.out.println("=====================================");
                            System.out.println("操作完成");
                        }//启停活动
                        if(action==2){
                            int countNum=0;
                            Iterator iterS=totalStudent.entrySet().iterator();
                            while(iterS.hasNext()){
                                Map.Entry entryS=(Map.Entry)iterS.next();
                                if(((Student)entryS.getValue()).getIsPassed()==1){
                                    Student studentData=((Student)entryS.getValue());
                                    System.out.print(studentData.getTrueName()+" "+studentData.getUserId()+"是否让其通过(1为是，0为否):");
                                    int isPass=input.nextInt();
                                    if(isPass==1){
                                        countNum++;
                                        studentData.setIsPassed(2);
                                        System.out.println("=====================================");
                                        System.out.println("已使其通过");
                                    }
                                    else{
                                        studentData.setIsPassed(3);
                                        System.out.println("=====================================");
                                        System.out.println("已禁止其参加活动");
                                    }
                                }
                            }
                            if(countNum==0){
                                System.out.println("=====================================");
                                System.out.println("没有要审核的名单");
                            }
                        }//审批
                        if(action==3){
                            int countPassed=0;
                            Iterator iterS=totalStudent.entrySet().iterator();
                            while (iterS.hasNext()){
                                Map.Entry entryS=(Map.Entry)iterS.next();
                                Student studentData=((Student)entryS.getValue());
                                if(studentData.getIsPassed()==2){
                                    System.out.println(studentData.getTrueName()+" "+
                                            studentData.getUserId()+" 已参加");
                                    countPassed++;
                                }
                            }
                            System.out.println("参赛人数为:"+countPassed+"人");
                        }//查看和统计报名情况
                        if(action==4){
                            Iterator iterS=totalStudent.entrySet().iterator();
                            while (iterS.hasNext()){
                                Map.Entry entryS=(Map.Entry)iterS.next();
                                Student studentData=((Student)entryS.getValue());
                                if(studentData.getIsPassed()==2){
                                    System.out.print(studentData.getTrueName()+" "+
                                            studentData.getUserId()+" "+"输入他的成绩(0-100之间)：");
                                    studentData.setGrade(input.nextInt());
                                    studentHasGrade.put(studentData.getGrade(),studentData);//录入有成绩的学生
                                }
                            }
                        }//录入比赛成绩
                        if(action==5){
                            System.out.println("=====================================");
                            Iterator iterRank=studentHasGrade.entrySet().iterator();
                            while (iterRank.hasNext()){
                                Map.Entry entryR=(Map.Entry)iterRank.next();
                                Student studentData=((Student)entryR.getValue());
                                System.out.println(studentData);
                            }

                        }//查看运动员成绩和排名
                    }
                }
                else{
                    System.out.println("=====================================");
                    System.out.println("账号或密码错误，请重新登录!!!");
                }
            }


        }










    }
}
