import java.util.*;

/**
 * Created by Fanis Kalimullin on 19.03.18.
 */
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] figs = {"Circle", "Ellipse", "Line", "Rectangle", "Square", "Equilateral", "Isosceles", "Scalene"};
        String[] sizes = {"Large", "Small"};
        String[] even = {"Yes", "No"};

        Random rand = new Random();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        int counter = 0;
        while (hashMap.size() <= 50) {
            for (String f : figs) {
                for (String s : sizes) {
                    for (String oe : even) {
                        StringBuilder b = new StringBuilder();
                        b.append(f).append(',').append(s).append(',').append(oe);
                        for (int i = 1; i <= rand.nextInt(4) + 1; i++) {
                            b.append(',').append(rand.nextInt(4095) + 1);
                        }
//                    System.out.println(b.toString());
                        String str = b.toString();
                        String res = new ShapeClassifier().evaluateGuess(b.toString());
                        hashMap.put(res, str);
//                        System.out.println(res);
//                        System.out.println(counter++);
//                        System.out.println(hashMap.size());
                    }
                }

            }
        }

        List<String> list = new ArrayList<String>(hashMap.keySet());
        Set<String> bPaths = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            for (int k = i + 1; k < list.size(); k++) {
                HashSet<String> s1 = new HashSet<String>(Arrays.asList(list.get(i).split(",")));
                HashSet<String> s2 = new HashSet<String>(Arrays.asList(list.get(k).split(",")));
                Set<String> intersection = new HashSet<String>(s1);
                intersection.retainAll(s2);
                if (s2.size() - intersection.size() == 1) {
                    bPaths.add(list.get(i));
                    bPaths.add(list.get(k));
                    System.out.println(hashMap.get(list.get(i)));
                    System.out.println(list.get(i));
                    System.out.println(hashMap.get(list.get(k)));
                    System.out.println(list.get(k));
                    System.out.println();
                }
            }
        }

//        for (String bp: bPaths ) {
//            System.out.println(hashMap.get(bp));
//            System.out.println(bp);
//            System.out.println();
//        }



//        System.out.println(hashMap.size());
//
    }
}
