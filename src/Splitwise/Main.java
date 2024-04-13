package Splitwise;

import Splitwise.Model.ExpenseType;
import Splitwise.Model.Type;
import Splitwise.Model.User;
import Splitwise.Services.ExpenseService;
import Splitwise.Services.UserService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User user1=new User(1,"lak","lak@gmail.com",123123);
        User user2=new User(2,"ut","ut@gmail.com",123123);
        User user3=new User(3,"rk","rk@gmail.com",123123);
        User user4=new User(4,"den","den@gmail.com",123123);

        List<User> users = new ArrayList<>(Arrays.asList(user1,user2,user3,user4));

        UserService userService=new UserService(users);
        ExpenseService expenseService=new ExpenseService(users);

        while (true){
            Scanner scn=new Scanner(System.in);
            Type type=Type.valueOf(scn.next());

            switch (type){
                case  EXPENSE :
                    String userName=scn.next();
                    int amountSpent=scn.nextInt();
                    double totalMembers=scn.nextDouble();
                    List<User> owedUser=new ArrayList<>();
                    for(int i=0;i<totalMembers;i++){
                        owedUser.add(userService.getUser(scn.next()).get());
                    }
                    ExpenseType expenseType=ExpenseType.valueOf(scn.next());
                    switch (expenseType){
                        case EQUAL :
                            expenseService.splitEqualExpenses(userName,amountSpent,owedUser);
                            break;
                        case EXACT:
                            HashMap<User,Double> owedAmountSwap=new HashMap<>();
                            double sum=0;
                            for(int i=0;i<totalMembers;i++){
                                double amount=scn.nextDouble();
                                sum+=amount;
                                owedAmountSwap.put(owedUser.get(i),amount);

                            }
                            if(sum!=amountSpent){
                                System.out.println("Sum not matches to actual split amount");
                                break;
                            }
                            expenseService.splitExactExpenses(userName,amountSpent,owedUser,owedAmountSwap);
                            break;
                        case PERCENT:
                            HashMap<User,Integer> owedPercentageMap=new HashMap<>();
                            int perc=0;
                            for(int i=0;i<totalMembers;i++){
                                int amount=scn.nextInt();
                                perc+=amount;
                                owedPercentageMap.put(owedUser.get(i),amount);

                            }
                            if(perc!=100){
                                System.out.println("Percent do n ot add up to 100");
                                break;
                            }
                            expenseService.splitPercentageExpenses(userName,amountSpent,owedUser,owedPercentageMap);
                    }
                    break;
                case SHOW:
                    String name=scn.next();
                    expenseService.showExpenses(name);
                    break;
                case QUIT:
                    System.out.println("Quitting");
                    return ;
                default:
                    System.out.println("No expected argument found");
                    break;
            }
        }
    }
}
