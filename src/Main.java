import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;



public class Main {
    private static ArrayList<String> purchses=new ArrayList<>();

    public static ArrayList<String> getPurch() {
        return purchses;
    }
    public void setPurch(ArrayList<String> purchses) {
        this.purchses = purchses;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //цикл для выбора действий в программе
        do {
            System.out.println("Составляем список покупок, для того чтобы добавить покупку, нажмите 1");
            System.out.println("Для того чтобы показать весь список покупок, нажмите 2");
            System.out.println("Для того чтобы удалить покупку из списка, нажмите 3");
            System.out.println("Для того чтобы найти покупку в списке, нажмите 4");
            System.out.print("Выберите операцию: \n");
           String s=scanner.nextLine();
            if (scanner.equals("end")) {
                break;
            }
            int intCase = Integer.parseInt(s);
            if (intCase == 1) {
                System.out.println("Какую покупку хотите добавить?");
                 s = scanner.nextLine();
               ArrayList b=getPurch();
               b.add(s);

                System.out.println("Итого в списке покупок: " + getPurch().size());
            } else if (intCase == 2) {
                System.out.println("Список покупок:");
                int i = 1;
                Iterator<String> it = purchses.iterator();
                while (it.hasNext()) {
                    String pur = (it.next());
                    System.out.println(i + ". " + pur);
                    i++;
                }
            } else if (intCase == 3) {
                int k = 0;
                getPurch(purchses);
                System.out.print("Какую покупку хотите удалить?");
                 s = new Scanner(System.in).nextLine();
                if (purchses.remove(s)) {
                    purchses.remove(s);
                } else {
                    k = Integer.parseInt(s);
                    purchses.remove(k - 1);
                }
                getPurch(purchses);
            } else if (intCase == 4) {
                System.out.print("Введите слово для поиска по списку:");
                 s = new Scanner(System.in).nextLine();

                for (int i = 0; i < purchses.size(); i++) {
                    String queryLower = s.toLowerCase(Locale.ROOT);
                    String itemLower = purchses.get(i).toLowerCase(Locale.ROOT);

                    if (itemLower.contains(queryLower)) {
                        System.out.println((i + 1) + ". " + purchses.get(i));
                    }
                }
            } else {
                System.out.println("Нужно вводить правильный номер операции!");
                break;}
        } while (true);
    }

    //метод для вывода списка покупок на экран
    public static void getPurch(ArrayList purchses) {
        System.out.println("Список покупок:");
        for (int i = 0; i < purchses.size(); i++) {
            System.out.println((i + 1) + ". " + purchses.get(i));
        }
    }
}
