public class Test{
    public static void main(String[] args){
        // 初始化Bean1
        Test t = new Test();
        Test.Bean1 bean1 = t.new Bean1();
        bean1.I++;
        // 初始化Bean2
        Bean2 bean2 = new Test.Bean2();
        bean2.J++;
        //初始化Bean3
        Bean.Bean3 bean3 = new Bean().new Bean3();
        bean3.k++;
    }
    class Bean1{

        public int I = 0;
    }

    static class Bean2{
        public int J = 0;
    }
}

class Bean{
    class Bean3{
        public int k = 0;
    }
}