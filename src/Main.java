import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Составляем список покупок, для того чтобы добавить покупку, нажмите 1");
        System.out.println("Для того чтобы показать весь список покупок, нажмите 2");
        System.out.println("Для того чтобы удалить покупку из списка, нажмите 3");
        System.out.println("Для того чтобы найти покупку в списке, нажмите 4");
        System.out.print("Выберите операцию: \n");
        ArrayList<String> purchses = new ArrayList<>();

        //цикл для выбора действий в программе
        do {
            String scanner = new Scanner(System.in).nextLine();
            if (scanner.equals("end")) {
                break;
            }
            int intCase = Integer.parseInt(scanner);
            if (intCase == 1) {
                System.out.println("Какую покупку хотите добавить?");
                Scanner scanner2 = new Scanner(System.in);
                String s2 = scanner2.nextLine();
                purchses.add(s2);
                System.out.println("Итого в списке покупок: " + purchses.size());
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
                String s3 = new Scanner(System.in).nextLine();
                if (purchses.remove(s3)) {
                    purchses.remove(s3);
                } else {
                    k = Integer.parseInt(s3);
                    purchses.remove(k - 1);
                }
                getPurch(purchses);
            } else if (intCase == 4) {
                System.out.print("Введите слово для поиска по списку:");
                String s3 = new Scanner(System.in).nextLine();

                for (int i = 0; i < purchses.size(); i++) {
                    String queryLower = s3.toLowerCase(Locale.ROOT);
                    String itemLower = purchses.get(i).toLowerCase(Locale.ROOT);

                    if (itemLower.contains(queryLower)) {
                        System.out.println((i + 1) + ". " + purchses.get(i));
                    }
                }
            }
            System.out.print("Выберите операцию: \n");
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
