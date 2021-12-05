package hackerRankExercises;

import java.io.*;
import java.util.*;

public class JavaExceptionHandling {

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {

            int x = s.nextInt();
            int y = s.nextInt();

            System.out.println(x / y);
        } catch (InputMismatchException e) {
            System.out.println(e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}