import New.Fish;

import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

enum Color {
    RED(1),
    GREEN(2),
    BLUE(3);

    final int type;

    Color(int type) {
        this.type = type;
    }
}

public class Main {

    /*public static int temp(int a,int b){
        return a == 0 ? b : temp(b%a,a);
    }
    char a = 'a' ;
    String  b = "哈哈";
    float c = 54.321f;
    boolean d = true;
    static class Hero{
        String name;
        float hp;
        float armor;
        int move_speed;
        void keng(){
            System.out.println("坑队友");
        }
    }*/


    public static void main(String[] args) {
        /*for(int i = 1;i <= 5;i++){
            for (int j = 1;j <= i;j++){
                System.out.print('*');
            }
            System.out.print('\n');
        }
        int[] p = new int[]{18,62,68,82,65,9};
        Arrays.sort(p);
        System.out.println(Arrays.binarySearch(p,68));
        String str1 = "the light";
        String str2 = str1;
        String str3 = new String(str1);
        String str4 = "the light";
        String str5 = "the " + "light";
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println(str1 == str5);
        System.out.println(str1.equals(str4));
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            System.out.println(line);
        }
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while (sc.hasNext()){
            String line = sc.next();
            pw.println(line);
            pw.flush();
            //System.out.println(line);
        }
        Scanner  sc=new Scanner(System.in);

        int m=sc.nextInt();
        int []a=new int [m];

        for(int i=0;i<m;i++)
        {
            a[i]=sc.nextInt();
        }

        Arrays.sort(a);
        PrintWriter pw = new PrintWriter(System.out);
        String result = Arrays.toString(a);
        pw.println(result);
        pw.flush();*/

        /*Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss:SS");
        System.out.println(dateFormat.format(System.currentTimeMillis()));*/
        /*String time1 ="2020-1-1 00:00:00";
        String time2 ="2020-1-1 00:00:05";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
        try {
            Date date1 = simpleDateFormat.parse(time1);
            Date date2 = simpleDateFormat.parse(time2);
            long difference = date2.getTime() - date1.getTime();
            System.out.println(difference);
        }catch (Exception e){

        }*/
        /*Date date = new Date(System.currentTimeMillis());
        System.out.println(date.getTime());*/
        /*stopWatch p = new stopWatch();
        System.out.println(p.getElapsedTime());*/
        /*Fish[] fishes = new Fish[10];
        for (int i = 0;i < 10;i++){
            fishes[i] = new Fish();
        }

        Arrays.sort(fishes);

        for (int i = 0;i < 10;i++){
            fishes[i].print();
        }*/


        ArrayList<Color> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Collections.addAll(list, Color.values());
        }
        Random r = new Random(1234567);
        Collections.shuffle(list, r);
        for (Color c : list) {
            switch (c) {
                case RED -> System.out.print(Color.RED.type);
                case GREEN -> System.out.print(Color.GREEN.type);
                case BLUE -> System.out.print(Color.BLUE.type);
                default -> {
                }
            }
        }
    }
}