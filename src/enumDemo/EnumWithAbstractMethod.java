package enumDemo;

public enum EnumWithAbstractMethod {
    MONDAY {
        @Override
        public void dummyMethod() {
            System.out.println("abstract from monday");
        }
    },
    TUESDAY {
        @Override
        public void dummyMethod() {
            System.out.println("abstract from tuesday");
        }
    },
    WEDNESDAY {
        @Override
        public void dummyMethod() {
            System.out.println("abstract from wednesday");
        }
    },
    THURSDAY {
        @Override
        public void dummyMethod() {
            System.out.println("abstract from thursday");
        }
    };

    //This abstract method must be defined by all values
    public abstract void dummyMethod();
}
