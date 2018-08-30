package framework.interfaces;

public interface IValuable extends IReadOnly {
    void setValue(String value);
    boolean isHighlighted();
}
