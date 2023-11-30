package tools;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class InputFromKeyboard {
    /**
     * Tools for input numbers  from keyboard
     * Repeats input if the entered number is not a number 
     * or a number is out of range 
     * @param min 
     * @param max
     * @return  number;    
     */
    public static int inputNumberFromRange(Integer min, Integer max) {
        
        Scanner scanner = new Scanner(System.in);
        int number = min - 1;
        boolean isNumber = true;
        boolean repeat;
        do{
            try {
                number = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();
                isNumber = false;
            }
            if(max == null ){
               if((number >= min) && isNumber){
                repeat = false; 
               }else{
                    System.out.printf("Enter number from next range: %d .. %d: ",min,max);
                    isNumber = true;
                    repeat = true;
                }
            }else{
                if((number >= min && number <= max) && isNumber){
                    repeat = false;
                }else{
                    System.out.printf("Enter number from next range: %d .. %d: ",min,max);
                    isNumber = true;
                    repeat = true;
                }
            }
        }while(repeat);
        return number;
    }

    public static String inputSymbolYesOrNo() {
        Scanner scanner = new Scanner(System.in);
        do{
            String symbol = scanner.nextLine();
            if(symbol.equals("n") || symbol.equals("y")){
                return symbol;
            }
            System.out.print("For continue press \"y\", exit press \"n\": ");
        }while(true);
    }
    public static int inputNumberFromRange(List<Integer> listId){
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        do{
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                if(!listId.contains(number)){
                    continue;
                }
                return number;
            } catch (Exception e) {
                scanner.nextLine();
            }
        }while(true);
        
    }
    
    
}
