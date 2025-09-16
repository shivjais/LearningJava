package singletonDemo;
//this uses the concept of eager initialization & it is very fast
public class BillPughSolution {

    //now the instance is not loaded at the time of class loading. its is created when it is required
    private static class BillPughSolutionHelper {
        private static final BillPughSolution INSTANCE = new BillPughSolution();
    }

    public static BillPughSolution getInstance() {
        return BillPughSolutionHelper.INSTANCE;
    }
}
