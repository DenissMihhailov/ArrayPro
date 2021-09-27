/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yearsweather;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Deniss
 */
public class YearsWeather {
    public static enum month{
       Январь, Февраль, Март, Апрель, Май, Июнь, Июль, 
       Август, Сентябрь, Октябрь, Ноябрь, Декабрь

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min= -25, max= 25, dayInMonth=0;
        int[][] yearsWeather = new int[12][];
        System.out.print("        ");
        for (int i = 0; i < 31; i++) {
            System.out.printf("%4d",i+1); 
        }
        System.out.println("");
        for (int i = 0; i < 132; i++) {
            System.out.printf("-",i+1);  
        }
        System.out.println("");
        double midTemp=0;
        for (int i = 0; i < yearsWeather.length; i++) {
            switch (i) {
                case 0: min=-25;max=-5; dayInMonth=31;  break;
                case 1: min=-15;max=0; dayInMonth=28;  break;
                case 2: min=-10;max=5; dayInMonth=31;  break;
                case 3: min=-5;max=10; dayInMonth=30;  break;
                case 4: min=0;max=15; dayInMonth=31;  break;
                case 5: min=10;max=25; dayInMonth=30;  break;
                case 6: min=15;max=25; dayInMonth=31;  break;
                case 7: min=10;max=20; dayInMonth=31;  break;
                case 8: min=5;max=15; dayInMonth=30;  break;
                case 9: min=-5;max=10; dayInMonth=31;  break;
                case 10: min=-10;max=5; dayInMonth=30;  break;
                case 11: min=-15;max=0; dayInMonth=31;  break;
            }
            yearsWeather[i]=new int[dayInMonth];
            System.out.printf("%8s",month.values()[i]);
            for (int j = 0; j < yearsWeather[i].length; j++) {
                yearsWeather[i][j]=random.nextInt(max-min+1)+min;
                System.out.printf("%4d",yearsWeather[i][j]); 
                midTemp+=yearsWeather[i][j];    
            }
            midTemp=midTemp/dayInMonth;
            switch (dayInMonth) {
                case 28:
                    System.out.printf("             | Средняя температура: %.2f", midTemp);
                    break;
                case 30:
                    System.out.printf("     | Средняя температура: %.2f", midTemp);
                    break;
                default:
                    System.out.printf(" | Средняя температура: %.2f", midTemp);
                    break;
            }
            System.out.println("");
            
        }
        System.out.print("Напишите месяц в котором хотите узнать погоду:");
        int month= scanner.nextInt();
        System.out.print("Напишите день в котором хотите узнать погоду:");
        int day= scanner.nextInt();
        System.out.printf("В этот день температура была:%2d",yearsWeather[month-1][day-1]);
        int maxInt=0;
        for (int i = 0; i < yearsWeather.length; i++) {
            for (int j = 0; j < yearsWeather[i].length; j++) {
                if(maxInt<yearsWeather[i][j]){
                    maxInt=yearsWeather[i][j];
                }
            }
        }
                System.out.print(maxInt);
    }
    
}
