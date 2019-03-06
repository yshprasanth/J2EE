package core;

public class OuterClass {
    public static class InnerStaticClass{
        @Override
        public String toString() {
            return "InnerStaticClass";
        }
    }

    public class InnerMemberClass{
        @Override
        public String toString() {
            return "InnerMemberClass";
        }
    }

    public OuterClass() {

    }

    public void hello() {
        class InnerLocalClass{
            @Override
            public String toString() {
                return "InnerLocalClass";
            }
        }

        InnerLocalClass ilc = new InnerLocalClass();
        System.out.println(ilc);

        Object obj = new Object() {
            @Override
            public String toString() {
                return "AnonymousInnerClass";
            }
        };

        System.out.println(obj);

    }

    @Override
    public String toString() {
        return "OuterClass";
    }

    public static  void main(String[] args){
        OuterClass oc = new OuterClass();
        System.out.println(oc);

        InnerStaticClass isc = new OuterClass.InnerStaticClass();
        System.out.println(isc);

        OuterClass.InnerMemberClass imc = oc.new InnerMemberClass();
        System.out.println(imc);

        oc.hello();
    }

}
