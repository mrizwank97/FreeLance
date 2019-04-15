import java.util.ArrayList;

public class Trail
{
    public ArrayList<NatureFeature> features= new ArrayList<>();
    public Trail()
    {
        addCreek();
        addBridge();
        addFallenTree();
        addLandSlide();
    }
    
    public void addCreek(){
        NatureFeature creek = new NatureFeature(-2, "Creek");
        this.features.add(creek);
    }
    
    public void addBridge(){
        NatureFeature bridge = new NatureFeature(4, "Bridge");
        this.features.add(bridge);
    }
    
    public void addFallenTree(){
        NatureFeature fallenTree = new NatureFeature(-3, "Fallen Tree");
        this.features.add(fallenTree);
    }
    
    public void addLandSlide(){
        NatureFeature landSlide = new NatureFeature(-5, "LandSlide");
        this.features.add(landSlide);
    }
}
