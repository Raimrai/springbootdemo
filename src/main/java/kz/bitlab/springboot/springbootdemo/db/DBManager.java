package kz.bitlab.springboot.springbootdemo.db;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Items> items = new ArrayList<Items>();
    static {

        items.add(new Items(1l,"Iphone XS", 400, "256gb"));
        items.add(new Items(2l,"Iphone 13", 800, "512gb"));
        items.add(new Items(3l,"Iphone X", 300, "126gb"));
        items.add(new Items(4l,"Iphone 8", 200, "64gb"));
        items.add(new Items(5l,"Iphone 11", 500, "256gb"));
    }
    private static Long id = 6l;

    public static ArrayList<Items> getItems(){
        return items;
    }
    public static void addItem(Items item){
        item.setId(id);
        items.add(item);
        id++;
    }
    public static Items getItem(Long id){
        for (Items it : items){
            if (it.getId()==id)
                return it;
        }
        return null;
    }
}
