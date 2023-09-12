package beforeTemplateMethod;

public class SoybeanPasteStew {
    public void makeSoybeanPasteStew(){
        makeBroth();
        addOnions();
        addGreenOnions();
        addSoybeanPaste();
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
    private void addSoybeanPaste(){
        System.out.println("된장을 푼다.");
    }
}
