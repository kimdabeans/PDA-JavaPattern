package afterTemplateMethod;

public abstract class Stew {

    public final void makeStew(){
        makeBroth();
        addOnions();
        addGreenOnions();
        addExtraIngredients();
    }
    private void makeBroth(){
        System.out.println("육수를 우린다.");
    }
    private void addOnions(){
        System.out.println("양파를 넣는다.");
    }
    private void addGreenOnions(){
        System.out.println("파를 넣는다.");
    }
    public abstract void addExtraIngredients();
}
