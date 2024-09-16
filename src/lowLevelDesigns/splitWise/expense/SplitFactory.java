package lowLevelDesigns.splitWise.expense;

import lowLevelDesigns.splitWise.expense.split.EqualExpenseSplit;
import lowLevelDesigns.splitWise.expense.split.ExpenseSplit;
import lowLevelDesigns.splitWise.expense.split.PercentageExpenseSplit;
import lowLevelDesigns.splitWise.expense.split.UnEqualExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType){
        return switch (splitType) {
            case EQUAL -> new EqualExpenseSplit();
            case UNEQUAL -> new UnEqualExpenseSplit();
            case PERCENTAGE -> new PercentageExpenseSplit();
            default -> null;
        };
    }
}
