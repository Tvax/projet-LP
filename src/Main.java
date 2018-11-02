import models.Plate;

class Main{
    public static void main(String args[]){
        initLab();
    }

    private static void initLab(){
        initView(initModels());
    }

    private static void initView(Plate plate){

    }

    private static Plate initModels(){
        return new Plate();
    }
}