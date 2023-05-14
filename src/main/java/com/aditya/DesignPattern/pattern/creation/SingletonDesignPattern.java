package com.aditya.DesignPattern.pattern.creation;

// This Class will create the instance once the application will run.
class SingletonEager {
    private static SingletonEager instance = new SingletonEager();
    private SingletonEager() {

    }

    public static SingletonEager getInstance() {
        return instance;
    }
}

// This Class will create the instance only when the method has been called first time.
class SingletonLazy {

    private static SingletonLazy instance = new SingletonLazy();
    private SingletonLazy() {

    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }

        return instance;
    }
}

// As the above class will create multiple instances for multiple thread , we have kept the thread initialization synchronized.
class SingletonSynchronizedMethod {

    private static SingletonSynchronizedMethod instance = new SingletonSynchronizedMethod();
    private SingletonSynchronizedMethod() {

    }

    public static synchronized SingletonSynchronizedMethod getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronizedMethod();
        }

        return instance;
    }
}

// We have done the thread initialization synchronized from method level to block level
class SingletonSynchronizedBlock {

    private static SingletonSynchronizedBlock instance = new SingletonSynchronizedBlock();
    private SingletonSynchronizedBlock() {

    }

    public static SingletonSynchronizedBlock getInstance() {
        if (instance == null) {
            synchronized (SingletonSynchronizedBlock.class) {
                if (instance == null) {
                    instance = new SingletonSynchronizedBlock();
                }
            }
        }

        return instance;
    }
}

public class SingletonDesignPattern {

    public static void main(String[] args) {
        SingletonEager singletonEager = SingletonEager.getInstance();
        System.out.println(singletonEager);

        SingletonEager singletonEager1 = SingletonEager.getInstance();
        System.out.println(singletonEager1);

        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        System.out.println(singletonLazy);

        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        System.out.println(singletonLazy1);

        SingletonSynchronizedMethod singletonSynchronizedMethod = SingletonSynchronizedMethod.getInstance();
        System.out.println(singletonSynchronizedMethod);

        SingletonSynchronizedMethod singletonSynchronizedMethod1 = SingletonSynchronizedMethod.getInstance();
        System.out.println(singletonSynchronizedMethod1);

        SingletonSynchronizedBlock singletonSynchronizedBlock = SingletonSynchronizedBlock.getInstance();
        System.out.println(singletonSynchronizedBlock);

        SingletonSynchronizedBlock singletonSynchronizedBlock1 = SingletonSynchronizedBlock.getInstance();
        System.out.println(singletonSynchronizedBlock1);
    }
}
