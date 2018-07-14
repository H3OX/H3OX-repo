import java.util.Scanner;

public class Complex2 {
    int real;
    int img;

    private void Complex2(){
        this.real = 0;
        this.img = 0;
    }
    public Complex2(int real, int img){
        this.real = real;
        this.img = img;
    }
    public int getReal(){
        return real;
    }
    public int getImg(){
        return img;
    }
    public void setReal(int real){
        this.real = real;
    }

    public void setImg(int img) {
        this.img = img;
    }
    public String interp(Complex2 number){
        return number.real + " + " + number.img + "i";
    }
    public Complex2 addC(Complex2 number){
        int x1 = this.real + number.real;
        int y1 = this.img + number.img;
        Complex2 fin = new Complex2(x1, y1);
        return fin;
    }
    public Complex2 subtractC(Complex2 number){
        int x1 = this.real - number.real;
        int y1 = this.img - number.img;
        Complex2 fin = new Complex2(x1, y1);
        return fin;
    }
    public Complex2 multiplyC(Complex2 number){
        int x1 = (this.real * number.real) - (this.img * number.img);
        int y1 = (this.real * number.img) + (number.real * this.img);
        Complex2 fin = new Complex2(x1, y1);
        return fin;
    }
    public Complex2 divideC(Complex2 number){
        int x1 = ((this.real * number.real) + (this.img + number.img))/(number.real*number.real + number.img*number.img);
        int y1 = ((this.real * number.img) - (this.img * number.real))/(number.real*number.real + number.img*number.img);
        Complex2 fin = new Complex2(x1, y1);
        return fin;
    }
    public Complex2 multiplyToReal(Complex2 number, int a){
        int x1 = number.real * a;
        int y1 = number.img * a;
        Complex2 fin = new Complex2(x1, y1);
        return fin;
    }
    public String getConjug(Complex2 number){
        int x1 = number.real;
        int y1 = number.img;
        Complex2 s = new Complex2(x1, y1);
        String fin  = interp(s);
        char[] temp = fin.toCharArray();
        temp[fin.indexOf("+")] = '-';
        return new String(temp);


    }
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Choose operations:");
        System.out.println("1-Complex operations, 2-Multiply to real, 3-Get Conjugated expr.");

        int menu = input.nextInt();

        switch(menu) {
            case 1:
                System.out.println("1-Complex add, 2-Complex subtract, 3-Complex multiply, 4-Complex divide");
                int answer = input.nextInt();

                System.out.println("Complex number input. Enter real and imaginary parts.");
                System.out.println("First number:");
                Complex2 num1 = new Complex2(input.nextInt(), input.nextInt());

                System.out.println("Second number:");
                Complex2 num2 = new Complex2(input.nextInt(), input.nextInt());


                switch (answer) {
                    case 1:
                        System.out.println(num1.interp(num1.addC(num2)));
                        break;
                    case 2:
                        System.out.println(num1.interp(num1.subtractC(num2)));
                        break;
                    case 3:
                        System.out.println(num1.interp(num1.multiplyC(num2)));
                        break;
                    case 4:
                        System.out.println(num1.interp(num1.divideC(num2)));
                        break;
            }
                break;

            case 2:
                System.out.println("Complex number input. Enter real and imaginary parts.");
                Complex2 z1 = new Complex2(input.nextInt(), input.nextInt());
                System.out.println("Enter a real number:");
                int realnum = input.nextInt();
                Complex2 z2 = z1.multiplyToReal(z1, realnum);
                String result = z2.interp(z1);
                System.out.println(result);
                break;

            case 3:
                System.out.println("Enter a complex number:");
                Complex2 d1 = new Complex2(input.nextInt(), input.nextInt());
                System.out.println(d1.getConjug(d1));
        }
    }

}
