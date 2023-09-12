package beforeTemplateMethod;

public class KimchiStew {
    public void makeKimchiStew(){
        makeBroth();
        addOnions();
        addGreenOnions();
        addKimchi();
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
    private void addKimchi(){
        System.out.println("김치를 넣는다.");
    }
}
