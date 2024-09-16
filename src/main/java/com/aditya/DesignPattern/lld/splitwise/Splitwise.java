package com.aditya.DesignPattern.lld.splitwise;

import com.aditya.DesignPattern.lld.splitwise.expense.split.Split;
import com.aditya.DesignPattern.lld.splitwise.expense.SplitType;
import com.aditya.DesignPattern.lld.splitwise.group.Group;
import com.aditya.DesignPattern.lld.splitwise.group.GroupController;
import com.aditya.DesignPattern.lld.splitwise.user.User;
import com.aditya.DesignPattern.lld.splitwise.user.UserBalanceSheetController;
import com.aditya.DesignPattern.lld.splitwise.user.UserController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Splitwise {

    private UserController userController;
    private GroupController groupController;
    private UserBalanceSheetController userBalanceSheetController;

    public Splitwise() {
        this.userController = new UserController();
        this.groupController = new GroupController();
        this.userBalanceSheetController = new UserBalanceSheetController();
    }

    public void demo() {
        addUserAndGroup();

        // Get Group
        Group group = groupController.getGroup("123");

        // Create Expense
        Split split1 = new Split(new BigDecimal(1000), userController.getUser("001"));
        Split split2 = new Split(new BigDecimal(1000), userController.getUser("002"));
        Split split3 = new Split(new BigDecimal(1000), userController.getUser("003"));

        List<Split> splits = new ArrayList<>();
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);

        group.createExpense("1", new BigDecimal(3000), splits, userController.getUser("001"), SplitType.EQUAL);


        // Create Expense
        Split split4 = new Split(new BigDecimal(1000), userController.getUser("001"));
        Split split5 = new Split(new BigDecimal(2000), userController.getUser("002"));
        Split split6 = new Split(new BigDecimal(4000), userController.getUser("003"));
        Split split7 = new Split(new BigDecimal(3000), userController.getUser("004"));

        List<Split> splits1 = new ArrayList<>();
        splits1.add(split4);
        splits1.add(split5);
        splits1.add(split6);
        splits1.add(split7);

        group.createExpense("1", new BigDecimal(10000), splits1, userController.getUser("003"), SplitType.PERCENTAGE);

        for (User user : userController.getUsers()) {
            userBalanceSheetController.showBalanceSheet(user);
        }
    }

    private void addUserAndGroup() {
        List<User> userList = addUsers();
        userController.addAllUsers(userList);

        Group group = groupController.createGroup("123", "Boys", userController.getUser("001"));
        group.addMembers(userController.getUser("002"));
        group.addMembers(userController.getUser("003"));
        group.addMembers(userController.getUser("004"));
    }

    private List<User> addUsers() {
        User user1 = new User("001", "Aditya");
        User user2 = new User("002", "Abhigyan");
        User user3 = new User("003", "Satyam");
        User user4 = new User("004", "Saurav");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return userList;
    }


}
