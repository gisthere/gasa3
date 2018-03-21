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

        // basis path

        // 16-21,23,26,29,33,34,40,49,53,54,55,56,63-65,68,69,75,76,85,86,95,96-97
        // 16-21,23,26,29,33,34,40,49,53,54,55,56,63-65,68,69,75,76,85,86,95,96-97


        // 16-21,23,26,29,33,34,40,49,53,54,55,56,63-65,68,69,75,76,85,86,95,96-97
        String res = new ShapeClassifier().evaluateGuess("Rectangle,Large,Yes,50,50,60,60");

        // 16-21,23,26,29,33,34,35,39,63-65,68,71,75,76,85,86,95,101,102,106,
        // guess that there is no shape ''
        res = new ShapeClassifier().evaluateGuess(",Large,Yes,200");

        // 16-21,23,26,29,33,34,40,41,42,43,48,63-65,68,69,75,76,85,86,95,96-97
        res = new ShapeClassifier().evaluateGuess("Ellipse,Large,Yes,100,200");

        // 16-21,23,26,29,33,34,40,49,50-52,63-65,68,69,75,76,85,86,95,96,97,
        res = new ShapeClassifier().evaluateGuess("Equilateral,Large,Yes,100,100,100");

        // 16-21,23,26,29,33,34,40,49,53,63-65,68,71,75,78,82,85,86,95,101,102,106,
        res = new ShapeClassifier().evaluateGuess("Equilateral,Large,Yes,100,100,100,100,100");

        // 16-21,23,26,29,33,34,40,49,53,54,55,59,63-65,68,69,75,76,85,86,95,96-97
        res = new ShapeClassifier().evaluateGuess("Square,Large,Yes,100,100,100,100");


        // 16-21,23,26,29,33,34,35,36-37,39,63-65,68,69,75,76,85,86,95,96,97,
        res = new ShapeClassifier().evaluateGuess("Line,Large,Yes,300");

        // 16-21,23,26,29,33,34,40,41,42,46,48,63-65,68,69,75,76,85,86,95,96,97,
        res = new ShapeClassifier().evaluateGuess("Circle,Large,Yes,212,212");

        // 16-21,23,26,29,33,34,40,49,53,54,55,56,63-65,68,69,75,78,79,85,86,95,96-97
        res = new ShapeClassifier().evaluateGuess("Rectangle,Small,Yes,1,1,2,2");

        // 16-21,23,26,29,33,34,40,49,50-52,63-65,68,69,75,76,85,88,89,95,96,97,
        res = new ShapeClassifier().evaluateGuess("Equilateral,Large,No,333,333,333");

        // 16-21,23,26,29,33,34,40,49,50-52,63-65,68,69,75,76,85,88,92,95,101,102,106,
        res = new ShapeClassifier().evaluateGuess("Equilateral,Large,Yes,333,333,333");

        // 16-21,23,26,29,33,34,40,49,50-52,63-65,68,69,75,76,85,88,92,95,101,102,103-104
        ShapeClassifier sC = new ShapeClassifier();
        sC.evaluateGuess("Equilateral,Large,Yes,333,333,333");
        sC.evaluateGuess("Equilateral,Large,Yes,333,333,333");
        sC.evaluateGuess("Equilateral,Large,Yes,333,333,333");




        System.out.println(new ShapeClassifier().calculateEllipsePerimeter(1,2));
        System.out.println(new ShapeClassifier().calculateCirclePerimeter(4));
        System.out.println(res);
    }


//        List<Integer> testedValues = new LinkedList<Integer>();
//        testedValues.add(1);
//        testedValues.add(4095);
//        for (int i = 1; i <= 51; i++) {
//            testedValues.add(i);
//        }
//
//        HashMap<String, String> hashMap = new HashMap<String, String>();
//
//        for (String f : figs) {
//            for (String s : sizes) {
//                for (String oe : even) {
//                    StringBuilder b = new StringBuilder();
//                    b.append(f).append(',').append(s).append(',').append(oe);
//                    System.out.println(b.toString());
//
//                    for (int i = 1; i <= 4; i++) {
//                        if (i == 1) {
//
//                            for (Integer v1: testedValues) {
//                                String str = b.toString() + ',' + String.valueOf(v1);
//                                String res = new ShapeClassifier().evaluateGuess(str);
//                                hashMap.put(res, str);
//                            }
//
//                        } else if (i == 2) {
//                            for (Integer v1: testedValues) {
//                                for (Integer v2: testedValues) {
//                                    String str = b.toString() + ',' + String.valueOf(v1) + ',' + String.valueOf(v2);
//                                    String res = new ShapeClassifier().evaluateGuess(str);
//                                    hashMap.put(res, str);
//                                }
//                            }
//
//                        } else if (i == 3) {
//                            for (Integer v1: testedValues) {
//                                for (Integer v2: testedValues) {
//                                    for (Integer v3: testedValues) {
//                                        String str = b.toString() + ',' + String.valueOf(v1) + ',' + String.valueOf(v2) + ',' + String.valueOf(v3);
//                                        String res = new ShapeClassifier().evaluateGuess(str);
//                                        hashMap.put(res, str);
//                                    }
//                                }
//                            }}
////                        } else if (i == 4) {
////                            for (Integer v1: testedValues) {
////                                for (Integer v2: testedValues) {
////                                    for (Integer v3: testedValues) {
////                                        for (Integer v4: testedValues) {
////                                            String str = b.toString() + ',' + String.valueOf(v1) + ',' + String.valueOf(v2) + ',' + String.valueOf(v3) + ',' + String.valueOf(v4);
////                                            String res = new ShapeClassifier().evaluateGuess(str);
////                                            hashMap.put(res, str);
////                                        }
////                                    }
////                                }
////                            }
////                        }
////                        StringBuilder b = new StringBuilder();
////                        b.append(f).append(',').append(s).append(',').append(oe);
////                        for (int j = 1; j <= i; j++) {
////                            for (int k = 1; k <= 201; k++) {
////                                System.out.print(k);
////                                System.out.print(",");
////                            }
//////                            b.append(',').append(1);
////                        }
////                        System.out.println();
////                        String str = b.toString();
////                        String res = new ShapeClassifier().evaluateGuess(b.toString());
////                        hashMap.put(res, str);
//                    }
//                }
//            }
//
//        }
//
//        List<String> visitedNodesList = new ArrayList<String>(hashMap.keySet());
//        for (String visitedNodes : visitedNodesList) {
//            System.out.println(hashMap.get(visitedNodes));
//            System.out.println(visitedNodes);
//            System.out.println();
//        }
//
//        List<String> list = new ArrayList<String>(hashMap.keySet());
//
//        Set<String> setOfPaths = new HashSet<String>();
//        for (int i = 0; i < list.size(); i++) {
//            String[] listOfNodes = list.get(i).split(",");
//
//            StringBuilder pathBuilder = new StringBuilder();
//            for (int j = 0; j < listOfNodes.length - 1; j++) {
//                pathBuilder.append(listOfNodes[j]).append("#").append(listOfNodes[j + 1]).append(",");
//            }
//            setOfPaths.add(pathBuilder.toString());
//        }
//
//        Set<String> visited = new HashSet<String>();
//        List<String> listOfPaths = new ArrayList<String>(setOfPaths);
//        List<String> choosed = new LinkedList<String>();
//        for (int i = 0; i < listOfPaths.size(); i++) {
//            HashSet<String> pathSet = new HashSet<String>(Arrays.asList(listOfPaths.get(i).split(",")));
//            pathSet.removeAll(visited);
//            if (pathSet.size() > 0) {
//                visited.addAll(pathSet);
//                choosed.add(listOfPaths.get(i));
//            }
//        }
//
//        for (String path : choosed) {
////            System.out.println(hashMap.get(path));
//            System.out.println(path);
//            System.out.println();
//        }
//
////        Set<String> visited = new HashSet<String>();
////        List<String> list = new ArrayList<String>(hashMap.keySet());
////        List<String> choosed = new LinkedList<String>();
////        for (int i = 0; i < list.size(); i++) {
////            HashSet<String> nodeSet = new HashSet<String>(Arrays.asList(list.get(i).split(",")));
////            nodeSet.removeAll(visited);
////            if (nodeSet.size() > 0) {
////                visited.addAll(nodeSet);
////                choosed.add(list.get(i));
////            }
////        }
////
////        for (String path: choosed ) {
////            System.out.println(hashMap.get(path));
////            System.out.println(path);
////            System.out.println();
////        }
//
//
////        Set<String> bPaths = new HashSet();
////        for (int i = 0; i < list.size(); i++) {
////            for (int k = i + 1; k < list.size(); k++) {
////                HashSet<String> s1 = new HashSet<String>(Arrays.asList(list.get(i).split(",")));
////                HashSet<String> s2 = new HashSet<String>(Arrays.asList(list.get(k).split(",")));
////                Set<String> intersection = new HashSet<String>(s1);
////                intersection.retainAll(s2);
////                if (s2.size() - intersection.size() == 1) {
////                    bPaths.add(list.get(i));
////                    bPaths.add(list.get(k));
////                    System.out.println(hashMap.get(list.get(i)));
////                    System.out.println(list.get(i));
////                    System.out.println(hashMap.get(list.get(k)));
////                    System.out.println(list.get(k));
////                    System.out.println();
////                }
////            }
////        }
////
////        for (String bp: bPaths ) {
////            System.out.println(hashMap.get(bp));
////            System.out.println(bp);
////            System.out.println();
////        }
//
//
////        System.out.println(hashMap.size());
////
////        }
//    }
}