import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение");
        String input = new Scanner(System.in).nextLine();
        String action;
        //Проверка на правильно введеный знак через метод.
        if(checSing(input)==null){
            throw new Exception(" Строка не является математической операцией");
        }
        else {
            action = checSing(input);
        }
        //Делим на массив строк по введеному знаку.И удаляем пробелы.
        String[] textArray = input.replace(" ","").split("[+\\-*/]");
        String operand1 = textArray[0];
        String operand2 = textArray[1];
        //System.out.println(Arrays.toString(textArray));

        //Проверка что первый аргумент не число.
        if (operand2.contains("\"") && operand1.matches("^(10|[0-9])$")) {
            throw new Exception("Первым аргументом должна быть строка");
        }
         //Проверка на то что оба выражения в кавычках.Иначе выходит ошибка.
         else if (operand2.contains("\"") && operand1.contains("\"")) {
         }
         //Проверка на то что первая идет строка , а второе значение - число.
         else if (operand1.contains("\"") && operand2.matches("^(10|[0-9])$")) {

        }
        //Проверка что числа в диапазоне 0т 1 до 10 включительно.
         else if ((Integer.parseInt(textArray[1]) >11 || Integer.parseInt(textArray[1]) <0  )) {
             throw new Exception("Число   должно быть от 1 до 10");
         }
         else {
             throw new Exception("Вы ввели недопустимые символы");
         }
         //Убираем кавычки.
        for (int i = 0; i < textArray.length; i++) {
            textArray[i] = textArray[i].replace("\"","");
        }
       
        if (textArray[0].length() > 10 || textArray[1].length() > 10){
            throw new Exception("Символов должно быть не более 10  каждой строчке");
        }

        switch (action){
            case "+":
                String rezult1 = textArray[0] + textArray[1];
                System.out.println("\""+rezult1+"\"");
                break;
            case "-":
                System.out.println(Arrays.toString(textArray));
                int index = textArray[0].indexOf(textArray[1]);
                if(index == -1){
                    String[] text = input.replace("\"","").split(" ");
                    System.out.println(text[0]);
                }
                else {
                    String rezult2 =  textArray[0].substring(0,index);
                    System.out.println("\""+rezult2+"\"");
                }
                break;
            case "*":
                int number = Integer.parseInt(textArray[1]);
                String rezult3 = textArray[0].repeat(number);
                if (rezult3.length() > 40){
                    String rezult3_1 = rezult3.substring(0,40);
                    System.out.println("\""+rezult3_1+"..."+"\"");
                }
                else {
                    System.out.println("\""+rezult3+"\"");
                }
                break;
            case "/":
                int del = textArray[0].length()/Integer.parseInt(textArray[1]);
                String rezult4 = textArray[0].substring(0,del);
                System.out.println("\""+rezult4+"\"");
                break;

        }

    }



    public static String checSing(String text){
        if(text.contains("+")) return "+";
        else if (text.contains("-")) return "-";
        else if (text.contains("*")) return "*";
        else if (text.contains("/")) return "/";
        else return null;
    }

}