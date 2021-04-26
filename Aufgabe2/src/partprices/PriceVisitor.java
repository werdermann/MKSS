package partprices;

public class PriceVisitor implements IVisitor {
    @Override
    public void visit(IPart part) {
        System.out.println("Sum: " + calculatePrice(part));
    }

    private double calculatePrice(IPart part) {
        double sum = part.getPrice();

        int i = 0;
        boolean outOfBounce = false;

        while (!outOfBounce) {
            try {
                IPart child = part.getChild(i);
                sum += calculatePrice(child);
                i++;
            } catch (Exception e) {
                outOfBounce = true;
            }
        }

        return sum;
    }
}
