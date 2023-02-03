package homework01;

import homework01.products.*;

import java.time.LocalDate;

public class Program {

    private static void printProductInfo(Product product) {
        System.out.println(product);
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        Product milk1 = new Milk("Вологодское", 94, 1, "бут", 1000, 3.2, LocalDate.of(2022, 2, 8));
        Product milk2 = new Milk("Безлактозное", 56, 1, "бут", 300, 1, LocalDate.of(2022, 3, 8));
        Product lemonade = new Lemonade("Домашний с соком грейпфрута", 90, 1, "бут", 330);
        Product bread1 = new Bread("Багет", 43, 1, "шт", LocalDate.of(2022, 2, 4), "пшеничный");
        Product bread2 = new Bread("Бородинский", 49, 1, "шт", LocalDate.of(2022, 2, 6), "ржаной");
        Product eggs1 = new Eggs("Яйцо куриное С0", 110, 1, "уп", LocalDate.of(2022, 2, 25), 10);
        Product eggs2 = new Eggs("Яйцо перепелиное", 124, 1, "уп", LocalDate.of(2022, 2, 22), 20);
        Product mask = new Mask("Маска одноразовая", 60, 1, "уп", 5);
        Product paper1 = new ToiletPaper("Zewa", 299, 1, "уп", 8, 3);
        Product paper2 = new ToiletPaper("Veiro", 259, 1, "уп", 12, 2);
        Product diapers1 = new Diaper("Pampers", 1195, 1, "уп", 66, 1, 2, 5, "night");
        Product diapers2 = new Diaper("Huggies", 1119, 1, "уп", 68, 4, 7, 18, "swimming");
        Product pacifier = new Pacifier("Avent", 649, 1, "шт", 1);

        Product[] products = new Product[]{milk1, milk2, lemonade, bread1, bread2, eggs1, eggs2, mask, paper1, paper2, diapers1, diapers2, pacifier};

        System.out.println("Продукты:");
        int index = 0;
        for (Product product : products) {
            System.out.printf("%d. ", ++index);
            printProductInfo(product);
        }
    }
}
