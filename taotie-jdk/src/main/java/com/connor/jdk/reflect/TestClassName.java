package com.connor.jdk.reflect;

public class TestClassName {


    /**
     * int.class (primitive):
     *     getName():          int
     *     getCanonicalName(): int
     *     getSimpleName():    int
     *     getTypeName():      int
     *
     * String.class (ordinary class):
     *     getName():          java.lang.String
     *     getCanonicalName(): java.lang.String
     *     getSimpleName():    String
     *     getTypeName():      java.lang.String
     *
     * java.util.HashMap.SimpleEntry.class (nested class):
     *     getName():          java.util.AbstractMap$SimpleEntry
     *     getCanonicalName(): java.util.AbstractMap.SimpleEntry
     *     getSimpleName():    SimpleEntry
     *     getTypeName():      java.util.AbstractMap$SimpleEntry
     *
     * new java.io.Serializable(){}.getClass() (anonymous inner class):
     *     getName():          com.connor.jdk.reflect.TestClassName$1
     *     getCanonicalName(): null
     *     getSimpleName():
     *     getTypeName():      com.connor.jdk.reflect.TestClassName$1
     */
    public static void main(final String... arguments) {
        printNamesForClass(
                int.class,
                "int.class (primitive)");
        printNamesForClass(
                String.class,
                "String.class (ordinary class)");
        printNamesForClass(
                java.util.HashMap.SimpleEntry.class,
                "java.util.HashMap.SimpleEntry.class (nested class)");
        printNamesForClass(
                new java.io.Serializable() {
                }.getClass(),
                "new java.io.Serializable(){}.getClass() (anonymous inner class)");
    }

    private static void printNamesForClass(final Class<?> clazz, final String label) {
        System.out.println(label + ":");
        System.out.println("    getName():          " + clazz.getName());
        System.out.println("    getCanonicalName(): " + clazz.getCanonicalName());
        System.out.println("    getSimpleName():    " + clazz.getSimpleName());
        System.out.println("    getTypeName():      " + clazz.getTypeName()); // added in Java 8
        System.out.println();
    }
}

