package vti.testing_system_1.entity;

public class TypeQuestion {
    private int typeId;
    private TypeName typeName;

    private enum TypeName {
        Essay, Multiple_Choice
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "TypeId=" + typeId +
                ", typeName=" + typeName +
                '}';
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }
}
