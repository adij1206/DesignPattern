package com.aditya.DesignPattern;

/*
 * Approaches :
 * 1. Making the variable as volatile
 * 2. making the CS of thread as synchronised by block
 * 3. making the common method as synchronised by synchronised method
 * 4. making the part of the method as synchronised using synchronised block
 */
public class Thread {

    // If we will not declare the turn variable as volatile
    // Without it, threads might read a stale (cached) value, which can lead to inconsistent or incorrect behavior.
    //variable value updates are not guaranteed to be visible across different threads.
    // This can lead to one thread not seeing the updated value of turn, causing both threads to stop functioning properly after a certain point.
    //private static  boolean turn = true;

    /**
     * <p>Approach 1</p>
     */
    //private static volatile boolean turn = true;

    //    public static void main(String[] args) {
    //
    //        java.lang.Thread t1 = new java.lang.Thread(() -> {
    //            while (true) {
    //                System.out.println("1");
    //                if (turn) {
    //                    extracted("Hello", false);
    //                }
    //            }
    //
    //        });
    //
    //        java.lang.Thread t2 = new java.lang.Thread(() -> {
    //            while (true) {
    //                System.out.println("2");
    //                if (!turn) {
    //                    extracted("World", true);
    //                }
    //            }
    //        });
    //
    //
    //        t1.start();
    //        t2.start();
    //    }
    //
    //    private static void extracted(String Hello, boolean a) {
    //        print(Hello);
    //        turn = a;
    //        try {
    //            java.lang.Thread.sleep(100);
    //        } catch (InterruptedException e) {
    //            throw new RuntimeException(e);
    //        }
    //    }
    //
    //    private static void print(String name) {
    //        System.out.println(name);
    //    }


    /**
     * <p>Approach 2</p>
     */
    //        private static boolean turn = true;
    //
    //        public static void main(String[] args) {
    //
    //            java.lang.Thread t1 = new java.lang.Thread(() -> {
    //                while (true) {
    //                    System.out.println("1");
    //                    synchronized (Thread.class) {
    //                        if (turn) {
    //                            extracted("Hello", false);
    //                        }
    //                    }
    //                }
    //
    //            });
    //
    //            java.lang.Thread t2 = new java.lang.Thread(() -> {
    //                while (true) {
    //                    System.out.println("2");
    //                    synchronized (Thread.class) {
    //                        if (!turn) {
    //                            extracted("World", true);
    //                        }
    //                    }
    //                }
    //            });
    //
    //
    //            t1.start();
    //            t2.start();
    //        }
    //
    //        private static void extracted(String Hello, boolean a) {
    //            print(Hello);
    //            turn = a;
    //            try {
    //                java.lang.Thread.sleep(100);
    //            } catch (InterruptedException e) {
    //                throw new RuntimeException(e);
    //            }
    //        }
    //
    //        private static void print(String name) {
    //            System.out.println(name);
    //        }

    /**
     * <p>Approach 3</p>
     */
    //    private static boolean turn = true;
    //
    //    public static void main(String[] args) {
    //
    //        java.lang.Thread t1 = new java.lang.Thread(() -> {
    //            while (true) {
    //                System.out.println("1");
    //                if (turn) {
    //                    extracted("Hello", false);
    //                }
    //
    //            }
    //
    //        });
    //
    //        java.lang.Thread t2 = new java.lang.Thread(() -> {
    //            while (true) {
    //                System.out.println("2");
    //
    //                if (!turn) {
    //                    extracted("World", true);
    //                }
    //
    //            }
    //        });
    //
    //
    //        t1.start();
    //        t2.start();
    //    }
    //
    //    private static synchronized void extracted(String Hello, boolean a) {
    //        print(Hello);
    //        turn = a;
    //        try {
    //            java.lang.Thread.sleep(100);
    //        } catch (InterruptedException e) {
    //            throw new RuntimeException(e);
    //        }
    //    }
    //
    //    private static void print(String name) {
    //        System.out.println(name);
    //    }

    private static boolean turn = true;

    public static void main(String[] args) {

        java.lang.Thread t1 = new java.lang.Thread(() -> {
            System.out.println("1" +  java.lang.Thread.currentThread().getName());
//            while (true) {
//                System.out.println("1" +  java.lang.Thread.currentThread().getName());
//                if (turn) {
//                    extracted("Hello", false);
//                }
//
//            }

        });

        java.lang.Thread t2 = new java.lang.Thread(() -> {
            System.out.println("2" + java.lang.Thread.currentThread().getName());
//            while (true) {
//                System.out.println("2" + java.lang.Thread.currentThread().getName());
//
//                if (!turn) {
//                    extracted("World", true);
//                }
//
//            }
        });

        System.out.println("3" + java.lang.Thread.currentThread().getName());
        t1.start();
        t2.run();
    }

    private static void extracted(String Hello, boolean a) {
        synchronized (Thread.class) {
            print(Hello);
            turn = a;
        }

        try {
            java.lang.Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void print(String name) {
        System.out.println(name);
    }
}
