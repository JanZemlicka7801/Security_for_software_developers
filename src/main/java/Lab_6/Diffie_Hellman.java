package Lab_6;

import java.util.InputMismatchException;
import java.util.*;
import java.io.*;

public class Diffie_Hellman {
    public static void part_6(Scanner scanner){
        try {
            System.out.println("Please enter generator :");
            long generator = scanner.nextLong();
            System.out.println("Please enter modulus :");
            long modulus = scanner.nextLong();
            System.out.println("Please enter private value a :");
            long privateValueA = scanner.nextLong();
            System.out.println("Please enter private value b :");
            long privateValueB = scanner.nextLong();
            diffieHellman(generator, modulus, privateValueA, privateValueB);
        } catch (InputMismatchException e){
            System.out.println("ERROR!!!! Please enter number.");
        }
    }

    public static void diffieHellman(long g, long p, long a, long b){
        long A = modulus(g, a, p);
        long B = modulus(g, b, p);
        System.out.println("Public values :");
        System.out.println("Value for A : " + A);
        System.out.println("Value for B : " + B);

        long fSecret = modulus(B, a, p);
        long sSecret = modulus(A, b, p);

        if(sSecret == fSecret) {
            System.out.println("Shared secret keys are :\n" +
                    "sA : " + fSecret + "\n" +
                    "sB : " + sSecret);
        } else {
            System.out.println("Something went wrong please try it again.");
        }
    }

    public static long modulus(long base, long power, long mod){
        long big = (long) Math.pow(base, power);
        long quotient = (big/mod);

        long small = quotient * mod;
        long remainder = big - small;

        return remainder;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        part_6(sc);
    }
}
