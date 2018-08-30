package framework.common;

public class Factory {
    public static <T> T CreateControl(String pageName, String controlLabel) {
        try {
            String controlType = RepositoryParser.GetControlType(pageName, controlLabel);
            return (T) Class.forName("framework.controls." + controlType).getConstructor(String.class, String.class).newInstance(pageName, controlLabel);
        }catch(Exception ex){
            System.out.println(String.format("\r\nDEBUG: Cannot init control with page name '%1$s' and control label '%2$s', message:'%3$s'.", pageName, controlLabel, ex.getMessage()));
        }
        return null;
    }

    public static <T> T CreateControl(String controlLabel) throws Exception {
        return CreateControl(Page.currentPageLabel, controlLabel);
    }

}
