

public class ShapeClassifier {
    private int badGuesses;
    private String[] threeParamGuesses = {"Equilateral", "Isosceles", "Scalene"};
    private String[] fourParamGuesses = {"Rectangle", "Square"};
    private String[] twoParamGuesses = {"Circle", "Ellipse", "Line"};

    public ShapeClassifier() {
        badGuesses = 0;
    }

    // return Yes if the guess is correct, No otherwise
    public String evaluateGuess(String arg) {

        StringBuilder b = new StringBuilder();b.append("16-21,"); String shapeGuessResult = "";
        Integer[] parameters = getParams(arg);
        String shapeGuess = getShapeGuess(arg);
        String sizeGuess = getSizeGuess(arg);
        String evenOddGuess = getEvenOddGuess(arg);
        int calcPerim = 0;

        b.append("23,"); if (shapeGuess == null)
            shapeGuess = "";

        b.append("26,"); if (sizeGuess == null)
            sizeGuess = "";

        b.append("29,"); if (evenOddGuess == null)
            evenOddGuess = "";


        switch (parameters.length) {
            case 1:
                b.append("34,35,"); if (shapeGuess.equals("Line")) {
                    shapeGuessResult = shapeGuess; b.append("36-37,");
                    calcPerim = parameters[0];
                }
                break;
            case 2:
                shapeGuessResult = classify2Parameters(parameters[1], parameters[1]); b.append("41,42,");
                if (shapeGuessResult.equals("Ellipse")) {
                    calcPerim = calculateEllipsePerimeter(parameters[0], parameters[1]); b.append("43,");
                }
                else {
                    calcPerim = calculateCirclePerimeter(parameters[0]); b.append("46,");
                }
                b.append("48,");break;
            case 3:
                shapeGuessResult = classify3Parameters(parameters[0], parameters[1], parameters[2]);b.append("49,50-52,");
                calcPerim = calculateTrianglePerimeter(parameters[1], parameters[1], parameters[2]);
                break;
            case 4:
                shapeGuessResult = classify4Parameters(parameters[0], parameters[1], parameters[2], parameters[3]); b.append("53,54,55,");
                if (shapeGuessResult.equals("Rectangle")) {
                    calcPerim = calculateRectanglePerimeter(parameters[0], parameters[3], parameters[2], parameters[3]);b.append("56,");
                }
                else {
                    calcPerim = calculateRectanglePerimeter(parameters[0], parameters[1], parameters[2], parameters[3]);b.append("59,");
                }
        }

        Boolean isShapeGuessCorrect = null;
        Boolean isSizeGuessCorrect = null;
        Boolean isEvenOddCorrect = null;b.append("63-65,68,");

        // check the shape guess
        if (shapeGuessResult.equals(shapeGuess)) {
            isShapeGuessCorrect = true;b.append("69,");}
        else  {
            isShapeGuessCorrect = false;b.append("71,");}

        // check the size guess

        b.append("75,");if (calcPerim > 200 && sizeGuess.equals("Large")) {
            isSizeGuessCorrect = true;b.append("76,");
        }
        else {b.append("78,");if (calcPerim < 10 && sizeGuess.equals("Small")) {
            isSizeGuessCorrect = true;b.append("79,");
        }
        else {
            isSizeGuessCorrect = false;b.append("82,");
        }}

        b.append("85,"); if (0 == (calcPerim % 2) && evenOddGuess.equals("Yes")) {
            isEvenOddCorrect = true; b.append("86,");
        }
        else {b.append("88,"); if (0 != (calcPerim % 2) && evenOddGuess.equals("No")) {
            isEvenOddCorrect = true; b.append("89,");
        }
        else {
            isEvenOddCorrect = false;b.append("92,");
        }}

        b.append("95,");if (isShapeGuessCorrect && isSizeGuessCorrect && isEvenOddCorrect) {
            badGuesses = 0;b.append("96,97,");
            return b.append("").toString();
        }
        else {
            // too many bad guesses
            badGuesses++;b.append("101,102,");
            if (badGuesses >= 3) {
                System.out.println("Bad guess limit Exceeded");
                System.exit(1);
            }
            return b.append("106,").toString();
        }
    }

    // P = 2 * PI *r
    private int calculateCirclePerimeter(int r) {
        return (int) (2 * Math.PI * r);
    }

    // P = 4 * s
    private int calculateSquarePerimeter(int side) {
        return 4 * side;
    }

    // P = 2l + 2w)
    private int calculateRectanglePerimeter(int side1, int side2, int side3, int side4) {
        if (side1 == side2) {

            return (2 * side1) + (2 * side3);
        } else if (side2 == side3) {
            return (2 * side1) + (2 * side2);
        }

        return 0;
    }

    // P = a + b + c
    private int calculateTrianglePerimeter(int side1, int side2, int side3) {
        return side1 + side2 + side3;
    }

    // This is an approximation
    // PI(3(a+b) - sqrt((3a+b)(a+3b))
    private int calculateEllipsePerimeter(int a, int b) {
        double da = a, db = b;
        return (int) ((int) Math.PI * (3 * (da + db) - Math.sqrt((3 * da + db) * (da + 3 * db))));
    }

    // Transform a string argument into an array of numbers
    private Integer[] getParams(String args) {
        String[] params = args.split(",");
        Integer[] numParams = null;
        numParams = new Integer[params.length - 3];
        for (int i = 3; i < params.length; i++) {
            numParams[i - 3] = Integer.parseInt(params[i]);
        }
        return numParams;
    }

    // extract the Even/Odd guess
    private String getEvenOddGuess(String args) {
        String[] params = args.split(",");
        return params[2];
    }

    // extract the size guess
    private String getSizeGuess(String args) {
        String[] params = args.split(",");
        return params[1];
    }

    // extract the shape guess
    private String getShapeGuess(String args) {
        String[] params = args.split(",");
        return params[0];
    }

    // classify an two sides
    private String classify2Parameters(int a, int b) {
        if (a == b) {
            return twoParamGuesses[0];
        } else if (a == 0) {
            if (b > 0) {
                return twoParamGuesses[1];
            }
        } else if (a > 1) {
            if (b != 0) {
                return twoParamGuesses[1];
            }
        }
        return "";
    }

    // Classify four sides
    private String classify4Parameters(int a, int b, int c, int d) {
        if (a == b && c == d) {
            if (a != c) {
                return fourParamGuesses[1];
            } else
                return fourParamGuesses[0];
        } else if (b == d && c == a) {
            return fourParamGuesses[0];
        } else if (b == c && a == d) {
            return fourParamGuesses[0];
        }
        return "";
    }

    // Classify a triangle based on the length of its sides
    private String classify3Parameters(int a, int b, int c) {

        if ((a < (b + c)) && (b < (a + c)) && (c < (a + b))) {
            if (a == b && b == c) {
                return threeParamGuesses[0]; // Equilateral
            } else if (a != b && a != c && b != c) {
                return threeParamGuesses[2]; // Scalene
            } else {
                return threeParamGuesses[1]; // Isosceles
            }
        }
        return "";
    }
}

