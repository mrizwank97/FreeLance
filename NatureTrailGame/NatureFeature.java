public class NatureFeature
{
    private int featurePosition;
    private int spacePenalty;
    private String featureType;

    public NatureFeature()
    {
        featurePosition = 0;
        spacePenalty = 0;
        featureType = "";
    }
    
    public NatureFeature(int spacePenalty, String featureType) 
    {
		super();
		this.spacePenalty = spacePenalty;
		this.featureType = featureType;
    }
    
    public int getFeaturePosition() {
        return featurePosition;
    }
    
    public void setFeaturePosition(int featurePosition) {
	this.featurePosition = featurePosition;
    }
    
    public int getSpacePenalty() {
	return spacePenalty;
    }
    
    public void setSpacePenalty(int spacePenalty) {
	this.spacePenalty = spacePenalty;
    }
    
    public String getFeatureType() {
	return featureType;
    }
    
    public void setFeatureType(String featureType) {
	this.featureType = featureType;
    }
    
}
