package box;

public class Main {
    public static void main(String[] args) {
//        int countOfBeanPackage = 0;
//        int countOfPastaPackage = 0;
//        final double MAX_VOLUME = 200d;
//        final int MAX_PRICE = 5000;
//        double volume = 0;
//        int price = 0;
//        BeanPackage beanPackage = new BeanPackage();
//        PastaPackage pastaPackage = new PastaPackage();
//        for (int i = 0; i * beanPackage.price < MAX_PRICE && i * beanPackage.volume < MAX_VOLUME; i++) {
//            price += beanPackage.price;
//            volume += beanPackage.volume;
//            System.out.printf("%d) price - %2.2d; volume - %s%n", i, price, volume);
//        }
        System.out.println(new SomeClass().matchRegex("Home...", "[a-zA-Z]+.+"));

    }
}
