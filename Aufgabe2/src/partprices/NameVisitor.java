package partprices;

public class NameVisitor implements IVisitor {
    private String value;

    @Override
    public void visit(IPart part) {
        System.out.println(value + " is included in" + containsString(part));
    }

    public NameVisitor(String value) {
        this.value = value;
    }

    private String containsString(IPart part) {
        String result = "";

        if(part.getName().contains(value)) {
            result += (part.getName());
        }

        int i = 0;
        boolean outOfBounce = false;

        while (!outOfBounce) {
            try {
                IPart child = part.getChild(i);
                String childResult = containsString(child);

                /**
                 * If string is not empty
                 */
                if (childResult.trim().length() > 0) {
                    result += " " + childResult;
                }

                i++;
            } catch (Exception e) {
                outOfBounce = true;
            }
        }

        return result;
    }

}
