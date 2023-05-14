package com.aditya.DesignPattern.pattern.structure;

/*
 * This Pattern is Used to control the access so that some specific set of users can access
 *  the object
 */

interface DatabaseExecutor {
    void executeQuery(String query) throws Exception;
}

class DatabaseExecutorImpl implements DatabaseExecutor {

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing the query" + query);
    }
}

class DatabaseExecutorProxy implements DatabaseExecutor {

    private boolean ifAdmin;
    private DatabaseExecutorImpl databaseExecutor;

    public DatabaseExecutorProxy(String userName, String password) {
        if (userName == "ADMIN" && password == "Admin123") {
            this.ifAdmin = true;
        }

        this.databaseExecutor = new DatabaseExecutorImpl();
    }

    @Override
    public void executeQuery(String query) throws Exception {
        if (ifAdmin) {
            databaseExecutor.executeQuery(query);
        } else {
            if (query.contains("DELETE")) {
                throw new Exception("DataAccess Error");
            } else {
                databaseExecutor.executeQuery(query);
            }
        }
    }
}

public class ProxyDesignPattern {
    public static void main(String[] args) throws Exception {
        DatabaseExecutor databaseExecutor = new DatabaseExecutorProxy("ADMIN", "Admin123");
        databaseExecutor.executeQuery("DELETE");

        DatabaseExecutor databaseExecutor1 = new DatabaseExecutorProxy("NONADMIN", "Admin123");
        databaseExecutor1.executeQuery("DELETE");

        DatabaseExecutor databaseExecutor2 = new DatabaseExecutorProxy("NONADMIN", "Admin123");
        databaseExecutor2.executeQuery("SELECT");
    }

}
