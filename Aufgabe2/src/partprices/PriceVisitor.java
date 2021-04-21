package partprices;

public class PriceVisitor implements IVisitor {
    @Override
    public void visit(IPart part) {
        calculatePrice(part);
        System.out.println("Sum: " + calculatePrice(part));
    }

    public double calculatePrice(IPart part) {
        double sum = part.getPrice();
        int i = 0;

        IPart child;

        boolean outOfBounce = false;

        /**
         * TODO: Change
         */

        while (!outOfBounce) {
                try {
                    child = part.getChild(i);
                    sum += child.getPrice();
                    System.out.println("Child: " + child + "   Sum: " + sum);
                    sum += calculatePrice(child);
                    i++;
                } catch (Exception e) {



                    if(e instanceof IndexOutOfBoundsException) {
                        outOfBounce = true;
                        System.out.println("Break Line");
                    }
                }




            }


        /*
        while (part.getChild(i) != null) {
            IPart child = part.getChild(i);
            sum += child.getPrice();
            sum += calculatePrice(child);
            i++;
        }

         */
        return sum;
    }
}
