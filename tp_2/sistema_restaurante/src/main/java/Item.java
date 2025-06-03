public class Item {
    private String nameItem;
    private float price;
    private TypeItem typeItem;

    public Item(String nameItem, float price, TypeItem typeItem){
        this.nameItem = nameItem;
        this.price = price;
        this.typeItem = typeItem;
    }

    public float getPrice(){
        return price;
    }
    public TypeItem verTipo(){
        return typeItem;
    }
}
