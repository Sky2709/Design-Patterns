package creationalDP.prototypeDP;

public interface Prototype extends Cloneable {
    Prototype clone() throws CloneNotSupportedException;
}
