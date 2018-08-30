package framework.controls;

import framework.interfaces.IClickable;

public class Link extends Button implements IClickable {

    public Link(String pageName, String controlLabel){
        super(pageName, controlLabel);
    }

}
