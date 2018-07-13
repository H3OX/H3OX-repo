import java.util.*;

public class Complex {

    public void Complex() {
    }

    public String convertToCompl(int a, int b) { //Представление двух чисел в виде строки a + bi
        Double.toString(a);
        Double.toString(b);
        return (a + "+" + b + "i");
    }

    public int getRl(String a) { //Получение действительной части из строки вида a + bi
        int plusPosition = a.indexOf("+");
        return Integer.parseInt(a.substring(0, plusPosition));
    }

    public int getIm(String a) { //Получение мнимой части из строки вида a + bi
        int plusPosition = a.indexOf("+");
        int iPosition = a.indexOf("i");
        return Integer.parseInt(a.substring(plusPosition, iPosition));
    }


    public String addCompls(String a, String b) { //Сумма двух комплексных чисел
        int real1 = getRl(a);
        int img1 = getIm(a);
        int real2 = getRl(b);
        int img2 = getIm(b);
        String realsum = Integer.toString(real1 + real2);
        String imgsum = Integer.toString(img1 + img2);
        return "Your expression: " +  realsum + " + " + imgsum + "i";
    }

    public String multiplyCompls(String a, String b) { //Произведение двух комплексных чисел
        int real1 = getRl(a);
        int img1 = getIm(a);
        int real2 = getRl(b);
        int img2 = getIm(b);
        String subtr = Integer.toString(real1 * real2 - img1 * img2);
        String realimg = Integer.toString(real1 * img2 + real2 * img1);
        return "Your expression: " +  subtr + " + " + realimg + "i";

    }

    public String multiplyComplToReal(int a, String b) { //Произведение действительного числа с комплексным
        int real1 = getRl(b);
        int img1 = getIm(b);
        return "Your expression: " +  Integer.toString(a * real1) + " + " + Integer.toString(a * img1) + "i";
    }

    public String subtractCompls(String a, String b) { //Вычитание двух комплексных чисел
        int real1 = getRl(a);
        int img1 = getIm(a);
        int real2 = getRl(b);
        int img2 = getIm(b);
        String realsubtr = Integer.toString(real1 - real2);
        String imgsubtr = Integer.toString(img1 - img2);
        return "Your expression: " + realsubtr + " + " + imgsubtr + "i";

    }

    public String divideCompls(String a, String b) { //Деление двух комплксных чисел
        int real1 = getRl(a);
        int img1 = getIm(a);
        int real2 = getRl(b);
        int img2 = getIm(b);
        int firstAction = ((real1 * real2) + (img1 * img2)) / (real2 * real2 + img2 * img2);
        int secondAction = ((real2 * img1) - (real1 * img2)) / (real2 * real2 + img2 * img2);
        return "Your expression: " +  Integer.toString(firstAction) + " + " + Integer.toString(secondAction) + "i";
    }

    public static String ConjugatedExpr(String a) { //Получение сопряженного выражения
        int plusPosition = a.indexOf('+');
        char[] temp = a.toCharArray();
        temp[plusPosition] = '-';
        a = new String(temp);
        return "Your expression: " +  a;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Ввод

        System.out.println("1 for Complex-Complex operations, 2 for Complex-Real, 3 to find conjugated number");
        int answer = input.nextInt();
        Complex r = new Complex();
        switch (answer) {
            case 1:
                System.out.println("1 for addition, 2 for subtraction, 3 for multiplication, 4 for division");

                int answer2 = input.nextInt();
                System.out.println("*First number*");
                System.out.println("Enter real: ");
                int x1 = input.nextInt();
                System.out.println("Enter imaginary: ");
                int y1 = input.nextInt();


                System.out.println("*Second number*");
                System.out.println("Enter real: ");
                int x2 = input.nextInt();
                System.out.println("Enter imaginary: ");
                int y2 = input.nextInt();
                String first = r.convertToCompl(x1, y1);
                String second = r.convertToCompl(x2, y2);


                switch (answer2) {
                    case 1:
                        System.out.println(r.addCompls(first, second));
                        break;
                    case 2:
                        System.out.println(r.subtractCompls(first, second));
                        break;
                    case 3:
                        System.out.println(r.multiplyCompls(first, second));
                        break;
                    case 4:
                        System.out.println(r.divideCompls(first, second));
                        break;
                }
                break;

            case 2:
                System.out.println("Enter a real number: ");
                int rNumber = input.nextInt();
                System.out.println("*Complex number input*");
                System.out.println("Enter real and imaginary parts: ");
                String cNumber = r.convertToCompl(input.nextInt(), input.nextInt());
                System.out.println(r.multiplyComplToReal(rNumber, cNumber));
                break;
            case 3:
                System.out.println("Enter an expression to find conjugated one: ");
                String expr = input.next();
                System.out.println(ConjugatedExpr(expr));
                break;
        }
    }
}

