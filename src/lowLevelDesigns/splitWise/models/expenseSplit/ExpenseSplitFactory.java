package lowLevelDesigns.splitWise.models.expenseSplit;

public class ExpenseSplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType){
        return switch (splitType) {
            case EQUAL -> new EqualExpenseSplit();
            case UNEQUAL -> new UnEqualExpenseSplit();
            case PERCENTAGE -> new PercentageExpenseSplit();
            default -> null;
        };
    }
}
